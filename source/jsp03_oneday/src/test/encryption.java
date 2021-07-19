package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class encryption {
	//솔트 생성
	static String saltmake() {
		String salt = null;
		try {
			SecureRandom srandom = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			srandom.nextBytes(bytes);
			
			//Base64 : byte데이터를 String형식으로 표시 (바이너리코드를 아스키 코드로 변경)
			salt = new String(Base64.getEncoder().encode(bytes));
			
			System.out.println("salt : "+salt);
			System.out.println("salt 길이: "+salt.length());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salt;
	}
	
	
	//평문을 암호문으로 변경
	static Map<String,String> sha256(String passwd) {
		Map<String,String> rs = new HashMap<>();
		
		StringBuilder sb = null;
		String salt = null;
		try {
			//SHA-256 암호화 : 단방향 암호 기법 : 256bit 
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(passwd.getBytes()); //문자열을 바이트배열로 변경해서 전달
			//솔트 생성 전달
			salt = encryption.saltmake();
			md.update(salt.getBytes());
			//md.update("cJW7dRRpTtU/a5oDkexPEw==".getBytes());
			
			
			byte[] date = md.digest();
			System.out.println("암호화된 바이트 배열:"+ Arrays.toString(date)); //주소
			System.out.println("바이트 배열 길이 : "+date.length);
			
			//16진수 문자열로 변경
			sb = new StringBuilder();
			
			for(byte b :date) {
				sb.append(String.format("%02x", b)); //02하면 무조건 두자리씩
			}
			System.out.println("암호화된 문자열: "+sb.toString());
			System.out.println("암호 문자열 길이: "+sb.length());
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.put("encryptpw", sb.toString());
		rs.put("salt", salt);
		
		return rs;
	}
	
	
	public static void main(String[] args) {
		// sha-256 암호화
		
		Map<String,String> rs = encryption.sha256("1111");
		System.out.println("암호문 : "+rs.get("encryptpw"));
		System.out.println("솔트 : "+rs.get("salt"));
		
		//incryption.saltmake();
		
	}

}
