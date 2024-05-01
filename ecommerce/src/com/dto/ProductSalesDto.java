package com.dto;

public class ProductSalesDto {
	private int productId;
	private String name;
	private double price;
	private int productSold;
	
	public ProductSalesDto(int productId, String name, double price, int productSold) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.productSold = productSold;
	}
	
	public ProductSalesDto() {
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductSold() {
		return productSold;
	}
	public void setProductSold(int productSold) {
		this.productSold = productSold;
	}

	@Override
	public String toString() {
		return "ProductSalesDto [productId=" + productId + ", name=" + name + ", price=" + price + ", productSold="
				+ productSold + "]";
	}
	
	
}
