package service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dao.FileDAO;
import dto.BoardDTO;
import dto.FileDTO;
import dto.PageDTO;



public class boardservice {
	
	BoardDAO bdao = new BoardDAO();
	FileDAO fdao = new FileDAO();
	
	
	public void  insert(BoardDTO bdto, FileDTO fdto) {
		//게시물 저장
		bdao.insert(bdto);
		
		//파일 저장
		//먼저 Bnum이 만들어지면 이후에 파일DTO에 셋팅
		if(fdto.getFilename() != null) {
			fdto.setBnum(bdto.getBnum());
			fdao.insert(fdto);
		}
		
	}

	public List<Map<String, Object>> list(PageDTO pdtp) {
		//페이징 처리
		int curpage = pdtp.getCurpage(); //현재페이지
		int perpage = pdtp.getPerpage(); //한페이지당 게시물수
		int perblock = pdtp.getPerblock(); //페이지 블럭의 수
		
		int startno = (curpage-1) * perpage + 1; //시작번호
		int endno = startno + perpage - 1; //끝번호
		
		pdtp.setStartno(startno);
		pdtp.setEndno(endno);
		
		
		//전체 페이지수 구하기
		int totcnt = bdao.selecttotcnt(pdtp);
		int totpage = totcnt/perpage;
		
		//나머지가 있으면 +1
		if(totcnt%perpage !=0){
			totpage += 1 ;
		}
		pdtp.setTotpage(totpage);
		
		//블럭 처리
		int startpage = curpage - ((curpage-1) % perblock); //블럭의 시작 페이지 
		int endpage = startpage + (perblock-1); //블럭의 끝 페이지 
		
		//totpage가 endpage 페이지 보다 작다면 endpage에 totpage 넣기
		if(totpage < endpage) endpage = totpage;
		
		pdtp.setStartpage(startpage);
		pdtp.setEndpage(endpage);
		
		
		//System.out.println("서비스 totcnt : " + totcnt);
		System.out.println("서비스" + pdtp);
		return bdao.list(pdtp);
		
	}

	public Map<String, Object> selectone(int bnum) {
		
		return bdao.selectone(bnum);
	}

	public List<BoardDTO> selectlistreply(int bnum) {
		return bdao.selectlistreply(bnum);
	}

	public int update(BoardDTO bdto) {
		
		return bdao.update(bdto);
	}

	public int delete(int bnum) {
		//댓글이 존재하는지 체크
		List<BoardDTO> blist= bdao.selectlistreply(bnum);
		//System.out.println("리스트 사이즈 : "+blist.size());
		
		if(blist.size() == 0) {
			fdao.delete(bnum);
			bdao.delete(bnum);
			return 1;
		}else {
			return 0;
		}
	}

	public int readcountadd(int bnum) {
		return bdao.readcountadd(bnum);
		
	}

	
	
	
}
