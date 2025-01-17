package apitest;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class FoodDAO {

	public int insert(List<Map<String, String>> jlist) {
		int cnt = 0;
		int totalsum = 0;
		try(SqlSession session = MBConn.getSession()){
			for(Map<String,String> jmap : jlist) {
				//한건 조회
				Map<String,String> rs= session.selectOne("FoodMapper.selectone", jmap.get("telNo"));
				if(rs == null) {
					//데이터가 없다면
					cnt = session.insert("FoodMapper.insert", jmap);
					System.out.println("인서트 :"+jmap.get("entrprsNm"));
					totalsum += cnt;
				}else {
					//데이터가 있다면
					//cnt = session.update("FoodMapper.update", jmap);
					//System.out.println("수정 :"+jmap.get("entrprsNm"));
					totalsum += cnt;
				}
			}
		}
		return totalsum;
	}

	public List<Map<String, String>> selectlist(String findmenu) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("FoodMapper.selectlist", findmenu);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
