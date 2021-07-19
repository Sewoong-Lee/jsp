package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class membertest {

	@Test
	void test() {
		MBConn.getSession();
	}
	
	@Test
	void insert() {
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.insert(new MemberDTO("s2","1111", "ss", "ss"));
		System.out.println("인서트 : "+cnt);
	}
	
	@Test
	void update() {
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.update(new MemberDTO("s2","0000", "zzz"));
		System.out.println("업데이트 : "+cnt);
	}
	
	@Test
	void delete() {
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.delete("s2");
		System.out.println("삭제 : "+cnt);
	}
	
	@Test
	void selectone() {
		MemberDAO mdao = new MemberDAO();
		MemberDTO cnt = mdao.selectone("ss");
		System.out.println("한건조회 : "+cnt);
	}
	
	@Test
	void seleclist() {
		MemberDAO mdao = new MemberDAO();
		List<MemberDTO> cnt = mdao.selectlist();
		System.out.println("전체조회 : "+cnt);
	}
	
	
	
	
	
}
