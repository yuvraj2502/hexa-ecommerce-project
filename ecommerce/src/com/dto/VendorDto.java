package com.dto;
//Author = Yuvraj
public class VendorDto {
	private int vendorId;
	private String name;
	private String email;
	private String businessName;
	private String address;

	public VendorDto() {
	}

	@Override
	public String toString() {
		return "VendorDto [vendorId=" + vendorId + ", name=" + name + ", email=" + email + ", businessName="
				+ businessName + ", address=" + address + "]";
	}

	public VendorDto(int vendorId, String name, String email, String businessName, String address) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.email = email;
		this.businessName = businessName;
		this.address = address;
	}

	public int getVendorId() {
		return vendorId;
	}


	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
