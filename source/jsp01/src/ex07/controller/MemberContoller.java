package ex07.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ex07.model.MemberDAO;
import ex07.model.MemberDTO;


@WebServlet("*.member")
public class MemberContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println("맴버 컨트롤러 uri : "+uri);
		
		//페스 구하기
		String path = request.getContextPath();
		
		MemberDAO mdao = new MemberDAO();
		if(uri.indexOf("join") != -1) {
			//회원가입
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String nicname = request.getParameter("nicname");
			String phone = request.getParameter("phone");
			String addr = request.getParameter("addr");
			
			System.out.println(email +" "+ passwd+" "+ nicname+" "+phone+" "+addr);
			
			MemberDTO mdto = new MemberDTO();
			mdto.setEmail(email);
			mdto.setPasswd(passwd);
			mdto.setNicname(nicname);
			mdto.setPhone(phone);
			mdto.setAddr(addr);
			//System.out.println("멤버 컨트롤러 mdto : "+mdto);
			
			int cnt = mdao.insert(mdto);
			
			System.out.println("리턴받은 cnt : "+ cnt);
			
			String msg = "";
			//주소변경 가능한 redirect로 이동
			//url 줄이기
			String urlpath = "";
			if(cnt > 0) {
				msg = "가입 완료";
				urlpath = "/ex07_member/login.jsp";
			}else if(cnt == -1){
				//얼롯창 줄 바꿈
				msg = "중복된 이메일 \\n 다른 이메일로 가입하세요";
				urlpath = "/ex07_member/join.jsp";
			}else {
				msg = "가입 실패";
				urlpath = "/ex07_member/join.jsp";
			}
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+urlpath+"?msg="+msg);
			
		}else if(uri.indexOf("detail") != -1) {
			//String email = request.getParameter("email");
			//System.out.println("디테일 컨트롤러 이메일 : "+ email);
			
			//한건 조회
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			System.out.println("디테일 컨트롤러 세션 : "+email);
			
			MemberDTO mdto = mdao.selectone(email);
			
			//mdto를 가져가야하므로 포워드로
			request.setAttribute("mdto", mdto);
			request.getRequestDispatcher("/ex07_member/detail.jsp").forward(request, response);
			
		}else if(uri.indexOf("delet") != -1) {
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			
			int cnt = mdao.delet(email);
			
			System.out.println("삭제 cnt : "+cnt);
			
			String msg = "";
			String urlpath = "";
			if(cnt > 0) {
				msg = "삭제 완료";
				urlpath = "/ex07_member/login.jsp";
			}else {
				msg = "삭제 실패";
				urlpath = "/ex07_member/login.jsp";
			}
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+urlpath+"?msg="+msg+"&cnt="+cnt);
			
			session.invalidate();
			
		}else if(uri.indexOf("updateform") != -1) {
			//회원 정보를 가지고 수정폼으로
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			
			MemberDTO mdto = mdao.selectone(email);
			
			request.setAttribute("mdto", mdto);
			request.getRequestDispatcher("/ex07_member/update.jsp").forward(request, response);
			
			
		}else if(uri.indexOf("update") != -1) {
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String nicname = request.getParameter("nicname");
			String phone = request.getParameter("phone");
			String addr = request.getParameter("addr");
			
			System.out.println(email +" "+ passwd+" "+ nicname+" "+phone+" "+addr);
			
			MemberDTO mdto = new MemberDTO();
			mdto.setEmail(email);
			mdto.setPasswd(passwd);
			mdto.setNicname(nicname);
			mdto.setPhone(phone);
			mdto.setAddr(addr);
			//System.out.println("멤버 컨트롤러 mdto : "+mdto);
			
			int cnt = mdao.update(mdto);
			
			System.out.println("리턴받은 업데이트 cnt : "+ cnt);
			
			String msg = "";
			String urlpath = "";
			if(cnt > 0) {
				msg = "수정 완료";
				urlpath = "/ex07_member/detail.jsp";
			}else {
				msg = "수정 실패";
				urlpath = "/ex07_member/update.jsp";
			}
			msg = URLEncoder.encode(msg, "utf-8");
			//response.sendRedirect(path+urlpath+"?msg="+msg+"&cnt="+cnt);
			//디테일로 다시 갈거니까 디테일 수정 확인할 수 있게 메소드 실행
			response.sendRedirect(path +"/detail.member");
			
		}else if(uri.indexOf("emailcheck") != -1) {
			//이메일 체크
			String email = request.getParameter("email");
			
			//0 : 미존재
			//1 : 미존재
			
			MemberDTO mdto = mdao.selectone(email);
			//mdto가 null이면 사용가능 이메일
			
			String msg = "";
			
			if(mdto == null) {
				msg="사용 가능 이메일";
			}else {
				msg="중복 \\n이메일";
			}
			
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+"/ex07_member/join.jsp?msg="+msg+"&email="+email);
			
		}else if(uri.indexOf("list") != -1) {
			String listfield = request.getParameter("listfield");
			String listvalue = request.getParameter("listvalue");
			System.out.println("listfield : "+listfield);
			System.out.println("listvalue : "+listvalue);
			
			if(listfield==null)listfield = "";
			if(listvalue==null)listvalue = "";
			
			List<MemberDTO> list = mdao.selectall(listfield, listvalue);
			System.out.println("컨트롤러로 넘어온 리스트 : "+list);
			
			request.setAttribute("listfield", listfield);
			request.setAttribute("listvalue", listvalue);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/ex07_member/list.jsp").forward(request, response);
			
		}else if(uri.indexOf("onedet") != -1) {
			
			//전체 조회에서 한건 상세 조회
			String email = request.getParameter("email");
			
			MemberDTO mdto = mdao.selectone(email);
			
			//mdto를 가져가야하므로 포워드로
			request.setAttribute("mdto", mdto);
			request.getRequestDispatcher("/ex07_member/detail.jsp").forward(request, response);
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
