package ex11_batch;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConn_DBCP {
	
	public static Connection getConn() {
		Connection conn = null;
		//컨넥션풀(DBCP)을 이용해서 객체 생성
		try {
			//1. context 객체 생성
			Context context = new InitialContext();
			//2. context객체에서 datasource 얻기
			DataSource ds = (DataSource)context.lookup("java:comp/env/ora");
			conn = ds.getConnection();
			System.out.println("dbcp 접속 성공");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
	
}
