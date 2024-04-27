package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.VendorDao;
import com.dto.PaymentDto;
import com.dto.RefundDto;
import com.exception.ResourceNotFoundException;
import com.model.Orders;
import com.model.Product;
import com.utility.DBConnection;

public class VendorDaoImpl implements VendorDao {
//1	
	@Override                 
	public int save(Product product) throws SQLException {
		// insert product record in DB
		Connection con = DBConnection.dbConnect();
		String sql="INSERT INTO product (product_id, name, description, price,offer_percent,stock_quantity,category_id,vendor_id) "
				+ " VALUES (?,?,?,?,?,?,?,?)";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt(1, product.getProduct_id());
		pstmt.setString(2, product.getName());
		pstmt.setString(3, product.getDescription());
		pstmt.setDouble(4, product.getPrice());
		pstmt.setInt(5, product.getOffer_percent());
		pstmt.setInt(6, product.getStock_quantity());
		pstmt.setInt(7, product.getCategory_id());
		pstmt.setInt(8, product.getVendor_id());
		//execute the query 
		int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
		System.out.println(status);
		DBConnection.dbClose();
		
		return status;		
	}
	
//2	
	@Override           
	public void deleteById(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="delete from product where product_id =?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
			
	}

//2
	@Override         
	public boolean findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="select product_id from product where product_id=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst  = pstmt.executeQuery();
		boolean status = rst.next(); 
		DBConnection.dbClose();
		return status;
	}

	
	
//3
	public List<Product> findAll() throws SQLException{
		Connection con = DBConnection.dbConnect();
		String sql="select * from product";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Product> list = new ArrayList<>();
		while(rst.next() == true) {
			int id  = rst.getInt("product_id");
			String name = rst.getString("name");
			String description = rst.getString("description");
			Double price = rst.getDouble("price");
			int offerPercent = rst.getInt("offer_percent");
			int stockQuantity=rst.getInt("stock_quantity");
			int catid  = rst.getInt("category_id");
			int vendorid  = rst.getInt("vendor_id");
			Product product = new Product(id,name, description,price,offerPercent,stockQuantity,catid,vendorid); 
			list.add(product);
		}
		DBConnection.dbClose();		
		return list;
	}
	

//4
	@Override
	public void updateStockQuantity(int productId, int newQuantity) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE product SET stock_quantity=? WHERE product_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, newQuantity);
		pstmt.setInt(2, productId);
		pstmt.executeUpdate();
			
		DBConnection.dbClose();
		
	}
	
//5	
	@Override                   
	public List<Orders> findAllo() throws SQLException{
		Connection con = DBConnection.dbConnect();
		String sql="select * from orders";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Orders> list = new ArrayList<>();
		while(rst.next()== true) {
			int id=rst.getInt("order_id");
			int quantity=rst.getInt("quantity");
			String order_date = rst.getString("order_date");
			String status = rst.getString("status");
			double totalPrice=rst.getDouble("total_price");
			int custid=rst.getInt("customer_id");
			int proid=rst.getInt("product_id");
			
			Orders orders=new Orders(id,quantity,order_date,status,totalPrice,custid,proid);
			list.add(orders);
		}
		DBConnection.dbClose();
		return list;
		
	}
//6
	@Override
	public void updateOrderStatus(int proId, String orderStatus) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "update orders set status=? where product_id= ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,  orderStatus);
		pstmt.setInt(2, proId);
		pstmt.executeUpdate();
			
		DBConnection.dbClose();
			
	}	
//7
	@Override                   
	public List<PaymentDto> getCheckPayment() throws SQLException{
		Connection con = DBConnection.dbConnect();
		String sql="select p.payment_id as paymentId,p.payment_date as Date,p.payment_type as ModeOfPayment,p.payment_amount as Amount,o.order_id as orderID, o.order_date as orderDate, o.customer_id as customerID "
				+ "from payment p join orders o "
				+ "on p.order_id=o.order_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 
		ResultSet rst = pstmt.executeQuery();
		List<PaymentDto> list = new ArrayList<>();
		while(rst.next() == true) {
			int id=rst.getInt("paymentId");
			String date=rst.getString("Date");
			String type=rst.getString("ModeOfPayment");
			Double amount=rst.getDouble("Amount");
			int odid=rst.getInt("orderID");
			String oddate=rst.getString("orderDate");
			int custid=rst.getInt("customerID");
			
			PaymentDto payment=new PaymentDto(id,date,type,amount,odid,oddate,custid);
			list.add(payment);
		}
		DBConnection.dbClose();		
		return list;
		
	}
	
//8
	@Override                      
	public List<RefundDto> getApprovedRefund()throws SQLException{
		Connection con = DBConnection.dbConnect();
		String sql="select r.refund_id as RefundId,r.refund_date as Date,r.refund_amount as Amount,r.order_id as OrderId,p.payment_id as paymentId,p.payment_date as paymentDate "
				+ "from payment p join refund r "
				+ "on p.order_id=r.order_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 
		ResultSet rst = pstmt.executeQuery();
		List<RefundDto> list = new ArrayList<>();
		while(rst.next() == true) {
			int id=rst.getInt("RefundId");
			String date=rst.getString("Date");
			Double amount=rst.getDouble("Amount");
			int odid=rst.getInt("OrderId");
			int payid=rst.getInt("paymentId");
			String paydate=rst.getString("paymentDate");
			
			RefundDto refund=new RefundDto(id,date,amount,odid,payid,paydate);
			list.add(refund);
		}
		DBConnection.dbClose();		
		return list;
	}


}
	
	



