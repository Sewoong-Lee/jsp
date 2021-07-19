package model;

import java.util.List;

import org.junit.jupiter.api.Test;


class test {

	@Test
	void test() {
		MBConn.getSession();
	}
	
	@Test
	void insert() {
		PtypeDAO pdao = new PtypeDAO();
		int cnt = pdao.insert(new PtypeDTO("t03","바람"));
		System.out.println("인서트 : "+cnt);
	}
	
	@Test
	void delet() {
		PtypeDAO pdao = new PtypeDAO();
		int cnt = pdao.delete("t03");
		System.out.println("삭제 : "+cnt);
	}
	
	@Test
	void update() {
		PtypeDAO pdao = new PtypeDAO();
		int cnt = pdao.update(new PtypeDTO("t02","바람"));
		System.out.println("수정 : "+cnt);
	}
	
	@Test
	void selectone() {
		PtypeDAO pdao = new PtypeDAO();
		PtypeDTO cnt = pdao.selectone("t02");
		System.out.println("한건조회 : "+cnt);
	}
	
	//@Test
	//void selectlist() {
	//	PtypeDAO pdao = new PtypeDAO();
	//	List<PtypeDTO> cnt = pdao.selectlist();
	//	System.out.println("전체조회 : "+cnt);
	//}
	
	@Test
	void minsert() {
		MonsterDAO mdao = new MonsterDAO();
		int cnt = mdao.insert(new MonsterDTO("m01", "t01", "꼬부기"));
		System.out.println("m추가 : "+cnt);
	}
	
	@Test
	void mdelete() {
		MonsterDAO mdao = new MonsterDAO();
		int cnt = mdao.delete("m02");
		System.out.println("m삭제 : "+cnt);
	}
	
	@Test
	void mupdate() {
		MonsterDAO mdao = new MonsterDAO();
		int cnt = mdao.update(new MonsterDTO("m01", "t01","리아코코"));
		System.out.println("m수정 : "+cnt);
	}
	
	@Test
	void mselectone() {
		MonsterDAO mdao = new MonsterDAO();
		MonsterDTO cnt = mdao.selectone("m01");
		System.out.println("m한건 : "+cnt);
	}
	
	@Test
	void mselectlist() {
		//MonsterDAO mdao = new MonsterDAO();
		//List<MonsterDTO> cnt = mdao.selectlist();
		//System.out.println("m전체 : "+cnt);
	}
	
	@Test
	void selecttypecount() {
		MonsterDAO mdao = new MonsterDAO();
		int cnt = mdao.selecttypecount("t01");
		System.out.println("tcod 사용건수 : "+cnt);
	}
	

}
