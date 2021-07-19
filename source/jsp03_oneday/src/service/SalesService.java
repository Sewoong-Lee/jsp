package service;

import java.util.List;
import java.util.Map;

import model.SalesDAO;
import model.SalesDTO;

public class SalesService {
	
	SalesDAO sdao = new SalesDAO();
	
	public int insert(SalesDTO sdto) {
		
		return sdao.insert(sdto);
	}
	
	public List<Map<String, Object>> select_detail(Map<String, String> datemap) {
		System.out.println(datemap);
		return sdao.select_detail(datemap);
	}

	public List<Map<String, Object>> select_total(Map<String, String> datemap) {
		
		return sdao.select_total(datemap);
	}
	
	
}
