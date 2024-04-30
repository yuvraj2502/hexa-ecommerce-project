package com.dao;
//AUTHOR SWARNALAKSHMI AND SUNITHA
import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerAddressDetailsDto;
import com.exception.ResourceNotFoundException;


public interface CustomerDao {

	List<CustomerAddressDetailsDto> getCustomerAddress(int customerid)throws SQLException;

	
}
