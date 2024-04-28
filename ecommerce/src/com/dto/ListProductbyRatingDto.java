package com.dto;

public class ListProductbyRatingDto {
	
        private int product_id;
        private String product_name;
        private int rating;
        private Double price;
    	 private int offer_percent;
    	 private int stock_quantity;
		public ListProductbyRatingDto(int product_id, String product_name, int rating, Double price, int offer_percent,
				int stock_quantity) {
			super();
			this.product_id = product_id;
			this.product_name = product_name;
			this.rating = rating;
			this.price = price;
			this.offer_percent = offer_percent;
			this.stock_quantity = stock_quantity;
		}
		public ListProductbyRatingDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getProduct_id() {
			return product_id;
		}
		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
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
		@Override
		public String toString() {
			return "ListProductbyRatingDto [product_id=" + product_id + ", product_name=" + product_name + ", rating="
					+ rating + ", price=" + price + ", offer_percent=" + offer_percent + ", stock_quantity="
					+ stock_quantity + "]";
		}
    	 
}
