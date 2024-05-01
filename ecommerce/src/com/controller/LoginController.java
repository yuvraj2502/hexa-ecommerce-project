package com.controller;

// Author = Yuvraj
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;
import com.exception.InvalidLoginInput;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;
import com.service.UserService;

public class LoginController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();

		while (true) {
			try {
				System.out.println("\n==========================================");
				System.out.println("        Welcome to the Ecommerce   ");
				System.out.println("==========================================\n");
				System.out.println("Press 1. Customer Sign up");
				System.out.println("Press 2. Login");
				System.out.println("Press 0. Exit");
				System.out.print("Enter a number to continue : ");
				int input = sc.nextInt();
				System.out.println();
				if (input == 0) {
					System.out.println("Exiting Eccomerce Application.");
					break;
				}

				switch (input) {
				case 1:

					Random random = new Random();
					int randomNum = random.nextInt();
					int userId = randomNum > 0 ? randomNum : randomNum * -1;

					randomNum = random.nextInt();
					int custId = randomNum > 0 ? randomNum : randomNum * -1;

					sc.nextLine();
					System.out.print("Enter Name : ");
					String customerName = sc.nextLine().trim();

					System.out.print("Enter Email : ");
					String customerEmail = sc.next().trim();

					System.out.print("Enter Password : ");
					String customerPassword = sc.next().trim();

					// Creating User
					User user = new User(userId, customerEmail, customerPassword, "customer");
					userService.save(user);

					// Creating Customer
					Customer customer = new Customer(custId, customerName, userId);

					int status = userService.insert(customer);
					if (status == 1) {
						System.out.println("\nSignup Done Successfully");
					} else {
						System.out.println("Oops! Something went wrong. Please try again");
					}

					break;
				case 2:

					System.out.print("Enter Email: ");
					sc.nextLine();
					String email = sc.next().trim();
					System.out.print("Enter password: ");
					String password = sc.next().trim();

					User userObj = userService.login(email, password);

					if (userObj.getRole().equalsIgnoreCase("CUSTOMER")) {
						int customerId = userService.getCustomerIdByUserId(userObj.getUserId()); // customer module
						CustomerController.customerMenu(customerId);
					} else if (userObj.getRole().equalsIgnoreCase("VENDOR")) {
						Vendor vendor = userService.getVendor(userObj.getUserId());

						if (vendor.getIsLoginFirst()) {
							System.out.println("You are login first time you need to change your Password");
							System.out.print("Enter new password: ");
							String pass = sc.next();
							userObj.setPassword(pass);

							User updatedUser = new User(userObj.getUserId(), userObj.getEmail(), userObj.getPassword(),
									userObj.getRole());
							userService.updateUser(updatedUser);

							vendor.setLoginFirst(false);
							userService.updateVendorLogin(vendor);
							System.out.println("Password Reset Successfully");
							System.out.println("Please Login with the new Credentials");

							break;
						}
						VendorController.vendorMenu();
					} else {
						AdminController.adminMenu();
					}
					break;
				default:
					System.out.println("Invalid input given, try again later!!!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				sc.next();
				continue;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (InvalidCredentialsException e) {
				System.out.println(e.getMessage());
			}catch (InvalidLoginInput e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

}