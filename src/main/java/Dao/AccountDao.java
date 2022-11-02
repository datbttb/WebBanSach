package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;

import ConnectDB.DBConnect;
import Model.Account;

public class AccountDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public Account login(String user, String pass) {
		String query = "select * from websach.account where user=? and pass=?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				Account ac=new Account();
				ac.setId(rs.getInt(1));
				ac.setUser(rs.getString(2));
				ac.setPass(rs.getString(3));
				ac.setName(rs.getString(4));
				ac.setEmail(rs.getString(5));
				ac.setCountry(rs.getString(6));
				ac.setIsad(rs.getInt(7));
				return ac;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public Account checkAccountExits(String user) {
		String query = "select * from websach.account where user=?;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			rs=ps.executeQuery();
			while(rs.next()) {
				Account ac=new Account();
				ac.setId(rs.getInt(1));
				ac.setUser(rs.getString(2));
				ac.setPass(rs.getString(3));
				ac.setName(rs.getString(4));
				ac.setEmail(rs.getString(5));
				ac.setCountry(rs.getString(6));
				ac.setIsad(rs.getInt(7));
				return ac;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public void signup(Account a) {
		String query = "insert into websach.account (user,pass,name,email,country,isad) values (?,?,?,?,?,0);";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, a.getUser());
			ps.setString(2, a.getPass());
			ps.setString(3, a.getName());
			ps.setString(4, a.getEmail());
			ps.setString(5, a.getCountry());
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Account> getAll(){
		List<Account> ac=new ArrayList<>();
		String query="select * from websach.account;";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Account ac1=new Account();
				ac1.setId(rs.getInt(1));
				ac1.setUser(rs.getString(2));
				ac1.setPass(rs.getString(3));
				ac1.setName(rs.getString(4));
				ac1.setEmail(rs.getString(5));
				ac1.setCountry(rs.getString(6));
				ac1.setIsad(rs.getInt(7));
				ac.add(ac1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ac;
	}
	
}
