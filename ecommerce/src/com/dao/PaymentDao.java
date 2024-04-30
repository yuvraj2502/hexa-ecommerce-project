package com.dao;
//AUTHOR SUNITHA
import java.sql.SQLException;
import java.util.List;

import com.dto.GetorderPayment;
import com.exception.ResourceNotFoundException;
import com.model.Payment;

public interface PaymentDao {
	int save(Payment payment)throws SQLException;

	List<GetorderPayment> getPaymentDetails(int customer_id)throws SQLException,ResourceNotFoundException;

	double checkamount(int order_id)throws SQLException,ResourceNotFoundException;

	boolean orderidcheck(int order_id)throws SQLException,ResourceNotFoundException;

}
