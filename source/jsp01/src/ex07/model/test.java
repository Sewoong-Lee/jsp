package ex07.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		MemberDAO mdao = new MemberDAO();
		String email = "zz@naver.com";
		String passwd = "111";
		int a = mdao.loginCheck(email, passwd);
		System.out.println(a);
		//성공조건 설정
		assertEquals(0, a);
	}

}
