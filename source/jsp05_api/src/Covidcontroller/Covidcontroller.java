package Covidcontroller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dto.CovidDTO;
import service.Covidservice;


@WebServlet("*.do")
public class Covidcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		Covidservice csservice = new Covidservice(); 
		
		if(uri.indexOf("add") != -1) {
			//확인
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			
			
			int cnt = csservice.insert(startdate, enddate);
			String msg = cnt + "건 적용";
			
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+"/view/01_xml_covid.jsp?msg="+msg);
			
		}else if(uri.indexOf("selectlist") != -1) {
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			
			List<CovidDTO> clist = csservice.dblist(startdate, enddate);
			System.out.println(clist);
			
			request.setAttribute("startdate", startdate);
			request.setAttribute("enddate", enddate);
			request.setAttribute("clist", clist);
			request.getRequestDispatcher("view/01_xml_covid.jsp").forward(request, response);
			
			
		}else if(uri.indexOf("list") != -1) {
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		System.out.println(startdate+enddate);
		
		
		//조회 
		List<Map<String,String>> covidlist= csservice.getCovidApi(startdate, enddate);
		
		request.setAttribute("covidlist", covidlist);
		request.getRequestDispatcher("view/01_xml_covid.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
