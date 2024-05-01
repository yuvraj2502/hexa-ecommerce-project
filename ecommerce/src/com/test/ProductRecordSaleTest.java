package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dto.ProductSalesDto;
import com.service.AdminService;

public class ProductRecordSaleTest {
	AdminService adminService = new AdminService();
	
	@Test
	public void productSaleAsc() {
		/* Use Case: 1 */
		
		/* Prepare the inputs */
		ProductSalesDto p1 = new ProductSalesDto(3,"Mobile Phone",750000,1);
		ProductSalesDto p2 = new ProductSalesDto(1,"Water Bottle",20,2);
		ProductSalesDto p3 = new ProductSalesDto(2,"Television",50000,5);
		
	
		List<ProductSalesDto> list = Arrays.asList(p1,p2,p3);
		
		List<ProductSalesDto> expectedList = Arrays.asList(p2,p3,p1);
		List<ProductSalesDto> actualList = adminService.productSaleAsc(list);
		Assert.assertEquals(expectedList, actualList);
		
		/* Use Case: 2 */
		
		
		/* Prepare the inputs */	
		ProductSalesDto p4 = new ProductSalesDto(3,"Mobile Phone",15,1);
		ProductSalesDto p5 = new ProductSalesDto(1,"Car",20,2);
		ProductSalesDto p6 = new ProductSalesDto(2,"Laptop",50,5);
		List<ProductSalesDto> list2 = Arrays.asList(p4,p5,p6);
		expectedList = Arrays.asList(p4,p5,p6);
		actualList = adminService.productSaleAsc(list2);
		System.out.println(actualList);
		Assert.assertEquals(expectedList, actualList);
		
		/* Use Case: 3 */
		
		/* Prepare the inputs */
		
		list = Arrays.asList(p4,p3);
		expectedList = Arrays.asList(p4,p3);
		actualList = adminService.productSaleAsc(list);
		Assert.assertEquals(expectedList, actualList);
		
	}
}
