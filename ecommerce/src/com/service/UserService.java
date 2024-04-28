package com.service;
//Author = Yuvraj
import java.sql.SQLException;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.exception.InvalidCredentialsException;
import com.model.User;

public class UserService {

	UserDao userDao = new UserDaoImpl();

	public User login(String email, String password) throws SQLException, InvalidCredentialsException {
		 
		User user = userDao.login(email,password);
		if(user == null) {
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
	
}
