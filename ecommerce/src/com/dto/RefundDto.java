package com.dto;
//Author- Vibhuti Shrivastava
public class RefundDto {
	
	private int RefundId;
	private String Date;
	private Double Amount;
	private int OrderId;
	private int paymentId;
	private String paymentDate;
	public RefundDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RefundDto(int refundId, String date, Double amount, int orderId, int paymentId, String paymentDate) {
		super();
		RefundId = refundId;
		Date = date;
		Amount = amount;
		OrderId = orderId;
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "RefundDto [RefundId=" + RefundId + ", Date=" + Date + ", Amount=" + Amount + ", OrderId=" + OrderId
				+ ", paymentId=" + paymentId + ", paymentDate=" + paymentDate + "]";
	}
	public int getRefundId() {
		return RefundId;
	}
	public void setRefundId(int refundId) {
		RefundId = refundId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}


