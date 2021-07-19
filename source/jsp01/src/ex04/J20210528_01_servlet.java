package ex04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 방법 : @WebServlet 매핑경로
//컨텍스트페스는 빼야한다
//프로젝트 내에서 매핑정보는 유일해야한다.
//슬래시 (/) 로 구분을 주는걸 디렉토리 패던이라고 한다.
@WebServlet ("/ex04/01")
public class J20210528_01_servlet extends HttpServlet{
	//상속 하고 우클하고 소스- 오버라이드 - 두갯, 두포스트 체크- 확인
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("get 매핑성공");
		String userid = req.getParameter("userid");
		System.out.println(userid);
		
		//forward방식으로 돌아가기
		req.setAttribute("msg", userid + "님 반갑습니다.");
		req.getRequestDispatcher("/ex04/20210528_01_servlet.jsp")
					.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet 호출로 포스트 방식으로 들어와도 Get방식으로 처리
		doGet(req, resp);
	}
	
}
