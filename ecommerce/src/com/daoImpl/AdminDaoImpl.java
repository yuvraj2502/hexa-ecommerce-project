package com.daoImpl;
//Author = Yuvraj
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.AdminDao;
import com.dto.CustomerDto;
import com.dto.OrderStatsDto;
import com.dto.ProductDto;
import com.dto.VendorDto;
import com.exception.ResourceNotFoundException;
import com.model.Vendor;
import com.utility.DBConnection;

public class AdminDaoImpl implements AdminDao {

	@Override
	public List<CustomerDto> getAllCustomer() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select c.customer_id ,c.name ,u.email"
				+ " from customer c Join user u on u.user_id = c.user_id "
				+ " and c.isActive='yes' ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		List<CustomerDto> list = new ArrayList<>();

		while (rst.next() == true) {
			String name = rst.getString("name");
			String email = rst.getString("email");
			int customerId = rst.getInt("customer_id");

			CustomerDto customer = new CustomerDto(customerId, name, email);
			list.add(customer);
		}

		pstmt.executeQuery();
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<VendorDto> getAllVendor() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = " select v.vendor_id ,v.vendor_name,u.email,v.business_name,v.vendor_address "
				+ "from vendor v join user u " + "on u.user_id = v.user_id  and v.isActive='yes'";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		List<VendorDto> list = new ArrayList<>();
		while (rst.next() == true) {
			String name = rst.getString("vendor_name");
			String email = rst.getString("email");
			int vendorId = rst.getInt("vendor_id");
			String businessName = rst.getString("business_name");
			String address = rst.getString("vendor_address");

			VendorDto vendor = new VendorDto(vendorId, name, email, businessName, address);
			list.add(vendor);
		}

		pstmt.executeQuery();
		DBConnection.dbClose();
		return list;
	}

	@Override
	public boolean findOneCustomer(int id) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "select customer_id from customer where customer_id=? and isActive='yes' ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);

		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();

		DBConnection.dbClose();
		return status;
	}

	@Override
	public int softDeleteCustomerById(int id) throws SQLException, ResourceNotFoundException {

		Connection con = DBConnection.dbConnect();
		String sql = "update customer set isActive='no' where customer_id =?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, id);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();

		return status;
	}

	@Override
	public List<OrderStatsDto> getOrderStats() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = " select c.name ,c.customer_id ,count(o.order_id) as no_of_orders"
				+ " from customer c Left JOIN orders o"
				+ " ON c.customer_id = o.customer_id "
				+ "where c.isActive='yes' group by c.customer_id;";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		List<OrderStatsDto> list = new ArrayList<>();
		while (rst.next() == true) {
			String name = rst.getString("name");
			int customerId = rst.getInt("customer_id");
			int noOfOrders = rst.getInt("no_of_orders");
			
			OrderStatsDto orders = new OrderStatsDto(customerId,name,noOfOrders);
			list.add(orders);
		}

		pstmt.executeQuery();
		DBConnection.dbClose();
		return list;
	}

	@Override
	public int save(Vendor vendor) throws SQLException {
		Connection con = DBConnection.dbConnect();

		String sql = "insert into vendor (vendor_id, user_id, vendor_name, business_name,vendor_address) "
				+ " values (?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, vendor.getVendorId());
		pstmt.setInt(2, vendor.getUserId());
		pstmt.setString(3, vendor.getVendorName());
		pstmt.setString(4, vendor.getBusinessName());
		pstmt.setString(5, vendor.getVendorAddress());

		int status = pstmt.executeUpdate();
		DBConnection.dbClose();

		return status;
	}
	
	
	@Override
	public int softDeleteVendorById(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "update vendor set isActive='no' where vendor_id =? and  isActive='yes' ";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, id);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();

		return status;
	}
	

	@Override
	public boolean findOneVendor(int id) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "select vendor_id from vendor where vendor_id=? and isActive='yes' ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);

		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();

		DBConnection.dbClose();
		return status;
	}
	


	@Override
	public List<ProductDto> getAllProduct(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql ="select distinct p.name,p.description,p.price,"
				+ "p.offer_percent,p.stock_quantity ,c.name as category "
				+ "from product p Join category c ON "
				+ "p.category_id = c.category_id where vendor_id = ?";
		

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();

		List<ProductDto> list = new ArrayList<>();
		while (rst.next() == true) {
			String name = rst.getString("name");
			String description = rst.getString("description");
			double price = rst.getDouble("price");
			int offerPercent = rst.getInt("offer_percent");
			int stockQuanity = rst.getInt("stock_quantity");
			String category  = rst.getString("category");
			
			ProductDto product = new ProductDto(name,description,price,offerPercent,stockQuanity,category);
			list.add(product);
		}

		pstmt.executeQuery();
		DBConnection.dbClose();
		return list;
	}
	

}
