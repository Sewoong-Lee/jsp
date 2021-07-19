package ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	static Connection getConn() {
		Connection conn = null;
		//오라클 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 로딩 완료");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("컨넥션 완료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return conn;
	}
	
	
	
	
	

}
