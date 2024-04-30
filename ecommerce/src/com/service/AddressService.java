package com.service;

import com.model.Address;

import java.sql.SQLException;
import java.util.List;

import com.dao.AddressDao;
import com.daoImpl.AddressDaoImpl;
public class AddressService {
AddressDao dao = new AddressDaoImpl();
	public int updateAddress(Address add) throws SQLException {
		// TODO Auto-generated method stub
		return dao.updateAddress(add);
	}
	public List<Address> findAll(int customerId)throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll(customerId);
	}
	public int save(Address adr) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(adr);
	}
	

}
