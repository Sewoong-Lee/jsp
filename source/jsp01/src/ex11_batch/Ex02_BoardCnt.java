package ex11_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Ex02_BoardCnt implements Job{
	
	public int selectcnt() {
		int cnt=0;
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
				//System.out.println(cnt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return cnt;
	}
	
	//게시물 수 저장
	public int insertboardcnt(int boardcnt) {
		int cnt = 0;
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO boardcnt (num,cnt)  \r\n" + 
				"VALUES (boardcnt_num.nextval,?)";
		try {
			//오토커밋 중지, 내가 커밋 할때까지 커밋 안됨
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardcnt);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+"건 저장");
			conn.commit();
		} catch (Exception e) {
			try {
				//오류시 롤백
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		return cnt;
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//db 건수 출력 (마이바티스)
		//SqlSession session = MBConn.getSession();
		//int cnt1 = session.selectOne("MemberMapper.selecttotcnt");
		//System.out.println(cnt1);
		
		//db 건수 출력 (기존 방법)
		int cnt = selectcnt();
		System.out.println("계시물수 : " + cnt);
		
		//db에 건수 저장
		insertboardcnt(cnt);
		
	}

}
