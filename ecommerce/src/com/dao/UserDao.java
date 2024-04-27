package com.dao;
//Author = Yuvraj
import java.sql.SQLException;

import com.model.User;

public interface UserDao {
	int save(User user)  throws SQLException;
	User login(String username, String password) throws SQLException;
}
