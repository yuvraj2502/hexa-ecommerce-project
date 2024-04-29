package com.model;
//Author- Vibhuti Shrivastava

public class Orders {
     private int order_id;
     private int quantity;
     private String order_date;
     private String status;
     private double total_price;
	 
     private int customer_id;
     private int product_id;
   
	public Orders(int order_id, int quantity, String order_date, String status, double total_price, int customer_id,
			int product_id) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.order_date = order_date;
		this.status = status;
		this.total_price = total_price;
		this.customer_id = customer_id;
		this.product_id = product_id;
		
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", quantity=" + quantity + ", order_date=" + order_date + ", status="
				+ status + ", total_price=" + total_price + ", customer_id=" + customer_id + ", product_id="
				+ product_id + "]";
	}
     
}