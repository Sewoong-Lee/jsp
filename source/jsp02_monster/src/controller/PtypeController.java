package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MonsterDAO;
import model.PtypeDAO;
import model.PtypeDTO;


@WebServlet("*.ptype")
public class PtypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		
		PtypeDAO pdao = new PtypeDAO();
		//추가
		if(uri.indexOf("insert") != -1) {
			String tcode = request.getParameter("tcode");
			String tname = request.getParameter("tname");
			System.out.println(tcode+tname);
			
			String msg = "";
			//기존 등록된 자료 조회가 있으면 수정
			//없으면 추가
			if(pdao.selectone(tcode) == null) {
				System.out.println("데이터 없음");
				int cnt = pdao.insert(new PtypeDTO(tcode,tname));
				if(cnt > 0) {
					msg = "타입 등록 완료";
				}else {
					msg = "타입 등록 실패";
				}
				 
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/list.ptype?msg="+msg);
			}else {
				int cnt = pdao.update(new PtypeDTO(tcode,tname));
				
				if(cnt > 0) {
					msg = "타입 수정 완료";
				}else {
					msg = "타입 수정 실패";
				}
				 
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(path+"/list.ptype?msg="+msg);
				
			}

		//전체조회
		}else if(uri.indexOf("list") != -1) {
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			System.out.println(findkey + findvalue);
			if(findkey==null || findvalue ==null) {
				findkey = "tcode";
				findvalue = "";
			}
			
			List<PtypeDTO> plist = pdao.selectlist(findkey, findvalue);
			//System.out.println(plist);
			 
			request.setAttribute("findkey", findkey);
			request.setAttribute("findvalue", findvalue);
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("view/ptype/selectlist.jsp").forward(request, response);
			
		}else if(uri.indexOf("delet") != -1) {
			//삭제
			String tcode = request.getParameter("tcode");
			System.out.println(tcode);
			
			String msg = "";
			//포켓몬테이블에서 코드 사용시 삭제 불가 안내 처리
			MonsterDAO mdao = new MonsterDAO();
			int mcnt = mdao.selecttypecount(tcode);
			
			if(mcnt==0) {
				int cnt = pdao.delete(tcode);
				msg = "삭제 완료";
			}else {
				msg = "현재 사용중인 코드";
			}
			
			//주소 변경
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect(path+"/list.ptype?msg="+msg);
			
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
