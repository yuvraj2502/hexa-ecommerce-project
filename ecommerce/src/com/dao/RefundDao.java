package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ListRefundbyOrderDto;
import com.exception.ResourceNotFoundException;

public interface RefundDao {
	List<ListRefundbyOrderDto> findRefund(int customer_id)throws SQLException,ResourceNotFoundException;

}
