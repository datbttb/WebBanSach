package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConnection() {
		Connection c=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mySQL://localhost:3306/websach";
			String username = "root";
			String password = "123456";
			c=DriverManager.getConnection(url,username,password);
			System.out.println("Thanh cong");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
