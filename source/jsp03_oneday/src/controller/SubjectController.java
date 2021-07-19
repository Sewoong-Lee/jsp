package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.KeywordDAO;
import model.KeywordDTO;
import model.SubjectDTO;
import service.KeywordService;
import service.MemberService;
import service.SubjectService;


@WebServlet("*.subject")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		KeywordService kservice = new KeywordService();
		SubjectService sservice = new SubjectService();
		
		if(uri.indexOf("addform") != -1) {
			
			//키워드 리스트 조회
			List<KeywordDTO> klist = kservice.selectlist();
			
			System.out.println(klist);
			
			request.setAttribute("klist", klist);
			//등록폼으로 이동
			request.getRequestDispatcher("/view/subject/add.jsp").forward(request, response);
		}else if(uri.indexOf("add") != -1) {
			
			SubjectDTO sdto = new SubjectDTO();
			//파일 저장 경로값
			String saveDirectory = getServletContext().getInitParameter("savedir");
			int cnt = sservice.insert(request, sdto, saveDirectory);
			System.out.println("서브젝트 인서트 : "+cnt);
			
			//클래스 리스트로 이동
			response.sendRedirect(path+"/selectlist.subject");
		}else if(uri.indexOf("selectlist") != -1) {
			//리스트
			//조회조건
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			String orderby = request.getParameter("orderby");
			System.out.println(findkey+" "+ findvalue + " " + orderby);
			//조회조건을 맵으로
			Map<String, String> findmap = new HashMap<>();
			findmap.put("findkey", findkey);
			findmap.put("findvalue", findvalue);
			findmap.put("orderby", orderby);
			
			List<Map<String, Object>> slist = sservice.selectlist(findmap);
			request.setAttribute("slist", slist);
			request.getRequestDispatcher("/view/subject/list.jsp").forward(request, response);
			
		}else if(uri.indexOf("detail") != -1) {
			String subcode = request.getParameter("subcode");
			System.out.println(subcode);
			
			Map<String, Object> smap = sservice.selectone(subcode);
			
			request.setAttribute("smap", smap);
			request.getRequestDispatcher("/view/subject/detail.jsp").forward(request, response);
			
		}else if(uri.indexOf("updateform") != -1) {
			String subcode = request.getParameter("subcode");
			
			Map<String, Object> smap = sservice.selectone(subcode);
			request.setAttribute("smap", smap);
			
			//키워드 리스트 조회
			List<KeywordDTO> klist = kservice.selectlist();
			
			System.out.println(klist);
			
			request.setAttribute("klist", klist);
			//등록폼으로 이동
			request.getRequestDispatcher("/view/subject/update.jsp").forward(request, response);
		
		}else if(uri.indexOf("update") != -1) {
			//수정
			//subcode값을 얻기 위해서
			SubjectDTO sdto = new SubjectDTO(); //dto객체 생성(값은 서비스에서 세팅)
			//파일 저장 경로값
			String saveDirectory = getServletContext().getInitParameter("savedir");
			int cnt = sservice.update(request, sdto, saveDirectory);
			System.out.println("서브젝트 업데이트 : "+cnt);
			//상세보기로 이동
			response.sendRedirect(path+"/detail.subject?subcode="+sdto.getSubcode());
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
