package com.daoImpl;

//Author = Yuvraj
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;
import com.utility.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(String email, String password) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from user where email=? AND password=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			User user = new User();
			user.setUserId(rst.getInt("user_id"));
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(rst.getString("role"));
			DBConnection.dbClose();
			return user;
		} else {
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
		ResultSet rst = pstmt.executeQuery();

		rst = pstmt.executeQuery();

		if (rst.next()) {
			customerId = rst.getInt("customer_id");
		}

		DBConnection.dbClose();
		return customerId;
	}

	@Override
	public int saveCustomer(Customer customer) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO customer (customer_id, name, user_id) VALUES (?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, customer.getCustomer_id());
		pstmt.setString(2, customer.getName());
		pstmt.setInt(3, customer.getUser_id());

		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public Vendor getVendorById(int userId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select v.* from vendor v JOIN user u "
				+ "on u.user_id = v.user_id where u.user_id=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, userId);

		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			Vendor vendor = new Vendor();
			vendor.setLoginFirst(rst.getBoolean("is_first_login"));
			vendor.setVendorId(rst.getInt("vendor_id"));
			DBConnection.dbClose();
			return vendor;
		} else {
			DBConnection.dbClose();
			return null;
		}
	}

	@Override
	public void updateVendorLogin(Vendor vendor) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "update vendor set is_first_login = ? where vendor_id=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setBoolean(1, vendor.getIsLoginFirst());
		pstmt.setInt(2, vendor.getVendorId());

		pstmt.executeUpdate();
		DBConnection.dbClose();

	}

	@Override
	public void updateUser(User updatedUser) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "update user set password = ? where user_id=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,updatedUser.getPassword());
		pstmt.setInt(2, updatedUser.getUserId());

		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

}