package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.PaymentDao;

import com.dto.GetorderPayment;

import com.exception.ResourceNotFoundException;
import com.model.Payment;
import com.utility.DBConnection;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public int save(Payment payment) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO Payment (payment_id,payment_date,payment_type, payment_amount, order_id) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, payment.getPayment_id());
		pstmt.setString(2, payment.getPayment_date());
		pstmt.setString(3,payment.getPayment_type());
		pstmt.setDouble(4,payment.getPayment_amount());
		pstmt.setInt(5,payment.getOrder_id());
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public List<GetorderPayment> getPaymentDetails(int customerid) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql=" SELECT s.*,p.* "
				+ " FROM orders s LEFT JOIN payment p ON p.order_id=s.order_id "
				+ " where s.customer_id=? ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, customerid);
		ResultSet rst=pstmt.executeQuery();
		List<GetorderPayment> list = new ArrayList<>();
		while(rst.next() == true) {
			int payment_id = rst.getInt("payment_id");
			String payment_date = rst.getString("payment_date");
			String payment_type=rst.getString("payment_type");
		    double payment_amount = rst.getDouble("payment_amount");
		    int order_id = rst.getInt("order_id");
			double total_price = rst.getDouble("total_price");
			int customer_id = rst.getInt("customer_id");
			String order_date = rst.getString("order_date");
			GetorderPayment getorderpayment = new GetorderPayment(payment_id,payment_date,payment_type,payment_amount,order_id,total_price,customer_id,order_date);
			list.add(getorderpayment);
		}
		DBConnection.dbClose();
		return list;
		
	}

	@Override
	public double checkamount(int order_id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql=" SELECT total_price from orders where order_id=? ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, order_id);
		ResultSet rst=pstmt.executeQuery();
		if(!rst.next()) {
			throw new ResourceNotFoundException("no data found");
		}
		double total_price=rst.getDouble("total_price");
		DBConnection.dbClose();
		
		return total_price;
	}

	@Override
	public boolean orderidcheck(int order_id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql=" SELECT order_id from payment where order_id=? ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, order_id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
	}

	
	

}
