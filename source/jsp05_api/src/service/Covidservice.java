package service;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import dao.Coviddao;
import dto.CovidDTO;
import oracle.sql.ARRAY;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Covidservice {
	Coviddao cdao = new Coviddao();
	public List<Map<String,String>> selectlist2(String startdate, String enddate)  {
		//반환값
		List<Map<String,String>> covidlist = new ArrayList<>();
		//Map<String,String> covidmap = new HashMap<>();
		
		try {
			//코로나 현황 조회
			String ServiceKey = "QCSbt4qH3V%2BAwpf8eh1Lxo4sUsJ%2FCf070Hfdtct0QBisRxP%2BPGqoeYxLs9QKlA3PkxbFjtszhc55QYf0%2BToQsA%3D%3D";
			 //String ServiceKey = "uMngqDWghlCUM7FKSQhTMPHD6Pw05QrJz2IoKje4tLozlhVZNfN1V6d78mbWCXI8Pixkrmhtd8vWQiMEwntxEA%3D%3D";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startdate, "UTF-8")); /*검색할 생성일 범위의 시작*/
	        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(enddate, "UTF-8")); /*검색할 생성일 범위의 종료*/
	        String url = urlBuilder.toString();
	        System.out.println(urlBuilder.toString());
	        
	      //날짜 문자열에서 - 지우기
			startdate= startdate.replace("-", ""); 
			enddate= enddate.replace("-", ""); 
			System.out.println(startdate+enddate);
			
			startdate = dateAdd(enddate, +1);
			System.out.println(startdate);
	        
	        
		    //xml파싱
	        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url);
			NodeList nodelist= doc.getElementsByTagName("item");
			//System.out.println("데이터 개수"+nodelist.getLength());
			
			int olddecideCnt = 0, newdecideCnt=0;
			for(int i = 0; i < nodelist.getLength(); i++) {
				NodeList cnodelist= nodelist.item(i).getChildNodes();  //자식 노드들
				//System.out.println(i + ":" + cnodelist.getLength());
				
				//맵 생성 : 하루 데이터
				Map<String,String> covidmap = new HashMap<>();
				for(int j = 0; j < cnodelist.getLength(); j++) {
					Node node= cnodelist.item(j);
					//System.out.println(node.getNodeName() + ":" + node.getTextContent());
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						covidmap.put(node.getNodeName(), node.getTextContent());
						if(node.getNodeName().equals("decideCnt")) {
							if(i==0) {
								newdecideCnt = Integer.parseInt(node.getTextContent());
							}
						}
					}
					int calcnt = newdecideCnt - olddecideCnt;
					covidmap.put("diffcnt", String.valueOf(calcnt));
					newdecideCnt = olddecideCnt;
				}
				covidlist.add(covidmap);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("예외");
		}
		
		System.out.println(covidlist);
	    return covidlist;
	}
	public List<Map<String,String>> getCovidApi(String startdate, String enddate)  {
		//반환값
		List<Map<String,String>> covidlist = new ArrayList<>();
		//Map<String,String> covidmap = new HashMap<>();
		
		//날짜 문자열에서 - 지우기
		startdate= startdate.replace("-", ""); 
		enddate= enddate.replace("-", ""); 
		System.out.println(startdate+enddate);
		
		//startdate = dateAdd(startdate, -1);
		//System.out.println(startdate);
		
		try {
			//코로나 현황 조회
			String ServiceKey = "QCSbt4qH3V%2BAwpf8eh1Lxo4sUsJ%2FCf070Hfdtct0QBisRxP%2BPGqoeYxLs9QKlA3PkxbFjtszhc55QYf0%2BToQsA%3D%3D";
			 //String ServiceKey = "uMngqDWghlCUM7FKSQhTMPHD6Pw05QrJz2IoKje4tLozlhVZNfN1V6d78mbWCXI8Pixkrmhtd8vWQiMEwntxEA%3D%3D";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
	        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startdate, "UTF-8")); /*검색할 생성일 범위의 시작*/
	        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(enddate, "UTF-8")); /*검색할 생성일 범위의 종료*/
	        String url = urlBuilder.toString();
	        System.out.println(urlBuilder.toString());
	        
	        
		    //xml파싱
	        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url);
			NodeList nodelist= doc.getElementsByTagName("item");
			//System.out.println("데이터 개수"+nodelist.getLength());
			
			int olddecideCnt = 0, newdecideCnt=0;
			for(int i = 0; i < nodelist.getLength(); i++) {
				NodeList cnodelist= nodelist.item(i).getChildNodes();  //자식 노드들
				//System.out.println(i + ":" + cnodelist.getLength());
				
				//맵 생성 : 하루 데이터
				Map<String,String> covidmap = new HashMap<>();
				for(int j = 0; j < cnodelist.getLength(); j++) {
					Node node= cnodelist.item(j);
					//System.out.println(node.getNodeName() + ":" + node.getTextContent());
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						covidmap.put(node.getNodeName(), node.getTextContent());

					}
				}
				covidlist.add(covidmap);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("예외");
		}
		
		System.out.println(covidlist);
	    return covidlist;
	}
	
	//날짜 더하기 메소드
		public static String dateAdd(String date, int addDay) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        String caldate = null;//계산된 날짜
			try {
				Date d = sdf.parse(date);  //문자열을 날짜형으로 변경
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(d);
		        cal.add(Calendar.DATE, addDay);

		        caldate = sdf.format(cal.getTime()); //날짜형을 문자열로 변경

			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
			return caldate;
			
		}
		public int insert(String startdate, String enddate) {
			List<Map<String,String>> covidlist = getCovidApi(startdate, enddate);
			System.out.println(covidlist);
			int totalcnt = cdao.insert(covidlist);
		   return totalcnt;
		}
		public List<CovidDTO> dblist(String startdate, String enddate) {
			startdate= startdate.replace("-", ""); 
			enddate= enddate.replace("-", ""); 
			System.out.println(startdate+enddate);
			
			Map<String,String> covidmap = new HashMap<>();
			covidmap.put("startdate", startdate);
			covidmap.put("enddate", enddate);
			

			return cdao.selectlist(covidmap);
		}
		
		
		
}
