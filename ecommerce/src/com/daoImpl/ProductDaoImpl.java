package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.exception.ResourceNotFoundException;
import com.model.Product;
import com.utility.DBConnection;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> findAll() throws SQLException {
		
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select * from product";
		PreparedStatement pstmt= con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Product> list =new ArrayList<>();
		while(rst.next()==true) {
			int id=rst.getInt("product_id");
			String name=rst.getString("name");
			String description=rst.getString("description");
			double price=rst.getDouble("price");
			int offer_percent=rst.getInt("offer_percent");
			int stock_quantity=rst.getInt("stock_quantity");
			int category_id=rst.getInt("category_id");
			int vendor_id=rst.getInt("vendor_id");
		
	        Product product = new Product(id,name,description,price,offer_percent,stock_quantity,category_id,vendor_id);
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
		
		
	}
	@Override
	public List<Product> getProductByCategory(int category_id) throws SQLException{
	
		Connection con = DBConnection.dbConnect();
		String sql = "select * from product where category_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setInt(1, category_id);
	    ResultSet rst = pstmt.executeQuery();
	    List<Product> list = new ArrayList<>();
	    while(rst.next() == true) {
	    	int product_id =rst.getInt("product_id");
	    	String name =rst.getString("name");
	    	String description = rst.getString("description");
	    	double price =rst.getDouble("price");
	    	int offer_percent = rst.getInt("offer_percent");
	    	int stock_quantity = rst.getInt("stock_quantity");
	    	int category_id1 = rst.getInt("category_id");
	    	int vendor_id = rst.getInt("vendor_id");
	    	Product product = new Product(product_id,name,description,price,offer_percent,stock_quantity,category_id1,vendor_id);
	    	list.add(product);

	}
	    DBConnection.dbClose();
		return list;

}
	@Override
	public boolean findOne(int product_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="select product_id from product where  product_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, product_id);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;
		
		
	}
	@Override
	public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) throws SQLException,ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
        String sql = "select * from product where price between ? and ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setDouble(1, minPrice);
        pstmt.setDouble(2, maxPrice);
        ResultSet rst = pstmt.executeQuery();
        List<Product> list = new ArrayList<>();
        while (rst.next()) {
            int product_id = rst.getInt("product_id");
            String name = rst.getString("name");
            String description = rst.getString("description");
            double price = rst.getDouble("price");
            int offer_percent = rst.getInt("offer_percent");
            int stock_quantity = rst.getInt("stock_quantity");
            int category_id = rst.getInt("category_id");
            int vendor_id = rst.getInt("vendor_id");
            Product product = new Product(product_id, name, description, price, offer_percent, stock_quantity,
                    category_id, vendor_id);
            list.add(product);
        }
        DBConnection.dbClose();
        return list;
	}
	@Override
	public boolean isProductExists(int productId) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select *from product where product_id = ?"; 
		PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, productId);
        ResultSet rst = pstmt.executeQuery();
        boolean status = rst.next();
       
		DBConnection.dbClose();
		return status;
	}

	@Override
	public Product findByID(int product_id) throws SQLException {
		// TODO Auto-generated method stub
		 Product product = null;
		    Connection con = DBConnection.dbConnect();
		    String sql = "select * from product where product_id = ?";
		    PreparedStatement statement = con.prepareStatement(sql);
		    statement.setInt(1, product_id);
		    ResultSet resultSet = statement.executeQuery();
		    if (resultSet.next()) {
		        product = new Product();
		        product.setProduct_id(resultSet.getInt("product_id"));
		        product.setName(resultSet.getString("name"));
		        product.setDescription(resultSet.getString("description"));
		        product.setPrice(resultSet.getDouble("price"));
		        product.setOffer_percent(resultSet.getInt("offer_percent"));
		        product.setStock_quantity(resultSet.getInt("stock_quantity"));
		        product.setCategory_id(resultSet.getInt("category_id"));
		        product.setVendor_id(resultSet.getInt("vendor_id"));
		    }
		    DBConnection.dbClose();
		return product;
	}
	
	
}
