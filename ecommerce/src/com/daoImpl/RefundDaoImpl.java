package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.RefundDao;
import com.dto.ListRefundbyOrderDto;
import com.exception.ResourceNotFoundException;
import com.utility.DBConnection;

public class RefundDaoImpl implements RefundDao {
	


	@Override
	public List<ListRefundbyOrderDto> findRefund(int customerid) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
	    String query = " SELECT d.refund_id,d.refund_date,d.refund_amount,s.order_id,s.order_date,s.total_price,s.customer_id"
	    		+ " FROM orders s LEFT JOIN refund d ON s.order_id=d.order_id "
	    		+ " where s.customer_id=? ";
	    
	    PreparedStatement pstmt = con.prepareStatement(query);
	    pstmt.setInt(1, customerid);
	    ResultSet rst = pstmt.executeQuery();
	    List<ListRefundbyOrderDto> list=new ArrayList<>();
	    

	    while (rst.next()==true) { // Expecting only one refund for each order_id
	        int refundId = rst.getInt("refund_id");
	        String refundDate = rst.getString("refund_date");
	        double refundAmount = rst.getDouble("refund_amount");
	        int order_id=rst.getInt("order_id");
	        
	        String order_date=rst.getString("order_date");
	        double total_price=rst.getDouble("total_price");
	        int customer_id=rst.getInt("customer_id");
	     
	        ListRefundbyOrderDto refund1 = new ListRefundbyOrderDto(refundId, refundDate, refundAmount,order_id,order_date,total_price,customer_id);
	         list.add(refund1);
	    }
	    DBConnection.dbClose();
		return list;
		
	}

    
}
