package ex05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DB에 접속하는 역할
public class ScheduleDAO {
	//추가 메소드
	int insert(ScheduleDTO sdto) {
		//db접속
		Connection conn = DBConn.getConn();
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO schedule (sdate,stime,subject,content)  VALUES (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sdto.getSdate());
			pstmt.setInt(2, sdto.getStime());
			pstmt.setString(3, sdto.getSubject());
			pstmt.setString(4, sdto.getContent());
			
			cnt = pstmt.executeUpdate();
			
			System.out.println("DAO인서트" + cnt);
			
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
	
	//타임 테이블 조회
	List<TimeDTO> selectlist(String startdate, String enddate){
		System.out.println("타임 테이블 진입");
		
		//Map<String, String> map = new HashMap<>();
		//List<Map<String, String>> tlist = new ArrayList<>();
		
		List<TimeDTO> tlist = new ArrayList<TimeDTO>();
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  sdate,\r\n" + 
				"    nvl(max(decode(stime,1,subject)),' ') t1,\r\n" + 
				"     nvl(max(decode(stime,2,subject)),' ') t2,\r\n" + 
				"      nvl(max(decode(stime,3,subject)),' ') t3,\r\n" + 
				"       nvl(max(decode(stime,4,subject)),' ') t4,\r\n" + 
				"        nvl(max(decode(stime,5,subject)),' ') t5,\r\n" + 
				"         nvl(max(decode(stime,6,subject)),' ') t6,\r\n" + 
				"          nvl(max(decode(stime,7,subject)),' ') t7,\r\n" + 
				"           nvl(max(decode(stime,8,subject)),' ') t8\r\n" + 
				"FROM  schedule\r\n";
				if(!startdate.equals("") && !enddate.equals("")) {
				sql+="WHERE sdate BETWEEN ? and ?\r\n";
				}
				sql+="group by sdate\r\n" + 
				"order by sdate ";
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(!startdate.equals("") && !enddate.equals("")) {
				pstmt.setString(1, startdate);
				pstmt.setString(2, enddate);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//sdto.setSdate(rs.getString("sdate")); 이렇게도 가능
				TimeDTO sdto = new TimeDTO();
				sdto.setSdate(rs.getString("sdate"));
				sdto.setT1(rs.getString("t1"));
				sdto.setT2(rs.getString("t2"));
				sdto.setT3(rs.getString("t3"));
				sdto.setT4(rs.getString("t4"));
				sdto.setT5(rs.getString("t5"));
				sdto.setT6(rs.getString("t6"));
				sdto.setT7(rs.getString("t7"));
				sdto.setT8(rs.getString("t8"));
				
				//위에처럼 하면 뒤에 생성자 안써도댐
				//slist.add(sdto); 이렇게 하면댐
				
				tlist.add(sdto);
				//slist.add(new TimeDTO());
				
				//System.out.println(tlist);
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
		return tlist;
	}
	//리스트 조회
		List<ScheduleDTO> selectlistback(){
			System.out.println("셀렉트 리스트 진입");
			
			List<ScheduleDTO> slist = new ArrayList<ScheduleDTO>();
			
			Connection conn = DBConn.getConn();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM  schedule";
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					//sdto.setSdate(rs.getString("sdate")); 이렇게도 가능
					ScheduleDTO sdto = new ScheduleDTO();
					String sdate = rs.getString("sdate");
					int stime = rs.getInt("stime");
					String subject = rs.getString("subject");
					String content = rs.getString("content");
					String regdate = rs.getString("regdate");
					String modifydate = rs.getString("modifydate");
					
					//위에처럼 하면 뒤에 생성자 안써도댐
					//slist.add(sdto); 이렇게 하면댐
					slist.add(new ScheduleDTO(sdate, stime, subject, content,regdate,modifydate));
					
					//System.out.println(slist);
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
			
			
			
			
			return slist;
		}
	// 한건 조회
	ScheduleDTO selectone(String sdate,int stime) {
		ScheduleDTO sdto = new ScheduleDTO();
		
		Connection conn = DBConn.getConn();
		
		String sql = "SELECT * FROM  schedule WHERE sdate = ? and stime = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sdate);
			pstmt.setInt(2, stime);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
			sdto.setSdate(rs.getString("sdate"));
			sdto.setStime(rs.getInt("stime"));
			sdto.setSubject(rs.getString("subject"));
			sdto.setContent(rs.getString("content"));
			sdto.setRegdate(rs.getString("regdate"));
			sdto.setModifydate(rs.getString("modifydate"));
			}
			System.out.println(sdto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sdto;
	}
	
	int update(ScheduleDTO sdto) {
		
		Connection conn = DBConn.getConn();
		int cnt = 0;
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE schedule ");
		sb.append("SET subject = ?, content = ? ");
		sb.append("WHERE sdate = ? and stime = ?");
		
		//String sql = "UPDATE schedule  SET subject = ?, content = ?  WHERE sdate = ? and stime = ?";
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, sdto.getSubject());
			pstmt.setString(2, sdto.getContent());
			pstmt.setString(3, sdto.getSdate());
			pstmt.setInt(4, sdto.getStime());
			
			cnt = pstmt.executeUpdate();
			
			System.out.println("DAO업데이트 : " + cnt);
			
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
	
	//삭제
	int delete(String sdate,int stime) {
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM schedule WHERE sdate = ? and stime = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sdate);
			pstmt.setInt(2, stime);
			
			cnt = pstmt.executeUpdate();
			System.out.println("딜리트 완료건 : "+cnt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	//map의 리스트 만들기
	List<Map<String, String>> selectmap(String startdate, String enddate){
		System.out.println("타임 테이블 진입");
		
		//Map<String, String> map = new HashMap<>();
		List<Map<String, String>> tlist = new ArrayList<>();
		
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  sdate,\r\n" + 
				"    nvl(max(decode(stime,1,subject)),' ') t1,\r\n" + 
				"     nvl(max(decode(stime,2,subject)),' ') t2,\r\n" + 
				"      nvl(max(decode(stime,3,subject)),' ') t3,\r\n" + 
				"       nvl(max(decode(stime,4,subject)),' ') t4,\r\n" + 
				"        nvl(max(decode(stime,5,subject)),' ') t5,\r\n" + 
				"         nvl(max(decode(stime,6,subject)),' ') t6,\r\n" + 
				"          nvl(max(decode(stime,7,subject)),' ') t7,\r\n" + 
				"           nvl(max(decode(stime,8,subject)),' ') t8\r\n" + 
				"FROM  schedule\r\n";
				if(!startdate.equals("") && !enddate.equals("")) {
				sql+="WHERE sdate BETWEEN ? and ?\r\n";
				}
				sql+="group by sdate\r\n" + 
				"order by sdate ";
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(!startdate.equals("") && !enddate.equals("")) {
				pstmt.setString(1, startdate);
				pstmt.setString(2, enddate);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, String> smap = new HashMap<>();
				
				smap.put("sdate", rs.getString("sdate"));
				smap.put("t1", rs.getString("t1"));
				smap.put("t2", rs.getString("t2"));
				smap.put("t3", rs.getString("t3"));
				smap.put("t4", rs.getString("t4"));
				smap.put("t5", rs.getString("t5"));
				smap.put("t6", rs.getString("t6"));
				smap.put("t7", rs.getString("t7"));
				smap.put("t8", rs.getString("t8"));

				tlist.add(smap);
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
		return tlist;
	}
	
	
}
