package com.service;

//Author = Yuvraj
import java.sql.SQLException;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.exception.InvalidCredentialsException;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;

public class UserService {

	UserDao userDao = new UserDaoImpl();

	public User login(String email, String password) throws SQLException, InvalidCredentialsException {

		User user = userDao.login(email, password);
		if (user == null) {
			throw new InvalidCredentialsException("Login Failed!");
		}
		return user;
	}

	public void save(User user) throws SQLException {
		userDao.save(user);
	}

	public int getCustomerIdByUserId(int userId) throws SQLException {
		return userDao.getCustomerIdByUserId(userId);
	}

	public int insert(Customer customer) throws SQLException {
		return userDao.saveCustomer(customer);
	}

	public Vendor getVendor(int userId) throws SQLException{
		return userDao.getVendorById(userId);
	}

	public void updateVendorLogin(Vendor vendor)throws SQLException {
		userDao.updateVendorLogin(vendor);
	}

	public void updateUser(User updatedUser)throws SQLException {
		userDao.updateUser(updatedUser);		
	}

}
