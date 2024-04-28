package com.daoImpl;
//Author = Yuvraj
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.model.User;
import com.utility.DBConnection;


public class UserDaoImpl implements UserDao{
	
	@Override
	public User login(String email, String password) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from user where email=? AND password=?";
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rst  = pstmt.executeQuery();
		 
		if(rst.next()) {
			User user = new User();
			user.setUserId(rst.getInt("user_id"));
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(rst.getString("role"));
			DBConnection.dbClose();
			return user;
		}
		else {
			DBConnection.dbClose();
			return null; 
		}
		
		 
	}
	
	public int save(User user) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO user (user_id, email, password, role) VALUES (?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, user.getUserId());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getRole());

		int status = pstmt.executeUpdate(); 
		DBConnection.dbClose();
		return status;
	}
	 @Override
	    public int getCustomerIdByUserId(int userId) throws SQLException {
		 Connection con = DBConnection.dbConnect();   
		 String sql = "SELECT customer_id FROM customer WHERE user_id = ?";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		
	        int customerId = -1; 
       pstmt.setInt(1, userId);
	            ResultSet rst  = pstmt.executeQuery();

	            rst = pstmt.executeQuery();

	            if (rst.next()) {
	                customerId = rst.getInt("customer_id");
	            }
	        
	            DBConnection.dbClose();
	        return customerId;
	    }
}