package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class PtypeDAO {
		
		public int insert(PtypeDTO pdto) {
			//try whit 리소스 관리법
			try(SqlSession session = MBConn.getSession()){
				return session.insert("PtypeMapper.insert", pdto);
			}
		}
		
		public int update(PtypeDTO pdto) {
			try(SqlSession session = MBConn.getSession()){
			return session.insert("PtypeMapper.update", pdto);
			}
		}
		
		public int delete(String tcode) {
			try(SqlSession session = MBConn.getSession()){
			return session.delete("PtypeMapper.delete", tcode);
			}
		}
		
		public PtypeDTO selectone(String tcode) {
			try(SqlSession session = MBConn.getSession()){
			return session.selectOne("PtypeMapper.selectone", tcode);
			}
		}
		
		public List<PtypeDTO> selectlist(String findkey, String findvalue) {
			try(SqlSession session = MBConn.getSession()){
				//매퍼에는 매개변수를 하나만 넘길수 있다.
				//맵으로 두개의 값을 넘긴다.
				Map<String,String> findmap = new HashMap<>();
				findmap.put("findkey", findkey);
				findmap.put("findvalue", findvalue);
				
				return session.selectList("PtypeMapper.selectlist",findmap);
			}
		}
	
}
