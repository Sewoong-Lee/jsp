package ex10_mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		//MBConn.getSession();
	}
	
	@Test
	void insert() {
		GuestDAO gdao = new GuestDAO();
		int cnt = gdao.insert(new GuestBookDTO("야야","ss@naver.com","테스트"));
		System.out.println("인서트 : "+cnt);
	}
	
	@Test
	void update() {
		GuestDAO gdao = new GuestDAO();
		int cnt = gdao.update(new GuestBookDTO(3,"무야야2","qwe@naver.com","테스트3"));
		System.out.println("업데이트 : "+cnt);
	}
	
	@Test
	void delete() {
		GuestDAO gdao = new GuestDAO();
		int cnt = gdao.delete(2);
		System.out.println("삭제 : "+cnt);
	}
	
	@Test
	void selectone() {
		GuestDAO gdao = new GuestDAO();
		GuestBookDTO gdto = gdao.selectone(18);
		System.out.println("조회 : "+gdto);
	}
	
	@Test
	void selectlist() {
		GuestDAO gdao = new GuestDAO();
		List<GuestBookDTO> glist = gdao.selectlist();
		System.out.println("전체 조회 : "+glist);
	}

}
