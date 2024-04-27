package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.PaymentDto;
import com.dto.RefundDto;
import com.exception.ResourceNotFoundException;
import com.model.Orders;
import com.model.Product;

public interface VendorDao {
	int save(Product product) throws SQLException;   //1
	
	void deleteById(int id)throws SQLException,ResourceNotFoundException;  //2
	
	boolean findOne(int id)throws SQLException;   //2
	
	List<Product> findAll() throws SQLException;  //3
	
	void updateStockQuantity(int productId, int newQuantity)throws SQLException; //4

	
	List<Orders> findAllo() throws SQLException;   //5
	
	void updateOrderStatus(int proId, String orderStatus)throws SQLException;   //6

	List<PaymentDto> getCheckPayment() throws SQLException;//7
	
	List<RefundDto> getApprovedRefund()throws SQLException;//8
	
   
	
	
	

	
}
