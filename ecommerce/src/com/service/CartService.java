package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.daoImpl.*;

import com.exception.ResourceNotFoundException;
import com.model.Cart;

public class CartService {
	CustomerDao dao=new CustomerDaoImpl();
	ProductDao productDao=new ProductDaoImpl();
	CartDao cartDao=new CartDaoImpl();
	public void save(Cart cart) throws SQLException, ResourceNotFoundException {
		
		boolean isProdIdValid = productDao.findOne(cart.getProduct_id());
		if(!isProdIdValid)
			throw new ResourceNotFoundException("Product ID invalid");
		
		cartDao.save(cart);
		
	}
	
	public List<Cart> findAll(int customerid) throws SQLException, ResourceNotFoundException{
	
		return cartDao.findAll(customerid);
	}
	public void deleteById(int cartId, int customerid) throws SQLException, ResourceNotFoundException {
	    
	    if (!isCartBelongsToCustomer(cartId, customerid)) {
	        throw new ResourceNotFoundException("Cart ID does not belong to this customer");
	    }

	   
	    cartDao.deleteById(cartId);
	}

	public boolean isCartBelongsToCustomer(int cartId, int customerid) throws SQLException, ResourceNotFoundException {
	    
	    return cartDao.isCartBelongsToCustomer(cartId, customerid);
	}
	public List<Cart> findOne1(int cartid) throws SQLException {
		// TODO Auto-generated method stub
		
		return cartDao.findOne1(cartid);
	}
}
