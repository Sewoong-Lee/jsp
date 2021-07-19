package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MonsterDAO {
	public int insert(MonsterDTO mdto) {		
		int cnt = 0;
		//try with : 자동으로 session close
		try(SqlSession session = MBConn.getSession()){
			cnt =  session.insert("MonsterMapper.insert", mdto);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			System.out.println("중복된 코드");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	public int update(MonsterDTO mdto) {
		SqlSession session = MBConn.getSession();
		return session.update("MonsterMapper.update", mdto);
		
	}
	
	public int delete(String mcode) {
		SqlSession session = MBConn.getSession();
		return session.delete("MonsterMapper.delete", mcode);
		
	}
	
	public MonsterDTO selectone(String mcode) {
		SqlSession session = MBConn.getSession();
		return session.selectOne("MonsterMapper.selectone", mcode);
		
	}
	
	public List<MonsterDTO> selectlist(String findkey, String findvalue) {
		SqlSession session = MBConn.getSession();
		Map<String,String> mmap = new HashMap<>();
		
		mmap.put("findkey", findkey);
		mmap.put("findvalue", findvalue);
		
		return session.selectList("MonsterMapper.selectlist", mmap);
		
	}
	//타입을 사용하고 있는 몬스터 데이터 카운트
	public int selecttypecount(String tcode) {
		SqlSession session = MBConn.getSession();
		return session.selectOne("MonsterMapper.selecttypecount", tcode);
		
	}
	
}
