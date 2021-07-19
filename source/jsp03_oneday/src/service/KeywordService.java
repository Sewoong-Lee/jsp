package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.KeywordDAO;
import model.KeywordDTO;
import model.MBConn;

public class KeywordService {
	
	KeywordDAO kdao = new KeywordDAO();
	public List<KeywordDTO> selectlist() {
		return kdao.selectlist();
	}
	
	
	
	
	
	
	
	
}
