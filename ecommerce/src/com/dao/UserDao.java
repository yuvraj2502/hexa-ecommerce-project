package com.dao;

//Author = Yuvraj
import java.sql.SQLException;

import com.model.Customer;
import com.model.User;
import com.model.Vendor;

public interface UserDao {
	int save(User user) throws SQLException;

	User login(String username, String password) throws SQLException;

	int getCustomerIdByUserId(int userId) throws SQLException;
	
	int saveCustomer(Customer customer) throws SQLException;

	Vendor getVendorById(int userId)throws SQLException;

	void updateVendorLogin(Vendor vendor)throws SQLException;

	void updateUser(User updatedUser)throws SQLException;
}
