package model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SubjectDAO {
	
	public int insert(SubjectDTO sdto) {
		SqlSession session = MBConn.getSession();
		return session.update("SubjectMapper.insert", sdto);
	}
	
	public int update(SubjectDTO sdto) {
		SqlSession session = MBConn.getSession();
		return session.update("SubjectMapper.update", sdto);
	}
	
	public int delete(String subcode) {
		SqlSession session = MBConn.getSession();
		return session.delete("SubjectMapper.delete", subcode);
		
	}
	
	public Map<String, Object> selectone(String subcode) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectOne("SubjectMapper.selectone", subcode);
		}
	}
	
	public List<Map<String, Object>> selectlist(Map<String, String> findmap) {	
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("SubjectMapper.selectlist",findmap);
		}
		
	}
		
	
	
	//public List<MemberDTO> selectlist(String findkey, String findvalue) {
	//	SqlSession session = MBConn.getSession();
	//	Map<String,String> mmap = new HashMap<>();
	//	
	//	mmap.put("findkey", findkey);
	//	mmap.put("findvalue", findvalue);
	//	
	//	return session.selectList("MonsterMapper.selectlist", mmap);
	//}
}
