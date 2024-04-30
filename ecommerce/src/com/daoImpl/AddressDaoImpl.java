package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AddressDao;
import com.model.Address;
import com.model.Cart;
import com.utility.DBConnection;

public class AddressDaoImpl implements AddressDao {

	@Override
	public int updateAddress(Address add) throws SQLException {
		
		    Connection con = DBConnection.dbConnect();
		    String sql = "UPDATE address SET street=?, city=?, state=?, country=?, pincode=? WHERE customer_id=?";
		    PreparedStatement pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, add.getStreet());
		    pstmt.setString(2, add.getCity());
		    pstmt.setString(3, add.getState());
		    pstmt.setString(4, add.getCountry());
		    pstmt.setInt(5, add.getPincode());
		    pstmt.setInt(6, add.getCustomer_id());
		    int status = pstmt.executeUpdate();
		    DBConnection.dbClose();
		    return status;
		

	}

	@Override
	public List<Address> findAll(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from address where customer_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		List<Address> list = new ArrayList<>();
		while(rst.next()==true) {
			int addressId = rst.getInt("address_id");
			int customerID = rst.getInt("customer_id");
			String street = rst.getString("street");
			String city = rst.getString("city");
			String state = rst.getString("state");
			String country = rst.getString("country");
			int pincode = rst.getInt("pincode");
			Address address = new Address(addressId,customerID,street,city,state,country,pincode);
			list.add(address);
		}
		DBConnection.dbClose();
		return list;
	}
	
	@Override
public int save(Address adr) throws SQLException  {
		// TODO Auto-generated method stub
		 Connection con = DBConnection.dbConnect();
		 String sql = "INSERT INTO address (address_id,customer_id, street, city, state, country, pincode) VALUES (?,?, ?, ?, ?, ?, ?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, adr.getAddress_id());
		 pstmt.setInt(2, adr.getCustomer_id());
		 pstmt.setString(3, adr.getStreet());
		 pstmt.setString(4, adr.getCity());
		 pstmt.setString(5, adr.getState());
		 pstmt.setString(6, adr.getCountry());
		 pstmt.setInt(7, adr.getPincode());
		 int status = pstmt.executeUpdate();
		    DBConnection.dbClose();
		    return status;
	}

}
