package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.MemberService;


@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO mdao = new MemberDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//서비스 객체 생성
		MemberService mservice = new MemberService();
		
		if(uri.indexOf("join") != -1) {
			// 회원가입
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			
			MemberDTO mdto = new MemberDTO(userid, passwd, name);
			System.out.println("맴버 컨트롤러 : "+mdto);
			
			//서비스 객체 생성
			int cnt = mservice.insert(mdto);
			System.out.println("회원가입 cnt : " + cnt);
			
			//로그인 이동
			response.sendRedirect(path+"/view/board/list.jsp");
			
		}else if(uri.indexOf("login") != -1) {
			//로그인
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			System.out.println("로그인: " + userid + passwd);
			
			int rs = mservice.loginCheck(userid, passwd);
			
			String msg = "";
			if(rs ==0) {
				//세션에 아이디 저장
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				//세션의 유지시간 (기본은 30분 정도)
				session.setMaxInactiveInterval(60*60*2); //2시간
				msg = "로그인 성공";
				
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/view/home.jsp?msg="+msg);
			}else if(rs == 1){
				msg = "아이디 없음";
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/view/member/login.jsp?msg="+msg);
			}else{
				msg = "비밀번호 불일치";
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/view/member/login.jsp?msg="+msg);
			}
			
			//msg = URLEncoder.encode(msg, "utf-8");
			//response.sendRedirect(path+"/view/home.jsp?msg="+msg+"?rs="+rs);
		}else if(uri.indexOf("logout") != -1) {
			//로그아웃
			//세션 전체 삭제
			HttpSession session = request.getSession();
			session.invalidate();
			
			String msg = "로그아웃 완료";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+"/view/member/login.jsp?msg="+msg);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
