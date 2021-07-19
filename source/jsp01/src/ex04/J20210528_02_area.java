package ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex04/02")
public class J20210528_02_area extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//확인용 uri 출력
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		int ban = Integer.parseInt(request.getParameter("ban"));
		double area = ban*ban*3.14;
		
		request.setAttribute("area", area);
		//절대 경로
		//request.getRequestDispatcher("/ex04/20210528_02_area.jsp")
		//.forward(request, response);
		
		//상대경로
		//서블렛 경로명을 /02로 바뀌게 되면 jsp01/02/20210528_02_area.jsp 되므로 못찾음
		//ex04를 따로 붙여줘야한다.
		request.getRequestDispatcher("20210528_02_area.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
