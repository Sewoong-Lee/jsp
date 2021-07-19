package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalesDTO;
import service.KeywordService;
import service.SalesService;
import service.SubjectService;

//수강신청
@WebServlet("*.sales")
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		KeywordService kservice = new KeywordService();
		SalesService salesservice = new SalesService();
		if(uri.indexOf("addform") != -1) {
			//수강신청
			
			//클래스 리스트를 조회
			SubjectService subjectservice = new SubjectService();
			
			Map<String, String> findmap = new HashMap<>();
			
			List<Map<String, Object>> salesmap = subjectservice.selectlist(findmap);
			//System.out.println(salesmap);
			//add.jsp로 
			request.setAttribute("salesmap", salesmap);
			request.getRequestDispatcher("/view/sales/add.jsp").forward(request, response);
			
		}else if(uri.indexOf("add") != -1) {
			//수강신청
			String subcode = request.getParameter("subcode");
			String saledate = request.getParameter("saledate");
			String userid = request.getParameter("userid");
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			System.out.println(subcode);
			
			SalesDTO sdto = new SalesDTO();
			sdto.setUserid(userid);
			sdto.setSaledate(saledate);
			sdto.setSubcode(subcode);
			sdto.setCnt(cnt);
			sdto.setAmount(amount);
			
			int scnt = salesservice.insert(sdto);
			System.out.println("수강신청 cnt : "+scnt);
			response.sendRedirect(path+"/view/sales/add.jsp?cnt="+scnt);
			
			
		}else if(uri.indexOf("listtotal") != -1) {
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			
			 if (startdate == null) startdate = "";
			 if (enddate == null) enddate = "";
			
			 Map<String, String> datemap = new HashMap<>();
			datemap.put("startdate", startdate);
			datemap.put("enddate", enddate);
			System.out.println(datemap);
				
			List<Map<String, Object>> slist = salesservice.select_total(datemap);
			System.out.println(slist);
			
			request.setAttribute("startdate", startdate);
			request.setAttribute("enddate", enddate);
			request.setAttribute("slist", slist);
			request.getRequestDispatcher("/view/sales/total.jsp").forward(request, response);
			
		}else if(uri.indexOf("list") != -1) {
			//신청 조회
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			
			 if (startdate == null) startdate = "";
			 if (enddate == null) enddate = "";

			Map<String, String> datemap = new HashMap<>();
			datemap.put("startdate", startdate);
			datemap.put("enddate", enddate);
			System.out.println(datemap);
			
			List<Map<String, Object>> slist = salesservice.select_detail(datemap);
			System.out.println(slist);
			
			request.setAttribute("startdate", startdate);
			request.setAttribute("enddate", enddate);
			request.setAttribute("slist", slist);
			request.getRequestDispatcher("/view/sales/list.jsp").forward(request, response);
		
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
