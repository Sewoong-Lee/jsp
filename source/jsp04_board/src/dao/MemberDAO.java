package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.MemberDTO;

public class MemberDAO {
	
	public int insert(MemberDTO mdto) {
		try(SqlSession session = MBConn.getSession()){
			return session.insert("MemberMapper.insert", mdto);
		}
	}
	
	public int update(MemberDTO mdto) {
		SqlSession session = MBConn.getSession();
		return session.update("MemberMapper.update", mdto);
	}
	
	public int delete(String userid) {
		SqlSession session = MBConn.getSession();
		return session.delete("MemberMapper.delete", userid);
		
	}
	
	public MemberDTO selectone(String userid) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectOne("MemberMapper.selectone", userid);
		}
		
	}
	
	public List<MemberDTO> selectlist() {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("MemberMapper.selectlist");
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
