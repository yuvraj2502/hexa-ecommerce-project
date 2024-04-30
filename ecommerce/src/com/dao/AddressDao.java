package com.dao;
//Author - Swarna
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import com.model.Address;

public interface AddressDao {

	int updateAddress(Address add) throws SQLException;

	List<Address> findAll(int customerId)throws SQLException;

	int save(Address adr) throws SQLException;

}
