package com.dto;
//Author = Yuvraj
public class OrderStatsDto {
	private int customerId;
	private String customerName;
	private int noOfOrders;
	
	public OrderStatsDto(int customerId, String customerName, int noOfOrders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.noOfOrders = noOfOrders;
	}

	public OrderStatsDto() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	
}
