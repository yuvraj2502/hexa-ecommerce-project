package com.dto;
//Author- Vibhuti Shrivastava
public class PaymentDto {
	private int paymentId;
	private String Date;
	private String ModeOfPayment;
	private Double Amount;
	private int orderID;
	private String orderDate;
	private int customerID;
	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDto(int paymentId, String date, String modeOfPayment, Double amount, int orderID, String orderDate,
			int customerID) {
		super();
		this.paymentId = paymentId;
		Date = date;
		ModeOfPayment = modeOfPayment;
		Amount = amount;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "PaymentDto [paymentId=" + paymentId + ", Date=" + Date + ", ModeOfPayment=" + ModeOfPayment
				+ ", Amount=" + Amount + ", orderID=" + orderID + ", orderDate=" + orderDate + ", customerID="
				+ customerID + "]";
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getModeOfPayment() {
		return ModeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		ModeOfPayment = modeOfPayment;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
