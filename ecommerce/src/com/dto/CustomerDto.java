package com.dto;
//Author = Yuvraj
public class CustomerDto {
	private int customerId;
	private String name;
	private String email;
	
	
	public CustomerDto() {		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", name=" + name + ", email=" + email + "]";
	}


	public CustomerDto(int customerId, String name, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
	}

	
	
}
