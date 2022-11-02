package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.UEncoder.SafeCharsSet;
import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import ConnectDB.DBConnect;
import Model.Sach;

public class SachDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<Sach> getAll(){
		List<Sach> s=new ArrayList<>();
		String query="select * from websach.product";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Sach s1=new Sach();
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setImg(rs.getString(3));
				s1.setPrice(rs.getInt(4));
				s1.setTitle(rs.getString(5));
				s1.setDescription(rs.getString(6));
				s1.setCateID(rs.getInt(7));
				s.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public Sach getID(int i){
		Sach s=new Sach();
		String query="select * from websach.product where id="+i;
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Sach s1=new Sach();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setImg(rs.getString(3));
				s.setPrice(rs.getInt(4));
				s.setTitle(rs.getString(5));
				s.setDescription(rs.getString(6));
				s.setCateID(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public List<Sach> getcateID(int i){
		List<Sach> s=new ArrayList<>();
		String query="select * from websach.product where cateID="+i;
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Sach s1=new Sach();
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setImg(rs.getString(3));
				s1.setPrice(rs.getInt(4));
				s1.setTitle(rs.getString(5));
				s1.setDescription(rs.getString(6));
				s1.setCateID(rs.getInt(7));
				s.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public List<Sach> getName(String i){
		List<Sach> s=new ArrayList<>();
		String query="select * from websach.product where lower(name) like binary '%"+i+"%';";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Sach s1=new Sach();
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setImg(rs.getString(3));
				s1.setPrice(rs.getInt(4));
				s1.setTitle(rs.getString(5));
				s1.setDescription(rs.getString(6));
				s1.setCateID(rs.getInt(7));
				s.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public void insertSach(Sach s) {
		String query="insert into websach.product (name,image,price,title,description,cateID) values (?,?,?,?,?,?)";
		try {
			conn=new DBConnect().getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getImg());
			ps.setInt(3, s.getPrice());
			ps.setString(4, s.getTitle());
			ps.setString(5, s.getDescription());
			ps.setInt(6, s.getCateID());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteSach(int i) {
		String query="delete from websach.product where id = ?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, i);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateSach(Sach s) {
		String query="UPDATE websach.product SET name=?, image=?,price=?,title=?,description=?, cateID=? where id=?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getImg());
			ps.setInt(3, s.getPrice());
			ps.setString(4, s.getTitle());
			ps.setString(5, s.getDescription());
			ps.setInt(6, s.getCateID());
			ps.setInt(7, s.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
