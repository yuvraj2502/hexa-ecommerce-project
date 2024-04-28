package com.dto;

public class OrderPaymentRefund {
	 private int order_id;
     private int quantity;
     private double total_price;
     private int product_id;
     private String name;
     private int payment_id;
     private double payment_amount;
     private int refund_id;
     private double refund_amount;
	public OrderPaymentRefund(int order_id, int quantity, double total_price, int product_id, String name,
			int payment_id, double payment_amount, int refund_id, double refund_amount) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.total_price = total_price;
		this.product_id = product_id;
		this.name = name;
		this.payment_id = payment_id;
		this.payment_amount = payment_amount;
		this.refund_id = refund_id;
		this.refund_amount = refund_amount;
	}
	public OrderPaymentRefund() {
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
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public double getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(double payment_amount) {
		this.payment_amount = payment_amount;
	}
	public int getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(int refund_id) {
		this.refund_id = refund_id;
	}
	public double getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(double refund_amount) {
		this.refund_amount = refund_amount;
	}
	@Override
	public String toString() {
		return "OrderPaymentRefund [order_id=" + order_id + ", quantity=" + quantity + ", total_price=" + total_price
				+ ", product_id=" + product_id + ", name=" + name + ", payment_id=" + payment_id + ", payment_amount="
				+ payment_amount + ", refund_id=" + refund_id + ", refund_amount=" + refund_amount + "]";
	}
     
     
}
