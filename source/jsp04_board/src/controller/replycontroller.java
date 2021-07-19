package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.boardservice;
import service.replyservice;

//댓글처리
@WebServlet("/reply/*")
public class replycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		replyservice rservice = new replyservice();
		if(uri.indexOf("add") != -1) {
			//댓글 추가
			String userid = request.getParameter("userid");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			int ref = Integer.parseInt(request.getParameter("ref"));
			int restep = Integer.parseInt(request.getParameter("restep"));
			int relevel = Integer.parseInt(request.getParameter("relevel"));
			
			//System.out.println(userid +" " + subject);
			//System.out.println(content +" " + ref);
			//System.out.println(restep +" " + relevel);
			
			BoardDTO bdto = new BoardDTO();
			bdto.setUserid(userid);
			bdto.setSubject(subject);
			bdto.setContent(content);
			bdto.setRef(ref);
			bdto.setRestep(restep);
			bdto.setRelevel(relevel);
			bdto.setIp(request.getRemoteAddr());
			
			System.out.println(bdto);
			
			replyservice.insert(bdto);
			
			//게시물 상세조회로 이동
			response.sendRedirect(path+"/board/detail?bnum="+ref);
			
			
		}else if(uri.indexOf("delete") != -1) {
			//댓글 삭제
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			int ref = Integer.parseInt(request.getParameter("ref"));
			replyservice.delete(bnum);
			String msg = "댓글 삭제 완료";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+"/board/detail?bnum="+ref+"&msg="+msg);
			
		}else if(uri.indexOf("modifyform") != -1) {
			//수정폼으로
			//원본 조회
			boardservice bservice = new boardservice();
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			BoardDTO replydto = rservice.selectone(bnum);
			
			request.setAttribute("replydto", replydto);
			request.getRequestDispatcher("/view/board/replymodify.jsp").forward(request, response);
		
		}else if(uri.indexOf("update") != -1) {
			int bnum = Integer.parseInt(request.getParameter("bnum"));
			int ref = Integer.parseInt(request.getParameter("ref"));
			
			String userid = request.getParameter("userid");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			BoardDTO bdto = new BoardDTO();
			bdto.setBnum(bnum);
			bdto.setUserid(userid);
			bdto.setSubject(subject);
			bdto.setContent(content);
			bdto.setIp(request.getRemoteAddr());
			
			System.out.println(bdto);
			
			replyservice.uptate(bdto);
			
			response.sendRedirect(path+"/board/detail?bnum="+ref);
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
