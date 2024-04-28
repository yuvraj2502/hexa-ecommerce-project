package com.dto;

public class GetorderPayment {
 private int payment_id;
 private String payment_date;
 private String Payment_type;
 private double payment_amount;
 private int order_id;
 private double total_price;
 private int customer_id;
 private String order_date;
 
 @Override
public String toString() {
	return "GetorderPayment [payment_id=" + payment_id + ", payment_date=" + payment_date + ", Payment_type="
			+ Payment_type + ", payment_amount=" + payment_amount + ", order_id=" + order_id + ", total_price="
			+ total_price + ", customer_id=" + customer_id + ", order_date=" + order_date + "]";
}
public int getPayment_id() {
	return payment_id;
}
public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}
public String getPayment_date() {
	return payment_date;
}
public void setPayment_date(String payment_date) {
	this.payment_date = payment_date;
}
public String getPayment_type() {
	return Payment_type;
}
public void setPayment_type(String payment_type) {
	Payment_type = payment_type;
}
public double getPayment_amount() {
	return payment_amount;
}
public void setPayment_amount(double payment_amount) {
	this.payment_amount = payment_amount;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
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
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public GetorderPayment() {
	super();
	// TODO Auto-generated constructor stub
}
public GetorderPayment(int payment_id, String payment_date, String payment_type, double payment_amount, int order_id,
		double total_price, int customer_id, String order_date) {
	super();
	this.payment_id = payment_id;
	this.payment_date = payment_date;
	Payment_type = payment_type;
	this.payment_amount = payment_amount;
	this.order_id = order_id;
	this.total_price = total_price;
	this.customer_id = customer_id;
	this.order_date = order_date;
}

 
}
