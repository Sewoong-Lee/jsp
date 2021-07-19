package ex09_guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/guest/*")
public class guestcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //포스트 방식일때 한글처리
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if (uri.indexOf("list") != -1) {
			//방명록 리스트
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			
			System.out.println(findkey + findvalue);
			
			GuestBookDAO gdao = new GuestBookDAO();
			List<GuestBookDTO> glist = gdao.selectlist(findkey, findvalue);
			
			// 걍 패스값 구해봄 String path = request.getContextPath();
			
			request.setAttribute("glist", glist);
			request.getRequestDispatcher("/ex09_guestbook/20210608_list.jsp").forward(request, response);
			
		}else if(uri.indexOf("modify") != -1) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			System.out.println(seq);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
