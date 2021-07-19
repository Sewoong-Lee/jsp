package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.KeywordService;
import service.SubjectService;


@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		KeywordService kservice = new KeywordService();
		SubjectService sservice = new SubjectService();
		
		
		if(uri.indexOf("filedownload") != -1) {
			//파일 다운로드
			//String saveDirectory = "D:/jsp/upload/";
			//프로젝트의 web.xml에서 파일 저장경로 읽어오기
			String saveDirectory = getServletContext().getInitParameter("savedir");
			String filename = request.getParameter("filename");
			
			String fileurl = saveDirectory+"/"+filename;
			System.out.println(fileurl);
			
			//마인타입 : 파일의 종류
			String mimetype = getServletContext().getMimeType(filename);
			System.out.println(mimetype);
			
			if(mimetype == null){
				mimetype="application/octet-stream;charset=utf-8";
			}
			response.setContentType(mimetype);
			
			//다운로드 첨부파일 형식으로
			//파일 이름 utf-8로 인코딩
			filename = URLEncoder.encode(filename, "utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+filename);
			
			
			//서버 파일 읽어서 전송
			//입력 스트림
			FileInputStream fis = new FileInputStream(fileurl);
			
			//출력스트림
			ServletOutputStream out = response.getOutputStream();
			
			byte[] b = new byte[4096];
			//읽어서 b에 저장
			//numread : 읽어들인 바이트
			int numread = 0;
			
			while((numread = fis.read(b,0,b.length)) != -1){  //-1: 읽어온 바이트가 없다
				out.write(b,0,numread);
			};
			out.flush(); //내보내기

			out.close();
			fis.close();
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
