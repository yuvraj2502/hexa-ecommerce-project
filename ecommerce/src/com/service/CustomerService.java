package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.daoImpl.CustomerDaoImpl;
import com.dto.CustomerAddressDetailsDto;
import com.exception.ResourceNotFoundException;

public class CustomerService {
    CustomerDao dao=new CustomerDaoImpl();

	public List<CustomerAddressDetailsDto> getCustomerAddress(int customerid) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
	
		return dao.getCustomerAddress(customerid);
	}
	
	
}
