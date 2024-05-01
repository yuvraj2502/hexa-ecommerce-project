package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDao;
import com.dto.Listorderwithproduct;

import com.dto.OrderPaymentRefund;
import com.exception.ResourceNotFoundException;
import com.model.Order;
import com.utility.DBConnection;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Listorderwithproduct> listorderdetails(int customerid) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
        String query = " SELECT s.order_id,s.quantity,s.order_date,s.status,s.total_price,p.name,p.offer_percent "
        		+ " FROM orders s JOIN product p ON s.product_id=p.product_id "
        		+ " where s.customer_id=? ";
        
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, customerid);
        ResultSet rst = pstmt.executeQuery();
        List<Listorderwithproduct> list=new ArrayList<>();
        

        while (rst.next()==true) { // Expecting only one refund for each order_id
            int order_id = rst.getInt("order_id");
            int quantity= rst.getInt("quantity");
            String order_date = rst.getString("order_date");
            String status = rst.getString("status");
            double total_price=rst.getDouble("total_price");
            
            String name=rst.getString("name");
            double offer_percent=rst.getDouble("offer_percent");
         
            Listorderwithproduct orderdetails = new Listorderwithproduct(order_id,quantity,order_date,status,total_price,name,offer_percent);
             list.add(orderdetails);
        }

        return list;
		
	}
	

@Override
public int save(Order order) throws SQLException {
	
	// TODO Auto-generated method stub
	Connection con = DBConnection.dbConnect();
	String sql = "Insert Into orders (order_id,quantity,order_date,total_price,customer_id,product_id) "+"VALUES (?,?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	//attach the data
	pstmt.setInt(1, order.getOrder_id());
	pstmt.setInt(2, order.getQuantity());
	pstmt.setString(3, order.getOrder_date());
	//pstmt.setString(4, order.getStatus());
	pstmt.setDouble(4, order.getTotal_price());
	pstmt.setInt(5, order.getCustomer_id());
	pstmt.setInt(6, order.getProduct_id());
	int status = pstmt.executeUpdate(); 
	DBConnection.dbClose();
	
	return status;
}
@Override
public List<Order> findAll(int customerId) throws SQLException {
	// TODO Auto-generated method stub
	
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="SELECT*from orders where customer_id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst=pstmt.executeQuery();
		List<Order> list =new ArrayList<>();
		while(rst.next()==true) {
			int id=rst.getInt("order_id");
			int quantity=rst.getInt("quantity");
			String order_date=rst.getString("order_date");
			String status=rst.getString("status");
			double total_price=rst.getDouble("total_price");
			int customer_id=rst.getInt("customer_id");
			int product_id=rst.getInt("product_id");
			
	        Order order = new Order(id,quantity,order_date,status,total_price,customer_id,product_id);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
}

@Override
public boolean findOne(int orderid) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	Connection con=DBConnection.dbConnect();
	String sql="select order_id from orders where order_id=?";
	PreparedStatement pstmt= con.prepareStatement(sql);
	pstmt.setInt(1, orderid);
	ResultSet rst=pstmt.executeQuery();
	boolean status=rst.next();
	DBConnection.dbClose();
	return status;
	
}


@Override
public void softDeleteByid(int id) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	
	Connection con=DBConnection.dbConnect();
	String sql="update orders SET isActive='no' where order_id=?";
	PreparedStatement pstmt= con.prepareStatement(sql);
	pstmt.setInt(1, id);
	pstmt.executeUpdate();
	DBConnection.dbClose();
}

@Override
public boolean findorderforcustomer(int customerId, int orderid) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	Connection con = DBConnection.dbConnect();
	String sql = "select * from orders where order_id = ? and customer_id = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, orderid);
	pstmt.setInt(2, customerId);
	ResultSet rst = pstmt.executeQuery();
	boolean status = rst.next();
	
	DBConnection.dbClose();
	return status;
	
}
@Override
public boolean checkvalid(int orderid) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select order_id from refund where order_id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, orderid);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		System.out.println("Checkvalid status: " + status);
		DBConnection.dbClose();
		return status;
		
	
	
}


@Override
public List<OrderPaymentRefund> fulldetailsregorder(int customerId) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	Connection con=DBConnection.dbConnect();
	String sql=" select o.order_id,o.quantity,o.total_price,o.product_id,po.name,p.payment_id,p.payment_amount,r.refund_id,r.refund_amount "
			+ " from orders o left JOIN payment p ON o.order_id=p.order_id "
			+ " left JOIN refund r On o.order_id=r.order_id left JOIN product po ON o.product_id=po.product_id "
			+ " where o.customer_id=? ";
	PreparedStatement pstmt= con.prepareStatement(sql);
	pstmt.setInt(1, customerId);
	ResultSet rst=pstmt.executeQuery();
	List<OrderPaymentRefund> list =new ArrayList<>();
	while(rst.next()==true) {
		int id=rst.getInt("order_id");
		int quantity=rst.getInt("quantity");
		double total_price=rst.getDouble("total_price");
		int product_id=rst.getInt("product_id");
		String name=rst.getString("name");
		int payment_id=rst.getInt("payment_id");
		double payment_amount=rst.getDouble("payment_amount");
		int refund_id=rst.getInt("refund_id");
		double refund_amount=rst.getDouble("refund_amount");
		
		
		OrderPaymentRefund details = new OrderPaymentRefund(id,quantity,total_price,product_id,name,payment_id,payment_amount,refund_id,refund_amount);
		list.add(details);
	}
	DBConnection.dbClose();
	return list;
	
}





}