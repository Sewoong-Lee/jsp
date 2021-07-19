package ex07.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//로그인
	public int loginCheck(String email,  String passwd) {
		//이메일, 패스워드 체크
		//DBConnection
		
		int result = 5;
		conn = DBConn.getConn();
		
		String sql = "SELECT * FROM  member WHERE email = ? and passwd = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("데이터 존재");
				result = 0;
			}else {
				System.out.println("데이터 없음");
				result = -1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  //연결 해제
			
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return result;
		
	}
	
	public int insert(MemberDTO mdto) {
		conn = DBConn.getConn();
		int cnt = 0;
		String sql = "INSERT into member(email, passwd, nicname, phone, addr) \r\n" + 
				"values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmail());
			pstmt.setString(2, mdto.getPasswd());
			pstmt.setString(3, mdto.getNicname());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getAddr());
			
			cnt = pstmt.executeUpdate();
			System.out.println("DAO 인서트 cnt : "+ cnt);
		} catch (SQLIntegrityConstraintViolationException e) {
			//유니크 예외처리 1)
			System.out.println("중복된 이메일");
			cnt = -1; //중복된 코드값
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  //연결 해제
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
		return cnt;
	}
	public MemberDTO selectone(String email) {
		MemberDTO mdto = null;
		conn = DBConn.getConn();
		
		String sql = "SELECT * FROM  member WHERE email = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDTO();
				mdto.setEmail(email);
				mdto.setPasswd(rs.getString("passwd"));
				mdto.setNicname(rs.getString("nicname"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAddr(rs.getString("addr"));
				mdto.setRegdate(rs.getString("regdate"));
				mdto.setModifydate(rs.getString("modifydate"));
			}
			System.out.println(mdto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  //연결 해제
			
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return mdto;
	}
	public int delet(String email) {
		int cnt = 0;
		conn = DBConn.getConn();
		
		String sql = "DELETE FROM member WHERE email = ?";
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				
				cnt = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return cnt;
		
	}
	public int update(MemberDTO mdto) {
		int cnt = 0;
		
		conn = DBConn.getConn();
		
		String sql = "UPDATE member  SET passwd = ?, nicname = ?, \r\n" + 
				"phone = ?, addr = ? \r\n" + 
				"WHERE email = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getPasswd());
			pstmt.setString(2, mdto.getNicname());
			pstmt.setString(3, mdto.getPhone());
			pstmt.setString(4, mdto.getAddr());
			pstmt.setString(5, mdto.getEmail());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	public List<MemberDTO> selectall(String listfield, String listvalue) {
		List<MemberDTO> list = new ArrayList<>();
		conn = DBConn.getConn();
		//String sql = "select * from member";
		//String sql = "SELECT * FROM  member\r\n";
		//if(!listfield.equals("") && !listvalue.equals("")) {
		//	if(listfield.equals("email")) {
		//		sql+="WHERE email = ? ";
		//	}else if(listfield.equals("nicname")) {
		//		sql+="WHERE nicname = ? ";
		//	}else if(listfield.equals("phone")) {
		//		sql+="WHERE phone = ? ";
		//	}else if(listfield.equals("addr")) {
		//		sql+="WHERE addr = ? ";
		//	}else {
		//		sql+="";
		//	}
		//}
		
		String sql = "";
				if(!listfield.equals("") && !listvalue.equals("")) {
				sql="SELECT * FROM  member WHERE " +listfield+ " like '%' || ? || '%'";
				}else {
					sql="SELECT * FROM  member";
				}
				
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(!listfield.equals("") && !listvalue.equals("")) {
				pstmt.setString(1, listvalue);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO mdto = new MemberDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPasswd(rs.getString("passwd"));
				mdto.setNicname(rs.getString("nicname"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAddr(rs.getString("addr"));
				mdto.setRegdate(rs.getString("regdate"));
				mdto.setModifydate(rs.getString("modifydate"));
				
				list.add(mdto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list);
		return list;
	}
		
	
}
