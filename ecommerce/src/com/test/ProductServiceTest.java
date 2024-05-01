package com.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exception.ResourceNotFoundException;
import com.service.ProductService;

public class ProductServiceTest {
ProductService productService=new ProductService();
	
	@Test
	//use case:1
	public void calculateTotalPrice1() throws SQLException, ResourceNotFoundException {
		
		int product_id=1;
		int stock_quantity=4;
		double expectedprice=360.0;
		try {
		double price=productService.calculateTotalPrice1(product_id,stock_quantity);
		Assert.assertEquals(expectedprice,price,0.01);
		}catch(SQLException e) {
			
		}catch(ResourceNotFoundException e) {
			
		}
		
		//Use case:2
	    product_id=9;
		stock_quantity=20;
		String expectedprice1="Product ID invalid";
		try {
		double actualprice=productService.calculateTotalPrice1(product_id,stock_quantity);
		Assert.assertEquals(expectedprice1,actualprice);
		}catch(SQLException e) {
			
		}catch(ResourceNotFoundException e) {
			
		}
		
		//Use case:3
	    product_id=-1;
		stock_quantity=20;
		String expectedprice2="Product ID invalid";
		try {
		double actualprice=productService.calculateTotalPrice1(product_id,stock_quantity);
		Assert.assertEquals(expectedprice2,actualprice);
		}catch(SQLException e) {
			
		}catch(ResourceNotFoundException e) {
			
		}
		
	
		
	}
	public void calculateTotalprice()throws SQLException, ResourceNotFoundException{
		//Use case 1:
		int product_id=4;
		int stock_quantity=4;
		double expectedprice=200.0;
		try {
		double price=productService.calculateTotalPrice1(product_id,stock_quantity);
		Assert.assertEquals(expectedprice,price,0.01);
		}catch(SQLException e) {
			
		}catch(ResourceNotFoundException e) {
			
		}
		//Use case 2:
		product_id=100;
		stock_quantity=1;
		String expectedprice1="Product ID invalid";
		try {
		double actualprice=productService.calculateTotalPrice1(product_id,stock_quantity);
		Assert.assertEquals(expectedprice1,actualprice);
		}catch(SQLException e) {
			
		}catch(ResourceNotFoundException e) {
			
		}
		//Use case:3
	    product_id=0;
		stock_quantity=20;
		String expectedprice2="Product ID invalid";
		try {
		double actualprice=productService.calculateTotalPrice1(product_id,stock_quantity);
		Assert.assertEquals(expectedprice2,actualprice);
		}catch(SQLException e) {
			
		}catch(ResourceNotFoundException e) {
			
		}
	}

	public void isQuantityValid() throws SQLException, ResourceNotFoundException {

		// Use case:1
		int product_id = 4;
		int quantity = 60;
		String expected = "Quantity exceeds available stock quantity.";
		try {
			boolean actual = productService.isQuantityValid(product_id, quantity);
			Assert.assertEquals(expected, actual);
		} catch (SQLException e) {

		} catch (ResourceNotFoundException e) {

		}
		// Use case:2
		product_id = 1;
		quantity = 0;
		expected = "Quantity cannot be 0 or less.";
		try {
			boolean actual = productService.isQuantityValid(product_id, quantity);
			Assert.assertEquals(expected, actual);
		} catch (SQLException e) {

		} catch (ResourceNotFoundException e) {

		}
		// Use case:3
		product_id = 0;
		quantity = 20;
		expected = "Product Id invalid";
		try {
			boolean actual = productService.isQuantityValid(product_id, quantity);
			Assert.assertEquals(expected, actual);
		} catch (SQLException e) {

		} catch (ResourceNotFoundException e) {

		}
		// Use case:4
		product_id = 100;
		quantity = 89;
		expected = "Product Id invalid";
		try {
			boolean actual = productService.isQuantityValid(product_id, quantity);
			Assert.assertEquals(expected, actual);
		} catch (SQLException e) {

		} catch (ResourceNotFoundException e) {

		}

	}
	
}
