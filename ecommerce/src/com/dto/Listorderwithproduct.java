package com.dto;

public class Listorderwithproduct {

	private int order_id;
    private int quantity;
    private String order_date;
    private String status;
    private double total_price;
	private String name;
	private double offer_percent;
	public Listorderwithproduct(int order_id, int quantity, String order_date, String status, double total_price,
			String name, double offer_percent) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.order_date = order_date;
		this.status = status;
		this.total_price = total_price;
		this.name = name;
		this.offer_percent = offer_percent;
	}
	public Listorderwithproduct() {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getOffer_percent() {
		return offer_percent;
	}
	public void setOffer_percent(double offer_percent) {
		this.offer_percent = offer_percent;
	}
	@Override
	public String toString() {
		return "ListorderwithproductDto [order_id=" + order_id + ", quantity=" + quantity + ", order_date=" + order_date
				+ ", status=" + status + ", total_price=" + total_price + ", name=" + name + ", offer_percent="
				+ offer_percent + "]";
	}
	
	
	
	
}
