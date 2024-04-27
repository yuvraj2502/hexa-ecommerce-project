package com.controller;
//Author = Yuvraj
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.CustomerDto;
import com.dto.OrderStatsDto;
import com.dto.ProductDto;
import com.dto.VendorDto;
import com.exception.InvalidCustomerIdException;
import com.exception.ResourceNotFoundException;
import com.model.User;
import com.model.Vendor;
import com.service.AdminService;
import com.service.UserService;

public class AdminController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserService userService = new UserService();
		AdminService adminService = new AdminService();

		try {
			while (true) {
				System.out.println("\nAdmin Dashboard\n");
				System.out.println("1. Show all Customer");
				System.out.println("2. Show all Vendor");
				System.out.println("3. Add a new Vendor");
				System.out.println("4. Delete Customer");
				System.out.println("5. Delete Vendor");
				System.out.println("6. Show all products by vendorId");
				System.out.println("7. Show Order Stats");
				System.out.println("8. Logout");
				System.out.println();
				System.out.print("Press a number to continue: ");

				// Taking user input to process
				int input = sc.nextInt();
				System.out.println();

				// If logout break the loop
				if (input == 8) {
					System.out.println("Thanks");
					break;
				}

				switch (input) {
				case 1:
					try {

						List<CustomerDto> customers = adminService.getAll();

						System.out.println("+----------------------+------------------+---------------------------+");
						System.out.println("|    Customer ID       |      Name        |          Email            |");
						System.out.println("+----------------------+------------------+---------------------------+");

						for (CustomerDto c : customers) {
							System.out.printf("| %-20s | %-16s | %-25s |\n", c.getCustomerId(), c.getName(),
									c.getEmail());
						}
						System.out.println("+----------------------+------------------+---------------------------+");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 2:
					try {
						List<VendorDto> vendor = adminService.findAll();

						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");
						System.out.println(
								"|     Vendor ID        |         Name         |           Email            |    Business Name     |         Address        |");
						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");

						for (VendorDto v : vendor) {
							System.out.printf("| %-20s | %-20s | %-26s | %-20s | %-22s |\n", v.getVendorId(),
									v.getName(), v.getEmail(), v.getBusinessName(), v.getAddress());
						}

						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					Vendor vendor = new Vendor();
					User user = new User();
					sc.nextLine();

					Random random = new Random();
					int randomNum = random.nextInt();
					int userId = randomNum > 0 ? randomNum : randomNum * -1;

					int vendorId = random.nextInt();
					vendorId = vendorId > 0 ? vendorId : vendorId * -1;

					// setting user id
					user.setUserId(userId);

					System.out.print("Enter Email : ");
					user.setEmail(sc.next());

					System.out.print("Enter Password : ");
					user.setPassword(sc.next());

					sc.nextLine();
					System.out.print("Enter Name: ");
					vendor.setVendorName(sc.nextLine());

					System.out.print("Enter Business Name : ");
					vendor.setBusinessName(sc.nextLine());

					System.out.print("Enter City: ");
					vendor.setVendorAddress(sc.nextLine());

					user.setRole("Vendor");
					vendor.setUserId(userId);
					vendor.setVendorId(vendorId);

					try {
						userService.save(user);
						adminService.save(vendor);
						System.out.println("Vendor added successfully\n");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

					break;

				case 4:
					try {
						List<CustomerDto> customer = adminService.getAll();

						System.out.println("+----------------------+------------------+---------------------------+");
						System.out.println("|    Customer ID       |      Name        |          Email            |");
						System.out.println("+----------------------+------------------+---------------------------+");

						for (CustomerDto c : customer) {
							System.out.printf("| %-20s | %-16s | %-25s |\n", c.getCustomerId(), c.getName(),
									c.getEmail());
						}
						System.out.println("+----------------------+------------------+---------------------------+");

						System.out.print("Enter the Customer Id : ");
						int id = sc.nextInt();

						int status = adminService.deleteCustomer(id);
						if (status == 1)
							System.out.println("Customer Deleted Successfully");
						else
							System.out.println("Operation Failed");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("Invalid Input");
					} catch (InvalidCustomerIdException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 5:
					try {
						List<VendorDto> allVendor = adminService.findAll();

						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");
						System.out.println(
								"|     Vendor ID        |         Name         |           Email            |    Business Name     |         Address        |");
						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");

						for (VendorDto v : allVendor) {
							System.out.printf("| %-20s | %-20s | %-26s | %-20s | %-22s |\n", v.getVendorId(),
									v.getName(), v.getEmail(), v.getBusinessName(), v.getAddress());
						}

						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");

						System.out.print("Enter the Vendor Id : ");
						int id = sc.nextInt();

						int status = adminService.deleteVendor(id);
						if (status == 1)
							System.out.println("Vendor Deleted Successfully");
						else
							System.out.println("Operation Failed");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("Invalid Input");
					}
					break;

				case 6:
					try {
						List<VendorDto> allVendor = adminService.findAll();

						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");
						System.out.println(
								"|     Vendor ID        |         Name         |           Email            |    Business Name     |         Address        |");
						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");

						for (VendorDto v : allVendor) {
							System.out.printf("| %-20s | %-20s | %-26s | %-20s | %-22s |\n", v.getVendorId(),
									v.getName(), v.getEmail(), v.getBusinessName(), v.getAddress());
						}

						System.out.println(
								"+----------------------+----------------------+----------------------------+----------------------+------------------------+");
						System.out.println();

						System.out.print("Enter the Vendor Id : ");
						int id = sc.nextInt();
						List<ProductDto> products = adminService.getAllProducts(id);

						if (products.size() > 0) {
							System.out.println(
									"+--------------------------------+----------------------+----------------------+----------------------+-----------------------+");
							System.out.println(
									"| Name                           | Price                | Offer Percent        | Stock Quantity       | Category              |");
							System.out.println(
									"+--------------------------------+----------------------+----------------------+----------------------+-----------------------+");

							for (ProductDto p : products) {
								System.out.printf("| %-30s | %-20.2f | %-20d | %-20d | %-21s |\n", p.getName(),
										p.getPrice(), p.getOfferPercent(), p.getStockQuantity(), p.getCategory());
							}

							System.out.println(
									"+--------------------------------+----------------------+----------------------+----------------------+-----------------------+");

						} else {
							System.out.println("No products from this vendor");
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;

				case 7:
					try {
						List<OrderStatsDto> orderStats = adminService.OrderStats();
						System.out.println("+---------------+--------------------------------+---------------+");
						System.out.println("| Customer ID   | Customer Name                  | No. of Orders |");
						System.out.println("+---------------+--------------------------------+---------------+");

						for (OrderStatsDto o : orderStats) {
							System.out.printf("| %-13d | %-30s | %-13d |%n", o.getCustomerId(), o.getCustomerName(),
									o.getNoOfOrders());
						}

						System.out.println("+---------------+--------------------------------+---------------+");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				default:
					System.out.println("Invalid Input");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		//sc.close();
	}
	
	public static void adminMenu() {
		String[] args = {""};
		main(args);
	}
}
