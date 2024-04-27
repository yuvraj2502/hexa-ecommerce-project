package com.controller;

// Author = Yuvraj
import java.sql.SQLException;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;

import com.model.User;
import com.service.UserService;

public class LoginController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();

		while (true) {
			System.out.println("\nWelcome to the Ecommerce.\n");
			System.out.println("Press 1. Login");
			System.out.println("Press 0. Exit");
			System.out.print("Enter a number to continue : ");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Eccomerce Application.");
				break;
			}
			
			switch (input) {
			case 1:
				try {
					System.out.print("\nEnter Email: ");
					sc.nextLine();
					String email = sc.next();
					System.out.print("Enter password: ");
					String password = sc.next();

					User userObj = userService.login(email, password);
					
					if (userObj.getRole().equalsIgnoreCase("CUSTOMER")) {
						System.out.println("Customer Menu");
					} else if(userObj.getRole().equalsIgnoreCase("VENDOR")){
						System.out.println("Vendor Menu");
						VendorController.vendorMenu();
					}else {
						System.out.println("Admin Menu");
						AdminController.adminMenu();
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (InvalidCredentialsException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid input given, try again later!!!");
			}
		}
		sc.close();
	}

}