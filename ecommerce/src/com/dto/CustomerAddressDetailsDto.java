package com.dto;

public class CustomerAddressDetailsDto {
	private int customer_id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	public CustomerAddressDetailsDto(int customer_id, String name, String street, String city, String state, String country,
			int pincode) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public CustomerAddressDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "CustomerDto [customer_id=" + customer_id + ", name=" + name + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
}
}
