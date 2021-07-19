package ex07.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ex07.model.MemberDAO;

//확장자 패턴
@WebServlet("*.log")
public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//contextpath조회
		String path = request.getContextPath();
		
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		
		//로그인
		if(uri.indexOf("login") != -1) {
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			System.out.println("로그인 접속 정보 : "+email+" "+passwd);
			
			MemberDAO mdao = new MemberDAO();
			int result = mdao.loginCheck(email, passwd);
			String msg = "";
			//0:성공, -1:실패
			if(result == 0) {
				//세션 저장
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				//세션의 유지시간 (기본은 30분 정도)
				session.setMaxInactiveInterval(60*60*2); //2시간
				
				
				//main으로 이동
				msg = "로그인 완료";
				
				//forward는 url이 안바껴서 기각
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/ex07_member/main.jsp").forward(request, response);
				
				
				
				//msg = URLEncoder.encode(msg, "utf-8");
				//컨텍스트 패스를 넣기
				//response.sendRedirect(path+"/ex07_member/main.jsp?msg="+msg);
				
			}else {
				//다시 로그인 창으로
				msg = "로그인과 패스워드 확인해주세요";
				
				//String path = request.getContextPath();
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/ex07_member/login.jsp?msg="+msg);
			}
			
			
		}if(uri.indexOf("logout") != -1) {
			//로그아웃
			//세션 전체 삭제
			HttpSession session = request.getSession();
			session.invalidate();
			
			String msg = "로그아웃 완료";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+"/ex07_member/list.jsp?msg="+msg);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
