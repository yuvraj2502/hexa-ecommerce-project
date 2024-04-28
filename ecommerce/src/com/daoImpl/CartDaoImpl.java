package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CartDao;
import com.exception.ResourceNotFoundException;
import com.model.Cart;
import com.utility.DBConnection;

public class CartDaoImpl implements CartDao {
	@Override
	public int save(Cart cart) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "Insert Into cart (cart_id,customer_id,product_id,quantity) "+"VALUES (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt(1, cart.getCart_id());
		pstmt.setInt(2, cart.getCustomer_id());
		pstmt.setInt(3, cart.getProduct_id());
		pstmt.setInt(4, cart.getQuantity());
		int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
		DBConnection.dbClose();
		
		return status;
	}
	@Override
	public List<Cart> findAll(int customerid) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DBConnection.dbConnect();
		String sql = "select * from cart where customer_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerid);
		ResultSet rst = pstmt.executeQuery();
		List<Cart> list = new ArrayList<>();
		while(rst.next()==true) {
			int cart_id = rst.getInt("cart_ID");
			int customer_id= rst.getInt("customer_id");
			int product_id = rst.getInt("product_id");
			int quantity = rst.getInt("quantity");
			Cart cart = new Cart(cart_id,customer_id,product_id,quantity);
			list.add(cart);
		}
		DBConnection.dbClose();
		return list;
	}
	@Override
	public void deleteById(int id) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="delete from cart where   cart_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
	
		pstmt.executeUpdate();
		
		DBConnection.dbClose();
		
	}
	@Override
	public boolean isCartBelongsToCustomer(int cartId, int customerid) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select count(*) as count from cart where cart_id = ? and customer_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, cartId);
		pstmt.setInt(2, customerid);
		ResultSet rst = pstmt.executeQuery();
		boolean belongsToCustomer = false;
		if (rst.next()) {
            int count = rst.getInt("count");
              belongsToCustomer = (count > 0);
             }
		DBConnection.dbClose();
		return belongsToCustomer;
	}
	@Override
	public List<Cart> findOne1(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="select * from cart where cart_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rst = pstmt.executeQuery();
		List<Cart> lica = new ArrayList<>();
		while(rst.next()==true) {
			int cart_id = rst.getInt("cart_ID");
			int customer_id= rst.getInt("customer_id");
			int product_id = rst.getInt("product_id");
			int quantity = rst.getInt("quantity");
			Cart cart = new Cart(cart_id,customer_id,product_id,quantity);
			lica.add(cart);
		}
		
		
		DBConnection.dbClose();
		return lica;	
		
	
	}
	
	}

