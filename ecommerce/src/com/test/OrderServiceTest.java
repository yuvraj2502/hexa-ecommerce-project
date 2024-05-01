package com.test;

import static org.junit.Assert.assertEquals;


import java.sql.SQLException;

import org.junit.Test;

import com.exception.ResourceNotFoundException;
import com.service.OrderService;

public class OrderServiceTest {

	OrderService orderService=new OrderService();
	@Test
	public void softDeleteByid()throws SQLException,ResourceNotFoundException{
		 // Use case 1: Invalid ID
        int id = 3; 
        int order_id=100;
        boolean expectedErrorMessage = false;
        try {
           boolean actual= orderService.findorderforcustomer(id,order_id);
            assertEquals(expectedErrorMessage,actual);
        } catch (SQLException e) {
        	
        } catch (ResourceNotFoundException e) {
        	 
          
        }
        // Use case 2: 
        id = 3; 
        order_id=1466285631;
        boolean expectedErrorMessage1 =true;
        try {
        	boolean actual= orderService.findorderforcustomer(id,order_id);
            assertEquals(expectedErrorMessage1,actual);
        } catch (SQLException e) {
        	
        } catch (ResourceNotFoundException e) {
        	 
            
        }
    }
}	

