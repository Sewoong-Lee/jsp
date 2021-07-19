package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MonsterDAO;
import model.MonsterDTO;
import model.PtypeDAO;
import model.PtypeDTO;

@WebServlet("*.monster")
public class MonsterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		
		PtypeDAO pdao = new PtypeDAO();
		MonsterDAO mdao = new MonsterDAO();
		if(uri.indexOf("addform") != -1) {
			//등록폼으로 이동
			//타입리스트를 조회해서 등록폼으로
			List<PtypeDTO> plist = pdao.selectlist("tcode", "");
			
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("/view/monster/add.jsp").forward(request, response);
		}else if(uri.indexOf("add") != -1) {
			String mcode = request.getParameter("mcode");
			String tcode = request.getParameter("tcode");
			String mname = request.getParameter("mname");
			System.out.println(mcode+tcode+mname);
			
			if(mdao.selectone(mcode) == null) {
				int cnt = mdao.insert(new MonsterDTO(mcode,tcode,mname));
				
				System.out.println("포켓몬 추가 : "+cnt);
				
				response.sendRedirect(path+"/selectlist.monster");
			}else {
				int cnt = mdao.update(new MonsterDTO(mcode,tcode,mname));
				
				System.out.println("포켓몬 수정 : "+cnt);
				
				response.sendRedirect(path+"/selectlist.monster");
			}
			
		}else if(uri.indexOf("selectlist") != -1) {
			//System.out.println(mlist);
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			System.out.println(findkey+ " " +findvalue);
			
			if(findkey==null || findvalue ==null) {
				findkey = "mcode";
				findvalue = "";
			}
			
			List<MonsterDTO> mlist= mdao.selectlist(findkey, findvalue);
			
			request.setAttribute("findkey", findkey);
			request.setAttribute("findvalue", findvalue);
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/monster/selectlist.jsp").forward(request, response);
			
		}else if(uri.indexOf("delet") != -1) {
			String mcode = request.getParameter("mcode");
			int cnt = mdao.delete(mcode);
			System.out.println("포켓몬 삭제 : " + cnt);
			
			response.sendRedirect(path+"/selectlist.monster");
			
		}else if(uri.indexOf("updateform") != -1) {
			//수정폼으로
			String mcode = request.getParameter("mcode");
			MonsterDTO mdto = mdao.selectone(mcode);
			request.setAttribute("mdto", mdto);
			
			List<PtypeDTO> plist = pdao.selectlist("tcode", "");
			request.setAttribute("plist", plist);
			
			request.getRequestDispatcher("/view/monster/modify.jsp").forward(request, response);
		
		}else if(uri.indexOf("update") != -1) {
			String mcode = request.getParameter("mcode");
			String tcode = request.getParameter("tcode");
			String mname = request.getParameter("mname");
			
			int cnt = mdao.update(new MonsterDTO(mcode, tcode, mname));
			System.err.println("수정 : "+cnt);
			
			response.sendRedirect(path+"/selectlist.monster");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
