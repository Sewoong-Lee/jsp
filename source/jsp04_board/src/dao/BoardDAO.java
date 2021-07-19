package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.BoardDTO;
import dto.FileDTO;
import dto.PageDTO;



public class BoardDAO {
	//트랜젝션 테스트
	public int traninsert(BoardDTO bdto, FileDTO fdto) {
		int cnt = 0;
		SqlSession session = null;
		try{
			System.out.println("트랜잭션 시작");
			session = MBConn.getSession();
			cnt = session.insert("BoardMapper.insert", bdto); //게시물 등록
			if(fdto.getFilename() != null) {
				fdto.setBnum(bdto.getBnum());
				session.insert("BoardFileMapper.insert", fdto);  //파일 등록
			}
			
			session.commit();
			
		}catch (Exception e) {
			System.out.println("트랜잭션 롤백");
			session.rollback();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}
	
	public int insert(BoardDTO bdto) {
		try(SqlSession session = MBConn.getSession()){
			return session.insert("BoardMapper.insert", bdto);
		}
	}
	//원본 조회
	public List<Map<String, Object>> list(PageDTO pdtp) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("BoardMapper.selectlist", pdtp);
		}
	}
	//댓글 조회
	public List<BoardDTO> selectlistreply(int bnum) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("BoardMapper.selectreply", bnum);
		}
	}
	
	public Map<String, Object> selectone(int bnum) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectOne("BoardMapper.selectone", bnum);
		}
	}
	
	//글순서 +1
	public int updaterestep(BoardDTO bdto) {
		try(SqlSession session = MBConn.getSession()){
			return session.update("BoardMapper.updaterestep", bdto);
		}
	}
	public int update(BoardDTO bdto) {
		try(SqlSession session = MBConn.getSession()){
			return session.update("BoardMapper.update", bdto);
		}
	}
	public int delete(int bnum) {
		try(SqlSession session = MBConn.getSession()){
			return session.update("BoardMapper.delete", bnum);
		}
	}
	public BoardDTO selectonereply(int bnum) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectOne("BoardMapper.selectonerepy", bnum);
		}
	}
		//조회수 +1
	public int readcountadd(int bnum) {
		try(SqlSession session = MBConn.getSession()){
			return session.update("BoardMapper.readcountadd", bnum);
		}
	}
	public int selecttotcnt(PageDTO pdtp) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectOne("BoardMapper.selecttotcnt", pdtp);
		}
	}
	
	
	
}
