package com.test;

import static org.junit.Assert.assertEquals;


import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.ResourceNotFoundException;
import com.service.CartService;

public class CartServiceTest {
  
	CartService cartService = new CartService();
	@Test
	public void deleteById()throws SQLException,ResourceNotFoundException{
		 // Use case 1: 
        int cart_id =1 ; 
        int customer_id=1;
        boolean expectedErrorMessage = true;
        try {
        	boolean actual=cartService.isCartBelongsToCustomer(cart_id,customer_id);
           
            Assert.assertEquals(expectedErrorMessage,actual);
        } catch (SQLException e) {
        	 
        } catch (ResourceNotFoundException e) {
        	 
           
        }
     // Use case 2: 
        cart_id =100; 
        customer_id=1;
        boolean expectedErrorMessage1 = false;
        try {
        	boolean actual=cartService.isCartBelongsToCustomer(cart_id,customer_id);
           
            Assert.assertEquals(expectedErrorMessage1,actual);
        } catch (SQLException e) {
        	 
        } catch (ResourceNotFoundException e) {
        	 
           
        }
	}
	
	
	
}
