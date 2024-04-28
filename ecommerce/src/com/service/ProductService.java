package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.daoImpl.CategoryDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.exception.ResourceNotFoundException;
import com.model.Cart;
import com.model.Order;
import com.model.Product;

public class ProductService {
	ProductDao dao=new ProductDaoImpl();
	CategoryDao Catdao=new CategoryDaoImpl();
	
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.findAll();
	}
	public List<Product> getProductByCategory(int category_id) throws SQLException, ResourceNotFoundException {
		
		boolean isCategoryIdValid = dao.findOne(category_id);
		if(!isCategoryIdValid)
			throw new ResourceNotFoundException("Category ID invalid");

		
		return dao.getProductByCategory(category_id) ;
	}
	
	public boolean isCategoryExists(int category_id) throws SQLException {
		boolean isCategoryExists = true;
		// TODO Auto-generated method stub
		if (!isCategoryExists) {
            System.out.println("Invalid category ID. Please enter a valid category ID.");
     }
		return Catdao.findOne(category_id);
	}
	public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		  if (minPrice < 0 || maxPrice < 0) {
		        throw new ResourceNotFoundException("Prices cannot be negative. Please enter positive values.");
		    }
		    
		    // Check if the minimum price is less than the maximum price
		    if (minPrice >= maxPrice) {
		        throw new ResourceNotFoundException("Minimum price must be less than the maximum price. Please enter valid values.");
		    }
		 return dao.getProductsByPriceRange(minPrice, maxPrice);
		
	}
	
	public void addProductToCart(Cart cart) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		
	    if (!isProductValid(cart.getProduct_id())) {
	        throw new ResourceNotFoundException("Product ID invalid");
	    }

	    // Validate if the quantity is valid
	   if (!isQuantityValid(cart.getProduct_id(), cart.getQuantity())) {
	    	
	        //throw new ResourceNotFoundException("Try Again");
	    }
	

	}
	
	public boolean isQuantityValid(int productId, int quantity) throws SQLException, ResourceNotFoundException {
		  Product product = dao.findByID(productId);
		    
		    
		    if (quantity <= 0) {
		        throw new ResourceNotFoundException("Quantity cannot be 0 or less.");
		    } else if (quantity > product.getStock_quantity()) {
		    	throw new ResourceNotFoundException("Quantity exceeds available stock quantity.");
		        
		    } else {
		        return true;
		    }
	    }
	 
	   public boolean isProductValid(int productId) throws SQLException, ResourceNotFoundException {
	       
	        return dao.isProductExists(productId);
	    }

	
	   public Product findById(int product_id) throws SQLException, ResourceNotFoundException {
		   boolean isProductIdValid = dao.findOne(product_id);
			if(!isProductIdValid)
				throw new ResourceNotFoundException("Product ID invalid");

			return dao.findByID(product_id);
		}
	   public double calculateTotalPrice(int product_id, int quantity) throws SQLException, ResourceNotFoundException {
			
			Product product = findById(product_id);
			  if (product != null) {
			        double price = product.getPrice();
			        double totalPrice = price * quantity;

			        // Apply discount if applicable
			        if (product.getOffer_percent() > 0 && product.getOffer_percent() <= 100) {
			            double discount = totalPrice * (product.getOffer_percent() / 100.0);
			            totalPrice -= discount;
			        }

			        return totalPrice;
			    } else {
			        
			        throw new ResourceNotFoundException("Product not found!");
			    }
		}
	   public double calculateTotalPrice1(int product_id, int stock_quantity) throws SQLException, ResourceNotFoundException {
			
			Product product1 = findById(product_id);
			  if (product1 != null) {
			        double price = product1.getPrice();
			        double totalPrice1 = price * stock_quantity;

			        // Apply discount if applicable
			        if (product1.getOffer_percent() > 0 && product1.getOffer_percent() <= 100) {
			           
			            double discountedPrice = totalPrice1 - (totalPrice1 *product1.getOffer_percent() / 100.0);
			            return discountedPrice;
			        }

			        return totalPrice1;
			    } else {
			        
			        throw new ResourceNotFoundException("Product not found!");
			    }
		}
	public void checkQuantity(Order order) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (!isQuantityValid(order.getProduct_id(), order.getQuantity())) {
		       
		    }
	
		
	}
	
	 
	   
}
	
	