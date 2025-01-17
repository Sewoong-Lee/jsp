package apitest;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class ex02_json {

	 public static void main(String[] args) throws Exception {
		 List<Map<String, String>> jlist = new ArrayList<>();
		 
		 String ServiceKey = "QCSbt4qH3V%2BAwpf8eh1Lxo4sUsJ%2FCf070Hfdtct0QBisRxP%2BPGqoeYxLs9QKlA3PkxbFjtszhc55QYf0%2BToQsA%3D%3D";
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6480000/gyeongnamgoodrestaurant/gyeongnamgoodrestaurantlist"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+ServiceKey); /*Service Key*/
	        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	        
	        //---------------------------------------------------------
	        String data = sb.toString();
	        //System.out.println("1 데이터:"+data);
	        
	        //json파싱
	        //org.제이슨.심플로 시작하는 애들로 임포트
	        //{로 시작하면 제이슨 오브젝트 [시작하면 제이슨 어레이
	        JSONParser parser = new JSONParser();
	        //{로 시작하니 오브젝트로
	        JSONObject object =  (JSONObject) parser.parse(data);
	        System.out.println("2 오브젝트:"+object);
	        //[로 시작하니 어레이로
	        JSONObject object2 =  (JSONObject) object.get("gyeongnamgoodrestaurantlist");
	        System.out.println("3 오브젝트:"+object2);
	        
	        JSONArray  arry= (JSONArray)object2.get("item");
	        System.out.println("4 어레이:"+arry);
	        
	       
	        //다시 {로 시작하니 오브젝트로
	        //반복 부분
	        for(int i =0 ; i<arry.size() ; i++) {
	        	System.out.println("순번"+i+"-------------------------------------------------------------");
	        	Map<String, String> jmap = new HashMap<>();
	        	object = (JSONObject) arry.get(i);
	        	//System.out.println("5 어레이에서 오브젝트:"+object);
	        	
	        	Set<String> kset = object.keySet(); //object의 키 
	            System.out.println("keySet:"+object.keySet());
	            
	            //모든 키와 값을 맵에 넣음
	            for(String key : kset) {
	            	jmap.put(key, (String) object.get(key));
	            	System.out.println("jmap:"+jmap);
	            }
	        	
	            jlist.add(jmap);

//	        	String ctprvnNm = (String) object.get("ctprvnNm");
//	        	System.out.println("1 ctprvnNm:"+ctprvnNm);
//	        	//jmap.put("ctprvnNm", ctprvnNm);
//	        	
//	        	String signguNm = (String) object.get("signguNm");
//	        	System.out.println("2 signguNm:"+signguNm);
//	        
//	        	String uptaenm = (String) object.get("uptaenm");
//	        	System.out.println("3 uptaenm:"+uptaenm);
//	        
//	        	String mainMenu = (String) object.get("mainMenu");
//	        	System.out.println("4 mainMenu:"+mainMenu);
//
//	        	String entrprsNm = (String) object.get("entrprsNm");
//	        	System.out.println("5 entrprsNm:"+entrprsNm);
//	        	
//	        	String rdnmadr = (String) object.get("rdnmadr");
//	        	System.out.println("6 rdnmadr:"+rdnmadr);
//	        	
//	        	String telNo = (String) object.get("telNo");
//	        	System.out.println("7 telNo:"+telNo);
//	        	
//	        	String latitude = (String) object.get("latitude");
//	        	System.out.println("8 latitude:"+latitude);
//	        	
//	        	String logitude = (String) object.get("logitude");
//	        	System.out.println("9 logitude:"+logitude);
	        }
	        //System.out.println(jlist);
	        
	        
	    }

}
