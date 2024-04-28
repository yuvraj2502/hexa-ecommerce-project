package com.dto;

public class ListRefundbyOrderDto {
	private int refund_id;
    private String refund_date;
    private double refund_amount;
    private int order_id;
    private String order_date;
    private double total_price;
    private int customer_id;
	public ListRefundbyOrderDto(int refund_id, String refund_date, double refund_amount, int order_id,
			String order_date, double total_price, int customer_id) {
		super();
		this.refund_id = refund_id;
		this.refund_date = refund_date;
		this.refund_amount = refund_amount;
		this.order_id = order_id;
		this.order_date = order_date;
		this.total_price = total_price;
		this.customer_id = customer_id;
	}
	public ListRefundbyOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(int refund_id) {
		this.refund_id = refund_id;
	}
	public String getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	public double getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(double refund_amount) {
		this.refund_amount = refund_amount;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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
	@Override
	public String toString() {
		return "ListRefundbyOrderDto [refund_id=" + refund_id + ", refund_date=" + refund_date + ", refund_amount="
				+ refund_amount + ", order_id=" + order_id + ", order_date=" + order_date + ", total_price="
				+ total_price + ", customer_id=" + customer_id + "]";
	}
	
}
