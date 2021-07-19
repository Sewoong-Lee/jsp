package model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SalesDAO {
	
	public int insert(SalesDTO sdto) {
		SqlSession session = MBConn.getSession();
		return session.update("SalesMapper.insert", sdto);
	}
	
	public int update(SalesDTO sdto) {
		SqlSession session = MBConn.getSession();
		return session.update("SalesMapper.update", sdto);
	}
	
	public int delete(int seq) {
		SqlSession session = MBConn.getSession();
		return session.delete("SalesMapper.delete", seq);
		
	}
	
	public SalesDTO selectone(int seq) {
		SqlSession session = MBConn.getSession();
		return session.selectOne("SalesMapper.selectone", seq);
		
	}
	
	public List<SalesDTO> selectlist() {
		SqlSession session = MBConn.getSession();
		
		return session.selectList("SalesMapper.selectlist");
	}
	
	public List<Map<String, Object>> select_detail(Map<String, String> datemap) {
		SqlSession session = MBConn.getSession();
		
		return session.selectList("SalesMapper.select_detail", datemap);
	}

	public List<Map<String, Object>> select_total(Map<String, String> datemap) {
		SqlSession session = MBConn.getSession();
		
		return session.selectList("SalesMapper.select_total", datemap);
	}
	
	
}
