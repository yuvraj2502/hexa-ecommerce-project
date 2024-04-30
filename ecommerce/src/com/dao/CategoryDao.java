package com.dao;
//AUTHOR SWARNALAKSHMI
import java.sql.SQLException;
import java.util.List;

import com.model.Category;

public interface CategoryDao {

	
boolean findOne(int category_id) throws SQLException;

	

List<Category> findAll() throws SQLException;
	
	
}
