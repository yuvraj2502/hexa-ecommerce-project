package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Product;

public interface ProductDao {
	List<Product> findAll()throws SQLException;
	List<Product> getProductByCategory(int category_id) throws SQLException;
	boolean findOne(int product_id) throws SQLException;
	List<Product> getProductsByPriceRange(double minPrice, double maxPrice)throws SQLException,ResourceNotFoundException;
	boolean isProductExists(int productId) throws SQLException, ResourceNotFoundException;
	
	Product findByID(int product_id)throws SQLException;
	
	
	
}
