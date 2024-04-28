package com.model;

public class Review {
	private int review_id;
	private String review_content;
	private int rating;
	private String review_date;
	
	private int customer_id;
	private int product_id;
	public Review(int review_id, String review_content, int rating, String review_date, int customer_id,
			int product_id) {
		super();
		this.review_id = review_id;
		this.review_content = review_content;
		this.rating = rating;
		this.review_date = review_date;
		this.customer_id = customer_id;
		this.product_id = product_id;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", review_content=" + review_content + ", rating=" + rating
				+ ", review_date=" + review_date + ", customer_id=" + customer_id + ", product_id=" + product_id + "]";
	}
	
	
}
