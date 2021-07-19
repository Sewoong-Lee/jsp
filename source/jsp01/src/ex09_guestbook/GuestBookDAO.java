package ex09_guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex08.DBConn_DBCP;

public class GuestBookDAO {
	public List<GuestBookDTO> selectlist(String findkey, String findvalue){
		List<GuestBookDTO> glist = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("dao : "+findkey +findvalue);
		
		conn = DBConn_DBCP.getConn();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from guestbook\r\n");
		try {
			if (findkey.equals("nicname")) {
				sb.append("where nicname like '%' || ? || '%'\r\n"); 
				sb.append("order by seq desc"); 
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, findvalue);
			}else if (findkey.equals("email")) {
				sb.append("where email like '%' || ? || '%'\r\n");
				sb.append("order by seq desc"); 
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, findvalue);
			}else if (findkey.equals("nicemail")) {
				sb.append("where nicname like '%' || ? || '%'\r\n"); 
				sb.append("or email like '%' || ? || '%'");
				sb.append("order by seq desc"); 
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, findvalue);
				pstmt.setString(2, findvalue);
			}else if (findkey.equals("content")) {
				sb.append("where content like '%' || ? || '%'\r\n");
				sb.append("order by seq desc"); 
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, findvalue);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String nicname = rs.getString("nicname");
				String email = rs.getString("email");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				
				glist.add(new GuestBookDTO(seq, nicname, email, content, regdate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)rs.close();
				if(conn != null)rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		System.out.println(glist);
		return glist;
	}
	
}
