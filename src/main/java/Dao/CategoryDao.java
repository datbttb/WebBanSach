package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.DBConnect;
import Model.Category;

public class CategoryDao {
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<Category> getAll(){
		List<Category> c=new ArrayList<>();
		String query="select * from websach.category";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category c1=new Category();
				c1.setCid(rs.getInt(1));
				c1.setCname(rs.getString(2));
				c.add(c1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
}
