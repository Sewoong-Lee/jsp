package apitest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MBConn {
	//sf 참조변수 싱글톤 패턴으로
	public static SqlSessionFactory sf = null;
	
	public static SqlSession getSession() {
		String resource = "mybatis/mybatisConfig.xml";
		SqlSession session = null;
		try {
			if(sf == null) {
				InputStream is = Resources.getResourceAsStream(resource);
				sf = new SqlSessionFactoryBuilder().build(is);
			}
			session = sf.openSession();
			System.out.println("마이바티스 성공");
		} catch (IOException e) {
			System.out.println("마이바티스 환경파일 읽기 실패");
			e.printStackTrace();
		}
		
		return session;
	}
}
