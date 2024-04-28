package com.model;

public class Payment {

	private int payment_id;
    private String payment_date;
    private String payment_type;
    private double payment_amount;
    
    
    private int order_id;


	public Payment(int payment_id, String payment_date, String payment_type, double payment_amount, int order_id) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.payment_type = payment_type;
		this.payment_amount = payment_amount;
		this.order_id = order_id;
	}


	public Payment() {
		super();
		// TODO Auto-generated constructor stub
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
		return payment_type;
	}


	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
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


	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_date=" + payment_date + ", payment_type=" + payment_type
				+ ", payment_amount=" + payment_amount + ", order_id=" + order_id + "]";
	}
    
    
}
