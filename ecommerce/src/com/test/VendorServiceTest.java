package com.test;
//Author- Vibhuti Shrivastava

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import com.exception.ResourceNotFoundException;
import com.service.VendorService;

public class VendorServiceTest {
	VendorService vendorService=new VendorService();

//2
	@Test
	public void deleteByid() {
        // Use case 1: Invalid ID
        int id = 100; 
        String expectedErrorMessage = "Id given is Invalid!!";
        try {
            vendorService.deleteByid(id);
            
        } catch (SQLException e) {
        	 fail(e.getMessage());
        } catch (ResourceNotFoundException e) {
        	 
            assertEquals(expectedErrorMessage, e.getMessage());
        }
   
    }


}
