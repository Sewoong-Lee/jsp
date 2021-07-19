package ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex04/04")
public class J20210528_04_cal extends HttpServlet {
	//정수리터럴을 long타입으로 지정 : L
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(serialVersionUID);
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String giho = request.getParameter("giho");
		System.out.println(request.getParameter("giho"));
		
		int sum = 0;
		if(giho.equals("+")) {
			sum = num1+num2;
		}
		//int sum = num1+num2;
		
		response.sendRedirect("/jsp01/ex04/20210528_04_cal.jsp?sum="+sum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
