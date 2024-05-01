package com.service;

//Author = Yuvraj
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dao.AdminDao;
import com.daoImpl.AdminDaoImpl;
import com.dto.CustomerDto;
import com.dto.OrderStatsDto;
import com.dto.ProductDto;
import com.dto.ProductSalesDto;
import com.dto.VendorDto;
import com.exception.InvalidCustomerIdException;
import com.exception.ResourceNotFoundException;
import com.model.Vendor;

public class AdminService {

	AdminDao adminDao = new AdminDaoImpl();

	public List<CustomerDto> getAll() throws SQLException {
		return adminDao.getAllCustomer();
	}

	public int deleteCustomer(int id) throws SQLException, ResourceNotFoundException, InvalidCustomerIdException {
		boolean isValid = adminDao.findOneCustomer(id);

		if (!isValid)
			throw new InvalidCustomerIdException("Invalid Customer Id");

		return adminDao.softDeleteCustomerById(id);
	}

	public List<OrderStatsDto> OrderStats() throws SQLException {
		return adminDao.getOrderStats();
	}

	public void save(Vendor vendor) throws SQLException {
		adminDao.save(vendor);
	}

	public List<VendorDto> findAll() throws SQLException {
		return adminDao.getAllVendor();
	}

	public int deleteVendor(int id) throws SQLException, ResourceNotFoundException {
		boolean isValid = adminDao.findOneVendor(id);

		if (!isValid)
			throw new ResourceNotFoundException("Invalid Vendor Id");

		return adminDao.softDeleteVendorById(id);
	}

	public List<ProductDto> getAllProducts(int id) throws SQLException, ResourceNotFoundException {
		boolean isValid = adminDao.findOneVendor(id);

		if (!isValid)
			throw new ResourceNotFoundException("Invalid Vendor Id");

		return adminDao.getAllProduct(id);
	}

	public List<ProductSalesDto> productSale() throws SQLException {
		List<ProductSalesDto> product = adminDao.productSaleRecord();
		return productSaleAsc(product);
	}

	public List<ProductSalesDto> productSaleAsc(List<ProductSalesDto> list) {
		Collections.sort(list, new SortAsc());
		return list;
	}

}

class SortAsc implements Comparator<ProductSalesDto> {

	@Override
	public int compare(ProductSalesDto p1, ProductSalesDto p2) {
		if (p1.getPrice() < p2.getPrice())
			return -1;

		if (p1.getPrice() > p2.getPrice())
			return 1;

		return 0;

	}
}
