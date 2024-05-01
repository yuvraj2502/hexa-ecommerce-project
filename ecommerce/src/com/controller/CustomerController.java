package com.controller;

//AUTHOR SUNITHA AND SWARNALAKSHMI
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.CustomerAddressDetailsDto;
import com.dto.GetorderPayment;
import com.dto.ListProductbyRatingDto;
import com.dto.ListRefundbyOrderDto;
import com.dto.Listorderwithproduct;
import com.dto.OrderPaymentRefund;
import com.exception.ResourceNotFoundException;
import com.model.Address;
import com.model.Cart;
import com.model.Category;
import com.model.Order;
import com.model.Payment;
import com.model.Product;
import com.model.Review;
import com.service.AddressService;
import com.service.CartService;
import com.service.CategoryService;
import com.service.CustomerService;
import com.service.OrderService;
import com.service.PaymentService;
import com.service.ProductService;
import com.service.RefundService;
import com.service.ReviewService;

public class CustomerController {
	public static void main(String[] args, int customerId) throws SQLException {
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		ProductService productService = new ProductService();
		CategoryService categoryService = new CategoryService();
		OrderService orderService = new OrderService();
		ReviewService reviewService = new ReviewService();
		CartService cartService = new CartService();
		RefundService refundService = new RefundService();
		PaymentService paymentService = new PaymentService();
		AddressService addressService = new AddressService();
		System.out.println("Customer ID: " + customerId);

		while (true) {
			System.out.println("====================Customer Dashboard====================");
			System.out.println("Press 1:  Customer Profile"); // swarna
			System.out.println("press 2:  Display all products");
			System.out.println("press 3:  Display products with a specific category"); // swarna
			System.out.println("Press 4:  Display products between the specified price range"); // swarna
			System.out.println("press 5:  View product by rating"); // sunitha
			System.out.println("press 6:  Add Product to my Cart"); // swarna
			System.out.println("press 7:  View my Products in Cart"); // swarna
			System.out.println("press 8:  Delete Product from Cart"); // swarna
			System.out.println("press 9:  Place order from Cart Items"); // swarna
			System.out.println("press 10: Place order from product"); // sunitha
			System.out.println("press 11: Display my Order history"); // sunitha
			System.out.println("press 12: Cancel my Order (By SoftDelete)"); // sunitha
			System.out.println("press 13: View payment"); // sunitha
			System.out.println("press 14: Make payment"); // sunitha
			System.out.println("press 15: View Refund"); // sunitha
			System.out.println("press 16: Write review"); // sunitha
			System.out.println("press 17: OrderPaymentReview details"); // sunitha
			System.out.println("Press 18: Update Customer Address for existing customer"); // swarna
			System.out.println("Press 19: Add address (if your a new Customer)"); // swarna
			System.out.println("press 0: Exit");

			try {
				int input = sc.nextInt();
				if (input == 0) {
					System.out.println("Exiting Customer Module..");
					break;
				}
				switch (input) {
				case 1:
					try {

						List<CustomerAddressDetailsDto> list = customerService.getCustomerAddress(customerId);
						for (CustomerAddressDetailsDto a : list) {
							System.out.println(a);
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 2:

					try {
						List<Product> list = productService.findAll();
						for (Product a : list) {
							System.out.println(a);

						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:

					try {

						System.out.println("Different Categories");
						List<Category> list = categoryService.findAll();
						for (Category c : list) {
							System.out.println(c);
						}

						System.out.println("Enter Category ID : ");
						int category_id = sc.nextInt();
						if (!productService.isCategoryExists(category_id)) {
							System.out.println("Invalid category ID. Please enter a valid category ID.");
						}
						// productService.isCategoryExists(category_id); // to check if the category
						// exists

						List<Product> list1 = productService.getProductByCategory(category_id);

						if (list1 != null) {
							System.out.println("Number of products: " + list1.size());
							for (Product b : list1) {
								System.out.println(b);
							}
						} else {
							System.out.println("No products found for the specified category.");
						}

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 4:

					try {
						System.out.println("Enter minimum price: ");
						double minPrice = sc.nextDouble();
						System.out.println("Enter maximum price: ");
						double maxPrice = sc.nextDouble();

						List<Product> productList = productService.getProductsByPriceRange(minPrice, maxPrice);
						if (!productList.isEmpty()) {
							System.out.println("Products between " + minPrice + " and " + maxPrice + ":");
							for (Product product : productList) {
								System.out.println(product);
							}
						} else {
							System.out.println("No products found between " + minPrice + " and " + maxPrice + ".");
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 5:
					try {
						System.out.println("Enter rating value:");
						int rating_value = sc.nextInt();
						List<ListProductbyRatingDto> listproduct = reviewService.findprodcts(rating_value);

						for (ListProductbyRatingDto product : listproduct) {
							System.out.println(product);
						}

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 6:
					try {
						Cart cart = new Cart();
						Random random = new Random();
						int randomNumber = random.nextInt();
						int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
						cart.setCart_id(id);
						System.out.println(id);
						List<Product> list = productService.findAll();
						for (Product p : list) {
							System.out.println(p);
						}

						cart.setCustomer_id(customerId);
						System.out.println("Customer Id : " + customerId);

						System.out.println("Enter Product ID");
						int productId = sc.nextInt();
						cart.setProduct_id(productId);
						if (!productService.isProductValid(productId)) {
							throw new ResourceNotFoundException("Product ID invalid");
						}

						System.out.println("Enter Quantity");
						cart.setQuantity(sc.nextInt());
						productService.addProductToCart(cart);

						cartService.save(cart);
						System.out.println("Product Added to Cart");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 7:
					try {

						List<Cart> list = cartService.findAll(customerId);
						for (Cart c : list) {
							System.out.println(c);
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 8:

					try {

						List<Cart> list = cartService.findAll(customerId);
						for (Cart c : list) {
							System.out.println(c);
						}

						System.out.println("Enter Cart ID");
						int cartId = sc.nextInt();
						cartService.deleteById(cartId, customerId);
						System.out.println("Cart item deleted successfully.");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;
				case 9:
					try {
						Order order = new Order();

						List<Cart> list = cartService.findAll(customerId);
						for (Cart c : list) {
							System.out.println(c);
						}

						System.out.println("Enter cart id");
						int cartid = sc.nextInt();
						if (!cartService.isCartBelongsToCustomer(cartid, customerId)) {
							System.out.println("Cart ID does not belong to this customer.");
							break;
						}
						Random random = new Random();
						int randomNumber = random.nextInt();
						int order_id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
						order.setOrder_id(order_id);
						System.out.println(order_id);
						List<Cart> lica = cartService.findOne1(cartid);
						Cart cart1 = new Cart();
						for (Cart c : lica) {
							if (c.getCart_id() == cartid) {
								cart1 = c;
								break;
							}
						}

						System.out.println("Enter Quantity :" + order.setQuantity(cart1.getQuantity()));

						LocalDate currentDate = LocalDate.now(); // the current date
						String order_date = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE); // "YYYY-MM-DD"
						System.out.println("Order_date:" + order_date);

						Product product = productService.findById(cart1.getProduct_id());

						if (product != null) {
							double totalPrice = productService.calculateTotalPrice(cart1.getProduct_id(),
									cart1.getQuantity());

							System.out.println("TotalPrice:" + totalPrice);

						} else {
							// product is not found
							System.out.println("Product not found!");
						}

						System.out.println("Customer Id : " + order.setCustomer_id(cart1.getCustomer_id()));

						sc.nextLine();

						System.out.println("Product Id : " + order.setProduct_id(cart1.getProduct_id()));

						sc.nextLine();
						orderService.save(order);
						System.out.println("Product from cart has been ordered...");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;
				case 10:

					try {
						Order order = new Order();

						List<Product> list = productService.findAll();
						for (Product a : list) {
							System.out.println(a);

						}
						Random random = new Random();
						int randomNumber = random.nextInt();
						int order_id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
						order.setOrder_id(order_id);
						System.out.println(order_id);

						System.out.println("Enter product_id");
						int product_id = sc.nextInt();
						order.setProduct_id(product_id);

						Product product1 = productService.findById(product_id);

						System.out.println("Enter quantity");
						int stock_quantity = sc.nextInt();
						order.setQuantity(stock_quantity);

						productService.checkQuantity(order);

						double totalPrice1 = productService.calculateTotalPrice1(product1.getProduct_id(),
								stock_quantity);

						System.out.println("TotalPrice:" + totalPrice1);
						order.setTotal_price(totalPrice1);

						LocalDate currentDate = LocalDate.now();
						String order_date = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
						order.setOrder_date(order_date);
						System.out.println("Enter order_date:" + order_date);

						order.setCustomer_id(customerId);
						sc.nextLine();

						orderService.save(order);

						System.out.println("order placed successfully");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());

					}

					break;
				case 11:
					try {

						List<Listorderwithproduct> listord = orderService.listorderdetails(customerId);
						for (Listorderwithproduct o : listord) {
							System.out.println(o);
						}
					} catch (SQLException e) {
						System.out.println("An error occurred while retrieving refund details: " + e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;

				case 12:

					try {

						List<Order> list = orderService.findAll(customerId);
						for (Order a : list) {
							System.out.println(a);

						}
						System.out.println("Enter order_id");
						int orderid = sc.nextInt();
						orderService.softDeleteByid(customerId, orderid);

						System.out.println("order record de-activated");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 13:
					// not done
					try {

						List<GetorderPayment> list = orderService.getPaymentDetails(customerId);
						System.out.println("Customer Id : " + customerId);
						for (GetorderPayment p : list) {
							System.out.println(p);

						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 14:
					try {

						List<Order> list = orderService.findAll(customerId);
						for (Order a : list) {
							System.out.println(a);

						}
						Random random = new Random();
						int randomNumber = random.nextInt();
						int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
						System.out.println(id);

						System.out.println("Enter order_id");
						int order_id = sc.nextInt();
						sc.nextLine();
						orderService.findorderforcustomer(customerId, order_id);
						paymentService.checkorderid(order_id);

						LocalDate currentDate = LocalDate.now();
						String payment_date = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
						System.out.println("Enter payment_date:" + payment_date);

						System.out.println("Enter payment_type");
						String payment_type = sc.nextLine();

						System.out.println("Enter payment_amount");
						double payment_amount = sc.nextDouble();
						paymentService.checkpaymentamount(payment_amount, order_id);

						Payment payment = new Payment(id, payment_date, payment_type, payment_amount, order_id);
						int status = paymentService.insert(payment);
						if (status == 1)
							System.out.println("Payment record added to DB");
						else
							System.out.println("Insert operation failed");
					} catch (SQLException e) {
						System.out.println(e.getMessage());

					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;

				case 15:
					try {

						List<ListRefundbyOrderDto> listRef = refundService.findRefund(customerId);

						for (ListRefundbyOrderDto r : listRef) {
							System.out.println(r);
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 16:
					try {
						Review review = new Review();
						Random random_num = new Random();
						int randomnumber = random_num.nextInt();
						int review_id = randomnumber < 0 ? randomnumber * -1 : randomnumber;
						review.setReview_id(review_id);
						System.out.println(review_id);

						review.setCustomer_id(customerId);

						List<Product> prodlist = productService.findAll();
						for (Product p : prodlist) {
							System.out.println(p);
						}

						System.out.println("Enter product id");
						int product_id = sc.nextInt();
						if (!productService.isProductValid(product_id))
							throw new ResourceNotFoundException("Product ID invalid");
						review.setProduct_id(product_id);

						System.out.println("Enter review content");
						sc.nextLine();

						review.setReview_content(sc.nextLine());

						System.out.println("Enter rating");
						int rating_value = sc.nextInt();
						reviewService.findprodcts(rating_value);
						review.setRating(rating_value);

						LocalDate todayDate = LocalDate.now();
						String review_date = todayDate.format(DateTimeFormatter.ISO_LOCAL_DATE); // "YYYY-MM-DD"
						System.out.println("Enter review_date:" + review_date);
						review.setReview_date(review_date);
						sc.nextLine();

						reviewService.save(review);
						System.out.println("Thanks for Writting Review");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 17:
					try {

						List<OrderPaymentRefund> listdetails = orderService.fulldetailsregorder(customerId);
						if (listdetails.isEmpty()) {
							System.out.println("The Customer has no Orders");
						} else {
							for (OrderPaymentRefund r : listdetails) {

								System.out.println(r);

							}
						}

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 18:
					Address add = new Address();
					List<Address> listAdd = addressService.findAll(customerId);
					for (Address ad : listAdd) {
						System.out.println(ad);
						sc.nextLine();
					}

					System.out.println("Enter new Street : ");
					add.setStreet(sc.nextLine());

					System.out.println("Enter new city");
					add.setCity(sc.nextLine());
					System.out.println("Enter new State");
					add.setState(sc.nextLine());
					System.out.println("Enter new Country");
					add.setCountry(sc.nextLine());
					System.out.println("Enter new Pincode");
					add.setPincode(sc.nextInt());

					add.setCustomer_id(customerId);

					addressService.updateAddress(add);
					System.out.println("Address of the existing customer updated...");

					break;
				case 19:
					Address adr = new Address();

					Random random = new Random();
					int randomNumber = random.nextInt();
					int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
					adr.setAddress_id(id);
					adr.setCustomer_id(customerId);
					sc.nextLine();
					System.out.println("Enter Your Street");
					adr.setStreet(sc.nextLine());
					System.out.println("Enter Your City");
					adr.setCity(sc.nextLine());
					System.out.println("Enter Your Country");
					adr.setCountry(sc.nextLine());
					System.out.println("Enter Your Pincode");
					adr.setPincode(sc.nextInt());

					addressService.save(adr);
					System.out.println("Your address has been added...");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				sc.next();
				continue;
			}

		}
		// sc.close();
	}

	public static void customerMenu(int customerId) throws SQLException {
		String[] args = { "" };
		main(args, customerId);
	}
}
