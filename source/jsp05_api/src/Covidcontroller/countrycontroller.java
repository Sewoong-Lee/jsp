package Covidcontroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.countryservice;

@WebServlet("*.country")
public class countrycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		countryservice counservice = new countryservice();
		
		if(uri.indexOf("add") != -1) {
			String countryname = request.getParameter("countryname");
			if(countryname == null) countryname = "";
			
			int cnt = counservice.insert(countryname);
			
		}else if(uri.indexOf("getCountryApi") != -1) {
		String countryname = request.getParameter("countryname");
		
		List<Map<String,String>> clist= counservice.getCountryApi(countryname);
		
		
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("view/02_xml_json.jsp").forward(request, response);
		
		}else if(uri.indexOf("list") != -1){
			String countryname = request.getParameter("countryname");
			if(countryname == null) countryname = "";
			
			List<Map<String, String>> clist = counservice.selectlist(countryname);
			
			request.setAttribute("clist", clist);
			request.getRequestDispatcher("view/02_xml_json.jsp").forward(request, response);
			
			
		}else if(uri.indexOf("detail") != -1){
			String sfty_notice_id = request.getParameter("sfty_notice_id");
			
			Map<String, String> cmap = counservice.selectone(sfty_notice_id);
			
			request.setAttribute("cmap", cmap);
			request.getRequestDispatcher("view/03_xml_json_detail.jsp").forward(request, response);
			
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
