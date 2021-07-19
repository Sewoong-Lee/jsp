package ex10_mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestDAO {
	
	public int insert(GuestBookDTO gdto) {
		SqlSession session = MBConn.getSession();
		return session.insert("GuestMapper.insert", gdto);
	}
	
	public int update(GuestBookDTO gdto) {
		SqlSession session = MBConn.getSession();
		return session.insert("GuestMapper.update", gdto);
		
	}
	
	public int delete(int seq) {
		SqlSession session = MBConn.getSession();
		return session.delete("GuestMapper.delete", seq);
		
	}
	
	public GuestBookDTO selectone(int seq) {
		SqlSession session = MBConn.getSession();
		return session.selectOne("GuestMapper.selectone", seq);
		
	}
	
	public List<GuestBookDTO> selectlist() {
		SqlSession session = MBConn.getSession();
		return session.selectList("GuestMapper.selectlist");
		
	}
	
	
	
}
