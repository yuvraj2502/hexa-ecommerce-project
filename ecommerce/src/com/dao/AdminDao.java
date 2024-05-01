package com.dao;

//Author = Yuvraj
import java.sql.SQLException;
import java.util.List;
import com.dto.CustomerDto;
import com.dto.OrderStatsDto;
import com.dto.ProductDto;
import com.dto.ProductSalesDto;
import com.dto.VendorDto;
import com.exception.ResourceNotFoundException;
import com.model.Vendor;

public interface AdminDao {

	// Customer
	List<CustomerDto> getAllCustomer() throws SQLException;

	int softDeleteCustomerById(int id) throws SQLException, ResourceNotFoundException;

	boolean findOneCustomer(int id) throws SQLException, ResourceNotFoundException;

	// Vendor
	int save(Vendor vendor) throws SQLException;

	int softDeleteVendorById(int id) throws SQLException;

	boolean findOneVendor(int id) throws SQLException, ResourceNotFoundException;

	List<VendorDto> getAllVendor() throws SQLException;

	// Product
	List<ProductDto> getAllProduct(int id) throws SQLException;

	// Order
	List<OrderStatsDto> getOrderStats() throws SQLException;

	List<ProductSalesDto> productSaleRecord() throws SQLException;
	
}