package ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex04/03")
public class J20210528_03_sales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//상품 판매 금액 구하여 보내기
		String url = request.getRequestURI();
		System.out.println(url);
		
		String itemname = request.getParameter("itemname");
		int price = Integer.parseInt(request.getParameter("price"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int sales = price*seq;
		
		request.setAttribute("itemname", itemname);
		request.setAttribute("sales", sales);
		
		request.getRequestDispatcher("/ex04/20210528_03_sales.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
