package ex05;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//확장자 패턴 *는 제일앞, 제일 뒤만 가능
//확장자 sche 인 모든 매핑 처리
@WebServlet("*.sche")
/*@WebServlet("/ex05/sche/*")*/
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		//uri.indexOf("insert") : uri 안에 insert가 들어있다면 링크값을 주고
		                          //없을때는 -1일 준다.
		if(uri.indexOf("insert") != -1) { //추가
				
			String sdate = request.getParameter("sdate");
			int stime = Integer.parseInt(request.getParameter("stime"));
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			System.out.println(sdate + stime + subject + content);
			
			//dto에 값 추가
			ScheduleDTO sdto = new ScheduleDTO(sdate, stime, subject, content);
			//생성자 또는 셋을 사용하여 가능
			//sdto.setSdate(sdate);
			System.out.println(sdto);
			
			ScheduleDAO sdao = new ScheduleDAO();
			int cnt = sdao.insert(sdto);
			
			System.out.println("컨트롤러 cnt"+cnt);
			
			String msg = "";
			if(cnt>0) {
				msg = "저장 완료";
			}else {
				msg = "저장 실패";
			}
			
			request.setAttribute("cnt", cnt);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/ex05_schedule/20210531_01_insert.jsp").forward(request, response);
			
		}else if(uri.indexOf("list") != -1) {
			//리스트 조회
			System.out.println("리스트 컨트롤러 진입");
			
			ScheduleDAO sdao = new ScheduleDAO();
			List<ScheduleDTO> slist = sdao.selectlistback();
		
			request.setAttribute("slist", slist);
			request.getRequestDispatcher("/ex05_schedule/20210531_02_list.jsp").forward(request, response);
			
		}else if(uri.indexOf("selectone") != -1) {
			//한건 조회
			String sdate = request.getParameter("sdate");
			int stime = Integer.parseInt(request.getParameter("stime"));
			
			System.out.println(sdate+" "+stime);
			
			ScheduleDAO sdao = new ScheduleDAO();
			ScheduleDTO sdto = sdao.selectone(sdate, stime);
			
			request.setAttribute("sdto", sdto);
			request.getRequestDispatcher("/ex05_schedule/20210531_03_detail.jsp").forward(request, response);
		}else if(uri.indexOf("updateform") != -1) {
			String sdate = request.getParameter("sdate");
			int stime = Integer.parseInt(request.getParameter("stime"));
			System.out.println("업데이트폼: " + sdate+" "+stime);
			
			ScheduleDAO sdao = new ScheduleDAO();
			ScheduleDTO sdto = sdao.selectone(sdate, stime);
			
			request.setAttribute("sdto", sdto);
			request.getRequestDispatcher
				("/ex05_schedule/20210601_01_update.jsp").forward(request, response);
			
		}else if(uri.indexOf("update") != -1) {//수정
			String sdate = request.getParameter("sdate");
			int stime = Integer.parseInt(request.getParameter("stime"));
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			System.out.println("진짜 업데이트: " + sdate+" "+stime);
			System.out.println("진짜 업데이트: " + subject+" "+content);
			
			ScheduleDAO sdao = new ScheduleDAO();
			ScheduleDTO sdto = new ScheduleDTO(sdate, stime, subject, content);
			int cnt = sdao.update(sdto);
			System.out.println("진짜 업데이트: " +cnt);
			
			String msg = "";
			if(cnt>0) {
				msg = "수정 완료";
			}else {
				msg = "수정 실패";
			}
			
			
			sdto = sdao.selectone(sdate, stime); //다시 조회 (그냥 넘기면 안에 수정날짜 등이 없음)
			
			request.setAttribute("msg", msg);
			request.setAttribute("cnt", cnt);
			request.setAttribute("sdto", sdto);
			//request.getRequestDispatcher("/ex05_schedule/20210531_03_detail.jsp").forward(request, response);
			
			//forward 방식 : 서블릿 다시 호출 (대신 경로명이 안바뀜) (대신 대량의 정보 전송 가능)
			//request.getRequestDispatcher("/ex05_schedule/selectone.sche").forward(request, response);
			
			//Redirect : 주소 변경
			response.sendRedirect("/jsp01/selectone.sche?sdate="+sdate+"&stime="+stime);
			
		}else if(uri.indexOf("delete") != -1) { //삭제
			request.getParameter("sdate");
			String sdate = request.getParameter("sdate");
			int stime = Integer.parseInt(request.getParameter("stime"));
			System.out.println("딜리트 컨트롤러 진입값: " + sdate+" "+stime);
			
			ScheduleDAO sdao = new ScheduleDAO();
			int cnt = sdao.delete(sdate, stime);
			
			System.out.println("컨트롤러로 받은 cnt"+cnt);
			
			String msg="";
			if(cnt>0) {
				msg="삭제 완료";
			}else{
				msg="삭제 실패";
			}
			
			//포워드 방식은 url이 변경이 안되며, 새로고침하면 계속 삭제가 일어남
			//request.setAttribute("cnt", cnt);
			//request.getRequestDispatcher("/ex05_schedule/20210531_02_list.jsp").forward(request, response);
			
			// 리다이랙트 방식으로 url을 변경 시키고, 새로고침해도 변화 없도록 함
			//리스트 이동 : 서블릿 이동
			msg = URLEncoder.encode(msg,"utf-8");
			response.sendRedirect("/jsp01/list.sche?msg="+msg);
			
		}else if(uri.indexOf("time") != -1) {
			//타임테이블 조회
			System.out.println("타임 컨트롤러 진입");
			
			//startdate, enddate 널처리
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			System.out.println(startdate+enddate);
			
			if(startdate==null || enddate==null) {
				Date d = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				//String sd = sf.format(d);
				
				startdate= sf.format(d);
				enddate= sf.format(d);
				//if(startdate==null) startdate="";
				//if(enddate==null) enddate="";
			}
			System.out.println(startdate+enddate);
			
			ScheduleDAO sdao = new ScheduleDAO();
			List<TimeDTO> tlist = sdao.selectlist(startdate, enddate);
		
			request.setAttribute("tlist", tlist);
			request.setAttribute("startdate", startdate);
			request.setAttribute("enddate", enddate);
			
			request.getRequestDispatcher("/ex05_schedule/20210601_02_timetable.jsp").forward(request, response);
			
			
		}else if(uri.indexOf("map") != -1) {
			//타임테이블 조회
			System.out.println("타임 컨트롤러 진입");
			
			//startdate, enddate 널처리
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			System.out.println(startdate+enddate);
			
			if(startdate==null || enddate==null) {
				Date d = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				//String sd = sf.format(d);
				
				startdate= sf.format(d);
				enddate= sf.format(d);
				//if(startdate==null) startdate="";
				//if(enddate==null) enddate="";
			}
			System.out.println(startdate+enddate);
			
			ScheduleDAO sdao = new ScheduleDAO();
			List<Map<String, String>> tlist = sdao.selectmap(startdate, enddate);
		
			request.setAttribute("tlist", tlist);
			request.setAttribute("startdate", startdate);
			request.setAttribute("enddate", enddate);
			
			request.getRequestDispatcher("/ex05_schedule/20210602_02_map.jsp").forward(request, response);
			
			
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
