package ex12_api;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex01_xml {

	 public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		 //api 호출
		 //https://data.go.kr/iim/api/selectAPIAcountView.do
		 //공공데이터활용지원센터_보건복지부 코로나19 감염 현황
		 String ServiceKey = "QCSbt4qH3V%2BAwpf8eh1Lxo4sUsJ%2FCf070Hfdtct0QBisRxP%2BPGqoeYxLs9QKlA3PkxbFjtszhc55QYf0%2BToQsA%3D%3D";
		 //String ServiceKey = "uMngqDWghlCUM7FKSQhTMPHD6Pw05QrJz2IoKje4tLozlhVZNfN1V6d78mbWCXI8Pixkrmhtd8vWQiMEwntxEA%3D%3D";
       StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
       urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+ServiceKey); /*Service Key*/
       urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*검색할 생성일 범위의 시작*/
	        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20200315", "UTF-8")); /*검색할 생성일 범위의 종료*/
	        
	        System.out.println(urlBuilder.toString());
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
//	        BufferedReader rd;
//	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        } else {
//	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = rd.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        rd.close();
//	        conn.disconnect();
//	        System.out.println(sb.toString());
	        
		 //파일에서 데이터 소스 얻기
		 //InputSource is = new InputSource(new FileReader("D:/api/api_xml.xml"));
	        
	     //파일에서 데이터 소스 얻기
	     //InputSource is = new InputSource(new StringReader(sb.toString()));
	     
	      //xml파싱
	     //InputSource을 이용한 dom생성
		 //Document doc= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
	     //문자열 url을 이용한 dom생성
	     Document doc= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
		 NodeList nodelist= doc.getElementsByTagName("item");
		 System.out.println("데이터 개수"+nodelist.getLength());
		 
		 for(int i = 0; i < nodelist.getLength(); i++) {
			 NodeList cnodelist= nodelist.item(i).getChildNodes();  //자식 노드들
			 System.out.println(i + ":" + cnodelist.getLength());
			 for(int j = 0; j < cnodelist.getLength(); j++) {
				 Node node= cnodelist.item(j);
				 System.out.println(node.getNodeName() + ":" + node.getTextContent());
			 }
			 System.out.println("----------------------------------");
		 }
		 
		 
	     
	        
	        
	        
	        
	        
	 }
}
