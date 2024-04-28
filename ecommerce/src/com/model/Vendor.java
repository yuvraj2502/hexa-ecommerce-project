package com.model;
//Author = Yuvraj
public class Vendor {
	private int vendorId;    
	private int userId;
	private String businessName ;
	private String vendorAddress;
	private String vendorName;
	private boolean isLoginFirst;

	public Vendor() {
		
	}

	public Vendor(int vendorId, int userId, String businessName, String vendorAddress, String vendorName) {
		super();
		this.vendorId = vendorId;
		this.userId = userId;
		this.businessName = businessName;
		this.vendorAddress = vendorAddress;
		this.vendorName = vendorName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public boolean getIsLoginFirst() {
		return isLoginFirst;
	}

	public void setLoginFirst(boolean isLoginFirst) {
		this.isLoginFirst = isLoginFirst;
	}

	
	
}
