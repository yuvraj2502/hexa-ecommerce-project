package com.service;
//author - swarna & sunitha
import java.sql.SQLException;
import java.util.List;
import com.dao.PaymentDao;
import com.daoImpl.*;
import com.dao.CustomerDao;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.daoImpl.CustomerDaoImpl;
import com.daoImpl.OrderDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.dto.GetorderPayment;
import com.dto.Listorderwithproduct;
import com.dto.OrderPaymentRefund;
import com.exception.ResourceNotFoundException;
import com.model.Order;


public class OrderService {
    OrderDao dao=new OrderDaoImpl();
    CustomerDao custdao=new CustomerDaoImpl();
    ProductDao productdao=new ProductDaoImpl();
    PaymentDao paymentdao=new PaymentDaoImpl();
	public List<Listorderwithproduct> listorderdetails(int customerid)throws SQLException,ResourceNotFoundException {
	
		return dao.listorderdetails(customerid);
		
	}
public void save(Order order) throws SQLException, ResourceNotFoundException {
	
		boolean isProdIdValid = productdao.findOne(order.getProduct_id());
		if(!isProdIdValid)
			throw new ResourceNotFoundException("Product ID invalid");
		
		dao.save(order);
	}
public List<Order> findAll(int customerId)throws SQLException, ResourceNotFoundException {

	return dao.findAll(customerId);
}
public void softDeleteByid(int customerid,int orderid) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	boolean isIdValid= dao.findorderforcustomer(customerid,orderid);
	if(!isIdValid)
		throw new ResourceNotFoundException("Id given id invalid!!");
	dao.softDeleteByid(orderid);

}
public boolean findorderforcustomer(int customerId, int order_id) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	boolean isIdValid= dao.findorderforcustomer(customerId,order_id);
	if(!isIdValid)
		throw new ResourceNotFoundException("Id given id invalid!!");
	return dao.findorderforcustomer(customerId, order_id);
}
public List<OrderPaymentRefund> fulldetailsregorder(int customerId) throws ResourceNotFoundException, SQLException {
	// TODO Auto-generated method stub


	return dao.fulldetailsregorder(customerId);
	
}
public  List<GetorderPayment>getPaymentDetails(int customer_id) throws SQLException, ResourceNotFoundException {
	// TODO Auto-generated method stub
	

	return paymentdao.getPaymentDetails(customer_id);
	
}


}

