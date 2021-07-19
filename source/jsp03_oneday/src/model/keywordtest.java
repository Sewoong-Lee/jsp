package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class keywordtest {

	@Test
	void test() {
		MBConn.getSession();
	}
	
	@Test
	void insert() {
		KeywordDAO kdao = new KeywordDAO();
		int cnt = kdao.insert(new KeywordDTO("002","1111"));
		System.out.println("인서트 : "+cnt);
	}
	
	@Test
	void update() {
		KeywordDAO kdao = new KeywordDAO();
		int cnt = kdao.update(new KeywordDTO("002","0000"));
		System.out.println("업데이트 : "+cnt);
	}
	
	@Test
	void delete() {
		KeywordDAO kdao = new KeywordDAO();
		int cnt = kdao.delete("002");
		System.out.println("삭제 : "+cnt);
	}
	
	@Test
	void selectone() {
		KeywordDAO kdao = new KeywordDAO();
		KeywordDTO cnt = kdao.selectone("001");
		System.out.println("한건조회 : "+cnt);
	}
	
	@Test
	void seleclist() {
		KeywordDAO kdao = new KeywordDAO();
		List<KeywordDTO> cnt = kdao.selectlist();
		System.out.println("전체조회 : "+cnt);
	}

}
