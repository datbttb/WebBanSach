package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.Query;

import ConnectDB.DBConnect;
import Model.CartItem;
import Model.Sach;
public class CartDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<CartItem> getAll(int i){
		List<CartItem> ci=new ArrayList<>();
		String query="select p.id,p.name,p.image,p.price,p.title,p.description,p.cateID,c.amount from websach.product as p, websach.cart as c where p.id=c.idsach and c.iduser=?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, i);
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
				int amount1=rs.getInt(8);
				CartItem ci1=new CartItem();
				ci1.setAmount(amount1);
				ci1.setSach(s1);
				ci.add(ci1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ci;
	}
	
	public void insertCart(int sach,int user, int amount) {
		String query="insert into websach.cart (idsach,iduser,amount) values(?,?,?);";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, sach);
			ps.setInt(2, user);
			ps.setInt(3, amount);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int seachCart(int sach, int user) {
		String query="select * from websach.cart where idsach=? and iduser=?;";
		int k=0;
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, sach);
			ps.setInt(2, user);
			rs=ps.executeQuery();
			while(rs.next()) {
				k=rs.getInt(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public void update(int sach, int user, int amount) {
		int am=seachCart(sach, user)+amount;
		String query="update websach.cart set amount=? where idsach=? and iduser=?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, am);
			ps.setInt(2, sach);
			ps.setInt(3, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int sach,int user) {
		String query="delete from websach.cart where idsach=? and iduser=?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, sach);
			ps.setInt(2, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
