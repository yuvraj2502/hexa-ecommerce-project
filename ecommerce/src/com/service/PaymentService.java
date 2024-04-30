package com.service;


import java.sql.SQLException;

import com.dao.PaymentDao;
import com.daoImpl.*;
import com.exception.ResourceNotFoundException;

import com.model.Payment;

public class PaymentService {
	PaymentDao dao=new PaymentDaoImpl();
	public  int insert(Payment payment) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(payment);
	}
	public void checkpaymentamount(double payment_amount,int order_id) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		double valid=dao.checkamount(order_id);
		if(valid!=payment_amount) {
			throw new ResourceNotFoundException("Enter correct amount to be paid");
		}
		
	}
	public boolean checkorderid(int order_id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean valid=dao.orderidcheck(order_id);
		if(valid) {
			throw new ResourceNotFoundException("Payment already made for this order id");
		}
		return false;
	}

}
