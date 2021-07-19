package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import dto.BoardDTO;
import dto.FileDTO;
import dto.PageDTO;
import service.boardfileservice;
import service.boardservice;
import service.fileservice;


@WebServlet("/board/*")
public class boardcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		
		boardservice bservice = new boardservice();
		if(uri.indexOf("add") != -1) {
			//게시물 등록
			//파일을 폴더에 저장
			fileservice fservice = new fileservice();
			String saveDirectory = getServletContext().getInitParameter("savedir");
			MultipartRequest multi = fservice.fileuplode(request, saveDirectory);
			
			
			//boardservice 에 넘기기
			//멀티파트 형식으로 리퀘스트로 읽을 수 없음
			//멀티를 통하여 데이터 읽기
			String userid = multi.getParameter("userid");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			//실제 올라간 파일이름
			String filename = multi.getFilesystemName("filename");
			
			BoardDTO bdto = new BoardDTO();
			bdto.setUserid(userid);
			bdto.setSubject(subject);
			bdto.setContent(content);
			bdto.setIp(request.getRemoteAddr());
			System.out.println(bdto);
			
			FileDTO fdto = new FileDTO();
			//파일Bnum은 BoardDTO에 셋팅 이후 넘기고 서비스에서 셋팅
			fdto.setFilename(filename);
			System.out.println(fdto);
			
			bservice.insert(bdto,fdto);
			
			//전체 조회
			response.sendRedirect(path+"/view/board/list.jsp");
			
		}else if(uri.indexOf("list") != -1) {
			//전체조회
			
			//현재페이지 값의 널 체크
			int curpage = 1;
			if(request.getParameter("curpage") != null) {
				curpage = Integer.parseInt(request.getParameter("curpage")); //현재 페이지
			}
			
			String msg = request.getParameter("msg");
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			
			if(findkey== null)  findkey= "";
			if(findvalue== null)  findvalue= "";
			
			
			System.out.println(findkey + findvalue);
			
			PageDTO pdtp = new PageDTO();
			pdtp.setFindkey(findkey);
			pdtp.setFindvalue(findvalue);
			pdtp.setCurpage(curpage);
			
			
			System.out.println(pdtp);
			
			List<Map<String, Object>> blist = bservice.list(pdtp);
			System.out.println(blist);
			
			request.setAttribute("pdtp", pdtp); //페이징 처리 정보
			request.setAttribute("msg", msg);
			//request.setAttribute("findkey", findkey);
			//request.setAttribute("findvalue", findvalue);
			request.setAttribute("blist", blist);
			request.getRequestDispatcher("/view/board/list.jsp").forward(request, response);
			
		}else if(uri.indexOf("detail") != -1) {
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			System.out.println(bnum);
			
			//조회수 +1
			bservice.readcountadd(bnum);
			
			//원본 조회
			Map<String, Object> bmap = bservice.selectone(bnum);
			System.out.println(bmap);
			
			//댓글 리스트 조회
			List<BoardDTO> replylist = bservice.selectlistreply(bnum);
			System.out.println("replylist : "+replylist);
			
			request.setAttribute("replylist", replylist);
			request.setAttribute("bmap", bmap);
			request.getRequestDispatcher("/view/board/detail.jsp").forward(request, response);
			
		}else if(uri.indexOf("modifyform") != -1) {
			//수정폼으로
			//원본 조회
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			Map<String, Object> bmap = bservice.selectone(bnum);
			System.out.println(bmap);
			
			request.setAttribute("bmap", bmap);
			request.getRequestDispatcher("/view/board/modify.jsp").forward(request, response);
			
		}else if(uri.indexOf("update") != -1) {
			//파일을 폴더에 저장
			fileservice fservice = new fileservice();
			String saveDirectory = getServletContext().getInitParameter("savedir");
			MultipartRequest multi = fservice.fileuplode(request, saveDirectory);
			
			//dto저장
			int bnum = Integer.parseInt(multi.getParameter("bnum"));
			String userid = multi.getParameter("userid");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			
			BoardDTO bdto = new BoardDTO();
			bdto.setBnum(bnum);
			bdto.setUserid(userid);
			bdto.setSubject(subject);
			bdto.setContent(content);
			bdto.setIp(request.getRemoteAddr());
			
			bservice.update(bdto);
			System.out.println(bdto);
			
			
			
			//실제 올라간 파일이름
			String filename = multi.getFilesystemName("filename");
			
			//파일을 선택 했다면
			if(filename != null) {  
				//기존에 파일이 있다면 삭제
				boardfileservice bfservice= new boardfileservice();
				bfservice.delete(bnum);
				
				//추가
				FileDTO fdto = new FileDTO();
				fdto.setBnum(bnum);
				fdto.setFilename(filename);
				
				bfservice.insert(fdto);
				
			}else{
				boardfileservice bfservice= new boardfileservice();
				bfservice.delete(bnum);
			}
			//상세조회로 이동
			response.sendRedirect(path+"/board/detail?bnum="+bnum);
			
			
		}else if(uri.indexOf("delete") != -1) {
			//삭제
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			int cnt = bservice.delete(bnum);
			
			if(cnt == 0) {
				System.out.println("삭제 불가");
				String msg = "삭제 불가";
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/board/detail?bnum="+bnum+"&msg="+msg);
			}else {
				System.out.println("삭제 완");
				response.sendRedirect(path+"/board/list");
			}
			
			//response.sendRedirect(path+"/board/list");
			
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	
	
	
	
	
	
	
	
}
