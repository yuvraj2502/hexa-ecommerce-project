package com.service;
//author - swarna
import java.sql.SQLException;
import java.util.List;

import com.model.Category;
import com.dao.*;
import com.daoImpl.*;
public class CategoryService {

	CategoryDao dao=new CategoryDaoImpl();
	
	public boolean isCategoryExists(int categoryId) throws SQLException {
	  
	    return dao.findOne(categoryId);
	}
	
	public List<Category> findAll()throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
