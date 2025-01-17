package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.CovidDTO;

public class Coviddao {
	public int insert(List<Map<String,String>> covidlist) {
		int cnt = 0;
		int totalsum = 0;
		try(SqlSession session = MBConn.getSession()){
			for(Map<String,String> covidmap : covidlist) {
				//한건 조회
				Map<String,String> rs= session.selectOne("CovidMapper.selectone", covidmap.get("stateDt"));
				if(rs == null) {
					//데이터가 없다면
					cnt = session.insert("CovidMapper.insert", covidmap);
					System.out.println("인서트 날짜:"+covidmap.get("stateDt"));
					totalsum += cnt;
				}else {
					//데이터가 있다면
					cnt = session.update("CovidMapper.update", covidmap);
					System.out.println("up:"+cnt+" "+covidmap.get("stateDt"));
					totalsum += cnt;
				}
			}
		}
		return totalsum;
	}
	
	
	public List<CovidDTO> selectlist(Map<String,String> covidmap) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("CovidMapper.selectlist", covidmap);
		}
	}
	
	
	
	
	
	
}
