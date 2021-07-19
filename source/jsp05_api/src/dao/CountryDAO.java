package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class CountryDAO {

	public int insert(List<Map<String, String>> clist, String countryname) {
		int cnt = 0;
		int totalsum = 0;
		try(SqlSession session = MBConn.getSession()){
			for(Map<String,String> cmap : clist) {
				//한건 조회
				Map<String,String> rs= session.selectOne("CountryMapper.selectone", cmap.get("sfty_notice_id"));
				if(rs == null) {
					//데이터가 없다면
					cnt = session.insert("CountryMapper.insert", cmap);
					System.out.println("인서트 :"+cmap.get("country_nm"));
					totalsum += cnt;
				}else {
					//데이터가 있다면
					cnt = session.update("CountryMapper.update", cmap);
					System.out.println("수정 :"+cmap.get("country_nm"));
					totalsum += cnt;
				}
			}
		return totalsum;
	}
}

	public List<Map<String, String>> selectlist(String countryname) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("CountryMapper.selectlist", countryname);
		}
	}

	public Map<String, String> selectone(String sfty_notice_id) {
		try(SqlSession session = MBConn.getSession()){
			return session.selectOne("CountryMapper.selectone", sfty_notice_id);
		}
	}
	
}
