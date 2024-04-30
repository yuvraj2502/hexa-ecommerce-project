package com.dao;
//AUTHOR=SUNITHA
import java.sql.SQLException;
import java.util.List;

import com.dto.ListProductbyRatingDto;
import com.exception.ResourceNotFoundException;
import com.model.Review;

public interface ReviewDao {

	List<ListProductbyRatingDto> findproducts(int rating_value)throws SQLException,ResourceNotFoundException;

    int save(Review review)throws SQLException,ResourceNotFoundException;
}
