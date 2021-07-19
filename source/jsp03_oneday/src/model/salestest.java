package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class salestest {

	@Test
	void test() {
		MBConn.getSession();
	}
	
	@Test
	void insert() {
		SalesDAO sdao = new SalesDAO();
		int cnt = sdao.insert(new SalesDTO("2020-08-06","001","ss",3,3000));
		System.out.println("인서트 : "+cnt);
	}
	
	@Test
	void update() {
		SalesDAO sdao = new SalesDAO();
		int cnt = sdao.update(new SalesDTO(3,"2020-08-06","001", "ss", 99, 555));
		System.out.println("업데이트 : "+cnt);
	}
	
	@Test
	void delete() {
		SalesDAO sdao = new SalesDAO();
		int cnt = sdao.delete(3);
		System.out.println("삭제 : "+cnt);
	}
	
	@Test
	void selectone() {
		SalesDAO sdao = new SalesDAO();
		SalesDTO cnt = sdao.selectone(4);
		System.out.println("한건조회 : "+cnt);
	}
	
	@Test
	void seleclist() {
		SalesDAO sdao = new SalesDAO();
		List<SalesDTO> cnt = sdao.selectlist();
		System.out.println("전체조회 : "+cnt);
	}

}
