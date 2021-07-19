package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;


public class fileservice {
	//공통모듈
	//파일 다운로드
	public MultipartRequest fileuplode(HttpServletRequest request, String saveDirectory) {
		
		MultipartRequest multi = null;
		int size = 1024 * 1024 * 10; //10메가 바이트
		try {	
			//파일 업로드
			multi = new MultipartRequest(request, saveDirectory,size,"utf-8", new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return multi;
	}
	
	
	
	
	
	
	
	
	
	
	
}
