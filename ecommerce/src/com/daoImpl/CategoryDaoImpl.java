package com.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CategoryDao;
import com.model.Category;
import com.utility.DBConnection;
public class CategoryDaoImpl implements CategoryDao{

	@Override
	public boolean findOne(int category_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="select category_id from category where category_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, category_id);
		ResultSet rst  = pstmt.executeQuery();
		boolean status = rst.next(); 
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Category> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="select * from category ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rst = pstmt.executeQuery();
		List<Category> list = new ArrayList<>();
		while(rst.next() == true) {
			int catid = rst.getInt("category_id");
			String name = rst.getString("name");
			Category category = new Category(catid,name);
			list.add(category);
		}
		DBConnection.dbClose();
		return list ;
	}
	
	
	
}
