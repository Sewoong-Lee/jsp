package apitest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.food")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		foodservice fservice = new foodservice();
		
		if(uri.indexOf("getfoodApi") != -1) {
			System.out.println("getfoodApi 입장~");
			
			List<Map<String, String>> jlist = fservice.getfoodApi();
			
			request.setAttribute("jlist", jlist);
			request.getRequestDispatcher("foodapi/foodlist.jsp").forward(request, response);
			
		}else if(uri.indexOf("add") != -1) {
			
			int cnt = fservice.insert();
			
			
			
		}else if(uri.indexOf("list") != -1) {
			String findmenu = request.getParameter("findmenu");

			List<Map<String, String>> jlist = fservice.selectlist(findmenu);
			request.setAttribute("jlist", jlist);
			request.getRequestDispatcher("foodapi/foodlist.jsp").forward(request, response);
			
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
