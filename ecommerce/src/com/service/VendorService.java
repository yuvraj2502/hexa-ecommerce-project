package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.VendorDao;
import com.daoImpl.VendorDaoImpl;
import com.dto.PaymentDto;
import com.dto.RefundDto;
import com.exception.ResourceNotFoundException;
import com.model.Orders;
import com.model.Product;

public class VendorService {
	VendorDao dao=new VendorDaoImpl();
//1
	public void save(Product product) throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
	}	

//1
	public int insert(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
//2
	public void deleteByid(int id) throws SQLException,ResourceNotFoundException{
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
			 
		dao.deleteById(id);
			
	}
// 3
	public List<Product> findAll() throws SQLException{
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
// 4
	public void updateStockQuantity(int productId, int newQuantity) throws SQLException, ResourceNotFoundException  {
			// TODO Auto-generated method stub
		boolean isIdValid = dao.findOnep(productId);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		dao.updateStockQuantity(productId, newQuantity);
	}

	
//5
	public List<Orders> findAllo() throws SQLException{
		return dao.findAllo();
	}

	
//6
	public void updateOrderStatus(int proId, String orderStatus)throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOneo(proId);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		dao.updateOrderStatus(proId,orderStatus);
	}

//7
	public List<PaymentDto> getCheckPayment() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getCheckPayment();
	}

//8
	public List<RefundDto> getApprovedRefund() throws SQLException{
		// TODO Auto-generated method stub
		return dao.getApprovedRefund();
	}


	



	



	




	






	




}
