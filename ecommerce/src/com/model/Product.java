package com.model;

public class Product {
	private int product_id;
	private String name;
	private String description;
	private Double price;
	private int offer_percent;
	private int stock_quantity;
	
	
	static private int category_id;
	static private int vendor_id;
	
	public Product(int product_id, String name, String description, Double price, int offer_percent, int stock_quantity,
			int category_id, int vendor_id) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.offer_percent = offer_percent;
		this.stock_quantity = stock_quantity;
		Product.category_id = category_id;
		Product.vendor_id = vendor_id;
	}

	public Product(int id, String name2, Double price2, int offerPercent, int stockQuantity, int stockQuantity2, int stockQuantity3) {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Product(int id, String name2, Double price2, int offerPercent, int stockQuantity) {
		// TODO Auto-generated constructor stub
	}

	public Product(int productid, int stockquantity) {
		// TODO Auto-generated constructor stub
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getOffer_percent() {
		return offer_percent;
	}

	public void setOffer_percent(int offer_percent) {
		this.offer_percent = offer_percent;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		Product.category_id = category_id;
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		Product.vendor_id = vendor_id;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", description=" + description + ", price="
				+ price + ", offer_percent=" + offer_percent + ", stock_quantity=" + stock_quantity + ", category_id="
				+ category_id + ", vendor_id=" + vendor_id + "]";
	}


	

}

