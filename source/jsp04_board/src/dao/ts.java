package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dto.BoardDTO;
import dto.FileDTO;
import dto.MemberDTO;


class ts {
	FileDAO fdao = new FileDAO();
	BoardDAO bdao = new BoardDAO();
	
	@Test
	void test() {
		MBConn.getSession();
	}
	
	@Test
	void test2() {
		//게시물 원본
		BoardDTO bdto = new BoardDTO();
		bdto.setUserid("java");
		bdto.setSubject("테스트");
		bdto.setContent("테스트내용");
		bdto.setIp("0000");
		bdto.setRestep(0);
		bdto.setRelevel(0);
		
		//bdao.insert(bdto);
		System.out.println(bdto);
		
		//게시물 파일
		FileDTO fdto = new FileDTO();
		fdto.setBnum(bdto.getBnum());
		fdto.setFilename("테스트용 파일네임이다.");
				
		fdao.insert(fdto);
		System.out.println(fdto);
	}
	
	@Test
	void test3() {
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
