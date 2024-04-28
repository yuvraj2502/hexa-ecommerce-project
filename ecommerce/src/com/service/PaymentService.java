package com.service;


import java.sql.SQLException;

import com.dao.PaymentDao;
import com.daoImpl.*;

import com.model.Payment;

public class PaymentService {
	PaymentDao dao=new PaymentDaoImpl();
	public  int insert(Payment payment) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(payment);
	}

}
