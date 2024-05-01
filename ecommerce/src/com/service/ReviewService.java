package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.*;
import com.daoImpl.*;
import com.dto.ListProductbyRatingDto;
import com.exception.ResourceNotFoundException;
import com.model.Review;

public class ReviewService {
	ReviewDao dao=new ReviewDaoImpl();
	CustomerDao custdao=new CustomerDaoImpl();
	ProductDao prodao=new ProductDaoImpl();
	public List<ListProductbyRatingDto> findprodcts(int rating_value)throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
         if(rating_value>5) {
        	 throw new ResourceNotFoundException("Enter rating value betweem 1 to 5");
        	 
         }
         if(rating_value<1) {
        	 throw new ResourceNotFoundException("Enter rating value between 1 to 5");
         }
		return dao.findproducts(rating_value);
		}
	public int save(Review review)throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		 return dao.save(review);
		
	}
	
}
