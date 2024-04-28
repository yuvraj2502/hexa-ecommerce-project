package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerDao;
import com.dto.CustomerAddressDetailsDto;
import com.exception.ResourceNotFoundException;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<CustomerAddressDetailsDto> getCustomerAddress(int customerid) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Connection con = DBConnection.dbConnect();
		String sql="select c.customer_id,c.name,a.street,a.city,a.state,a.country,a.pincode  "
				+ " from customer c left JOIN address a ON c.customer_id = a.customer_id where c.customer_id =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerid);
		ResultSet rst = pstmt.executeQuery();
		List<CustomerAddressDetailsDto> list = new ArrayList<>();
		while(rst.next() == true) {
			int customer_id = rst.getInt("customer_id");
			String name = rst.getString("name");
			String street = rst.getString("street");
			String city = rst.getString("city");
			String state = rst.getString("state");
			String country = rst.getString("country");
			int pincode = rst.getInt("pincode");
			CustomerAddressDetailsDto customerdto = new CustomerAddressDetailsDto(customer_id,name,street,city,state,country,pincode);
			list.add(customerdto);
		}
		DBConnection.dbClose();
		return list;
		
	}

	
}
