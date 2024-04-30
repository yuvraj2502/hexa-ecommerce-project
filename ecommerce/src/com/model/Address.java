package com.model;
//Author - swarna
public class Address {
private int address_id;
private int customer_id;
private String street;
private String city;
private String state;
private String country;
private int pincode;
public Address(int address_id, int customer_id, String street, String city, String state, String country, int pincode) {
	super();
	this.address_id = address_id;
	this.customer_id = customer_id;
	this.street = street;
	this.city = city;
	this.state = state;
	this.country = country;
	this.pincode = pincode;
}
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
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
	return "Address [address_id=" + address_id + ", customer_id=" + customer_id + ", street=" + street + ", city="
			+ city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
}



}