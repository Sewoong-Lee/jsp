package service;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.FileDTO;

public class replyservice {
	
	static BoardDAO bdao = new BoardDAO();
	//댓글 저장
	public static void  insert(BoardDTO bdto) {
		//기존 db 글 순서 변경	
		bdao.updaterestep(bdto);

		//글 순서 +1
		bdto.setRestep(bdto.getRestep()+1);
		//글레벨+1
		bdto.setRelevel(bdto.getRelevel()+1);
		
		System.out.println(bdto);
		
		bdao.insert(bdto);
		

	}
	public static void delete(int bnum) {
		
		bdao.delete(bnum);
	}

	public BoardDTO selectone(int bnum) {
		
		return bdao.selectonereply(bnum);
	}
	public static int uptate(BoardDTO bdto) {
		return bdao.update(bdto);
		
	}
	
}
