package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.*;
import com.daoImpl.*;
import com.dto.ListRefundbyOrderDto;
import com.exception.ResourceNotFoundException;

public class RefundService {
OrderDao orderdao=new OrderDaoImpl();
RefundDao refunddao=new RefundDaoImpl();
CustomerDao custdao=new CustomerDaoImpl();
	public List<ListRefundbyOrderDto> findRefund(int customer_id)throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
	
		return refunddao.findRefund(customer_id);
	}
		

}
