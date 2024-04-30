package com.dao;
//AUTHOR SWARNALAKSHMI AND SUNITHA
import java.sql.SQLException;
import java.util.List;

import com.dto.Listorderwithproduct;
import com.dto.OrderPaymentRefund;
import com.exception.ResourceNotFoundException;
import com.model.Order;

public interface OrderDao {
	List<Listorderwithproduct> listorderdetails(int customerid)throws SQLException,ResourceNotFoundException;
	
	int save(Order order) throws SQLException;
	
	List<Order> findAll(int customerId)throws SQLException,ResourceNotFoundException;
	
	boolean findOne(int orderid)throws SQLException,ResourceNotFoundException;
	
	void softDeleteByid(int orderid)throws SQLException,ResourceNotFoundException;
	
	boolean findorderforcustomer(int orderid, int customerid)throws SQLException,ResourceNotFoundException;
	
	boolean checkvalid(int orderid)throws SQLException,ResourceNotFoundException;
	
	List<OrderPaymentRefund> fulldetailsregorder(int customerId)throws SQLException,ResourceNotFoundException;
	
}
