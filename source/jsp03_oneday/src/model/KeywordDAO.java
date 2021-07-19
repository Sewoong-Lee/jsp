package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class KeywordDAO {
	
	public int insert(KeywordDTO kdto) {
		SqlSession session = MBConn.getSession();
		return session.update("KeywordMapper.insert", kdto);
	}
	
	public int update(KeywordDTO kdto) {
		SqlSession session = MBConn.getSession();
		return session.update("KeywordMapper.update", kdto);
	}
	
	public int delete(String kwcode) {
		SqlSession session = MBConn.getSession();
		return session.delete("KeywordMapper.delete", kwcode);
		
	}
	
	public KeywordDTO selectone(String kwcode) {
		SqlSession session = MBConn.getSession();
		return session.selectOne("KeywordMapper.selectone", kwcode);
		
	}
	
	public List<KeywordDTO> selectlist() {
		SqlSession session = MBConn.getSession();
		
		return session.selectList("KeywordMapper.selectlist");
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
