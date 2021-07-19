package service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.SubjectDAO;
import model.SubjectDTO;

public class SubjectService {
	
	SubjectDAO sdao = new SubjectDAO();
	
	public int insert(HttpServletRequest request,SubjectDTO sdto, String saveDirectory) {
		fileuplode(request, sdto, saveDirectory);
		return sdao.insert(sdto);
	}
	
	public int update(HttpServletRequest request,SubjectDTO sdto, String saveDirectory) {
		fileuplode(request, sdto, saveDirectory);

		return sdao.update(sdto);
		
	}
	
	//파일 업로드하고 dto반환
	public void fileuplode(HttpServletRequest request, SubjectDTO sdto, String saveDirectory) {
		
		//saveDirectory : 서버의 파일을 저장할 디렉토리
		//String saveDirectory = "D:/jsp/upload";
		//파일 저장 최대 사이즈
		int size = 1024 * 1024 * 10; //10메가 바이트
		//DefaultFileRenamePolicy() : 동일파일명 존재시 파일 이름 변경하여 저장
		MultipartRequest multi;
		try {
			
			multi = new MultipartRequest(request, saveDirectory,size,"utf-8", new DefaultFileRenamePolicy());
			//데이터 읽기
			String subcode = multi.getParameter("subcode");
			String subname = multi.getParameter("subname");
			int price = Integer.parseInt(multi.getParameter("price"));
			String kwcode = multi.getParameter("kwcode");
			//실제 올라간 파일이름
			String filename = multi.getFilesystemName("filename");
			
			//oldfilename : 수정시에만
			String oldfilename = multi.getParameter("oldfilename");
			System.out.println(oldfilename);
			if(filename == null) {  //파일리 선택이 안되어있다면
				if(oldfilename != null) { //기존 파일명이 있다면
					sdto.setFilename(oldfilename);
				}else { //예전파일도 없다면
					sdto.setFilename("");
				}
			}else { //파일이 선택이 됬다면 
				sdto.setFilename(filename);
			}
			
			sdto.setSubcode(subcode);
			sdto.setSubname(subname);
			sdto.setPrice(price);
			
			sdto.setKwcode(kwcode);
			System.out.println(sdto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<Map<String, Object>> selectlist(Map<String, String> findmap) {
		SubjectDAO sdao = new SubjectDAO();
		
		return sdao.selectlist(findmap);
	}
	
	public Map<String, Object> selectone(String subcode) {
		SubjectDAO sdao = new SubjectDAO();
		
		return sdao.selectone(subcode);
	}
	
	
	
}
