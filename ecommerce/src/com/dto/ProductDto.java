package com.dto;
//Author = Yuvraj
public class ProductDto {

	private String name;
	private String description ;
	private double price;
	private int offerPercent;
	private int stockQuantity;
	private String category;
	
	public ProductDto() {
		
	}

	public ProductDto(String name, String description, double price, int offerPercent, int stockQuantity,
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.offerPercent = offerPercent;
		this.stockQuantity = stockQuantity;
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getOfferPercent() {
		return offerPercent;
	}


	public void setOfferPercent(int offerPercent) {
		this.offerPercent = offerPercent;
	}


	public int getStockQuantity() {
		return stockQuantity;
	}


	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", description=" + description + ", price=" + price + ", offerPercent="
				+ offerPercent + ", stockQuantity=" + stockQuantity + ", category=" + category + "]";
	}
	
	
	
}
