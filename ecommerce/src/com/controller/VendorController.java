package com.controller;

import java.sql.SQLException;
import com.model.Orders;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.PaymentDto;
import com.dto.RefundDto;
import com.exception.ResourceNotFoundException;
import com.model.Product;
import com.service.VendorService;

public class VendorController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendorService vendorService = new VendorService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n -------------------- Vendor Page --------------------");
			System.out.println(" -----------------------------------------------------");
			System.out.println("Press 1. Add Products ");
			System.out.println("Press 2. Delete Product ");
			System.out.println("Press 3. View All Product");
			System.out.println("Press 4. Update Stock for Product ");
			System.out.println("Press 5. View Orders");
			System.out.println("Press 6. Update Status of Order");
			System.out.println("Press 7. Check Payments");
			System.out.println("Press 8. Approved Refund");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Vendor Module..");
				break;
			}

			switch (input) {
//1. Add Products
			case 1: // add/ insert the product by vendor

				/* Generating and assigning id to product obj */
				Random random = new Random();
				int randomNumber = random.nextInt();
				int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;

				/* Reading name and assigning to product obj */
				System.out.println("Enter Product Name");
				sc.nextLine();
				String name = sc.nextLine();

				/* Reading description and assigning to product obj */
				System.out.println("Enter Description");
				String description = sc.nextLine();

				System.out.println("Enter price");
				Double price = sc.nextDouble();

				System.out.println("Enter offer persent");
				int offer_percent = sc.nextInt();

				System.out.println("Enter Stock Quantity");
				int stock_quantity = sc.nextInt();

				System.out.println("Enter category id");
				int category_id = sc.nextInt();

				System.out.println("enter Vendor id");
				int vendor_id = sc.nextInt();

				Product product = new Product(id, name, description, price, offer_percent, stock_quantity, category_id,
						vendor_id);
				try {
					int status = vendorService.insert(product);
					if (status == 1)
						System.out.println("product record added to DB");
					else
						System.out.println("Insert op failed");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

// 2. Delete Product		
			case 2:
				try {
					List<Product> list = vendorService.findAll();
					for (Product p : list) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Enter Product ID to Delete");
				try {
					vendorService.deleteByid(sc.nextInt());
					System.out.println("product record deleted..");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

// 3. View All Product		
			case 3: // view all the products

				try {
					List<Product> list = vendorService.findAll();
					for (Product p : list) {
						System.out.println(p);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

// 4. update product
			case 4:
				// update product done by vendor
				try {
					List<Product> list = vendorService.findAll();
					for (Product p : list) {
						System.out.println(p);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter product id ");
				int productId = sc.nextInt();

				System.out.println("Enter New Stock Quantity");
				int newQuantity = sc.nextInt();
				try {
					vendorService.updateStockQuantity(productId, newQuantity);
					System.out.println("Stock quantity updated successfully.");
					;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

// 5. View Orders
			case 5: // view all orders made by customer
				try {
					List<Orders> list = vendorService.findAllo();
					for (Orders o : list) {
						System.out.println(o);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

// 6. update status of order
			case 6:
				try {
					List<Orders> list = vendorService.findAllo();
					for (Orders o : list) {
						System.out.println(o);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter product id ");
				int proId = sc.nextInt();

				System.out.println("Enter Updated Status of Order");
				sc.nextLine();
				String orderStatus = sc.nextLine();
				try {
					vendorService.updateOrderStatus(proId, orderStatus);
					System.out.println("Status updated successfully.");
					;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

// 7. Check Payments      
			case 7:
				try {
					List<PaymentDto> list = vendorService.getCheckPayment();
					for (PaymentDto p : list) {
						// System.out.println(v.getPaymentId(),v.getDate(),v.getModeOfPayment(),v.getAmount(),v.getOrderId(),v.getOrderDate(),v.getStatus());
						System.out.println(p);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

// 8. Approved Refund
			case 8:
				try {
					List<RefundDto> list = vendorService.getApprovedRefund();
					for (RefundDto r : list) {
						System.out.println(r);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
			}

		}
		//sc.close();

	}

	public static void vendorMenu() {
		String[] args = { "" };
		main(args);
	}

}
