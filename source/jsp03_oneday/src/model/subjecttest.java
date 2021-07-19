package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class subjecttest {

	@Test
	void test() {
		MBConn.getSession();
	}
	
	@Test
	void insert() {
		SubjectDAO kdao = new SubjectDAO();
		int cnt = kdao.insert(new SubjectDTO("002","1111", 333, "qwe", "001"));
		System.out.println("인서트 : "+cnt);
	}
	
	@Test
	void update() {
		SubjectDAO kdao = new SubjectDAO();
		int cnt = kdao.update(new SubjectDTO("002","subname", 55, "aaa", "001"));
		System.out.println("업데이트 : "+cnt);
	}
	
	@Test
	void delete() {
		SubjectDAO kdao = new SubjectDAO();
		int cnt = kdao.delete("002");
		System.out.println("삭제 : "+cnt);
	}
	
	@Test
	void selectone() {
		SubjectDAO kdao = new SubjectDAO();
		//SubjectDTO cnt = kdao.selectone("001");
		//System.out.println("한건조회 : "+cnt);
	}
	
	@Test
	void seleclist() {
		//SubjectDAO kdao = new SubjectDAO();
		//List<Map<String, Object>> cnt = kdao.selectlist();
		//System.out.println("전체조회 : "+cnt);
	}

}
