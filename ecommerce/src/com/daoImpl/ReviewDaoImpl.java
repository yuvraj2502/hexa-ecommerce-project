package com.daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ReviewDao;
import com.dto.ListProductbyRatingDto;
import com.exception.ResourceNotFoundException;
import com.model.Review;
import com.utility.DBConnection;


public class ReviewDaoImpl implements ReviewDao {
	@Override
	public List<ListProductbyRatingDto> findproducts(int rating_value) throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
        String query = "SELECT p.product_id,p.name,r.rating,p.price,p.offer_percent,p.stock_quantity "
        		+ " FROM product p LEFT JOIN review r ON r.product_id=p.product_id "
        		+ " Where r.rating >=? ";
        		//+ " ORDER BY r.rating DESC ";
        
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, rating_value);
        ResultSet rst = pstmt.executeQuery();
        List<ListProductbyRatingDto> list=new ArrayList<>();
       

        while (rst.next()==true) { // Expecting only one refund for each order_id
            int product_id = rst.getInt("product_id");
            String product_name= rst.getString("name");
            int rating = rst.getInt("rating");
            double price = rst.getDouble("price");
            int offer_percent=rst.getInt("offer_percent");
            
            int stock_quantity=rst.getInt("stock_quantity");
            
         
            ListProductbyRatingDto productbyrating= new ListProductbyRatingDto(product_id,product_name,rating,price,offer_percent,stock_quantity);
             list.add(productbyrating);
        }
        DBConnection.dbClose();
        return list;
	}
	@Override
	public int save(Review review) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO review (review_id, customer_id, product_id, review_content, rating,review_date) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, review.getReview_id());
		pstmt.setInt(2, review.getCustomer_id());
		pstmt.setInt(3,review.getProduct_id());
		pstmt.setString(4,review.getReview_content());
		pstmt.setInt(5,review.getRating());
		pstmt.setString(6,review.getReview_date());
		
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
