package service;

import dao.FileDAO;
import dto.FileDTO;

public class boardfileservice {
	
	FileDAO bfdao = new FileDAO();
	public int delete(int bnum) {
		
		return bfdao.delete(bnum);
	}
	public int insert(FileDTO fdto) {
		
		return bfdao.insert(fdto);
		
	}
	
}
