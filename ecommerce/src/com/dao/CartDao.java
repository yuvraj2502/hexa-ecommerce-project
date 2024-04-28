package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Cart;

public interface CartDao {
	int save(Cart cart) throws SQLException;
	public List<Cart> findAll(int customerid) throws SQLException;
	void deleteById(int id) throws ResourceNotFoundException, SQLException;
	public boolean isCartBelongsToCustomer(int cartId, int customerid) throws SQLException, ResourceNotFoundException;
	List<Cart> findOne1(int id)throws SQLException;
	
}
