package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import dao.MemberDAO;
import dto.MemberDTO;




public class MemberService {
	MemberDAO mdao = new MemberDAO();
	//솔트 생성
	public String saltmake() {
			String salt = null;
			try {
				SecureRandom srandom = SecureRandom.getInstance("SHA1PRNG");
				byte[] bytes = new byte[16];
				srandom.nextBytes(bytes);
				
				//Base64 : byte데이터를 String형식으로 표시 (바이너리코드를 아스키 코드로 변경)
				salt = new String(Base64.getEncoder().encode(bytes));
				
				//System.out.println("salt : "+salt);
				//System.out.println("salt 길이: "+salt.length());
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return salt;
		}
		
		
		//평문을 암호문으로 변경
	public String sha256(String passwd, String salt) {
			
			StringBuilder sb = null;
			try {
				//SHA-256 암호화 : 단방향 암호 기법 : 256bit 
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(passwd.getBytes()); //문자열을 바이트배열로 변경해서 전달
				//솔트 생성 전달
				//salt = saltmake();  //같은 클래스 안에 있으므로 그냥 생성 가능
				md.update(salt.getBytes());
				
				
				byte[] data = md.digest();
				//System.out.println("암호화된 바이트 배열:"+ Arrays.toString(date)); //주소
				//System.out.println("바이트 배열 길이 : "+date.length);
				
				//16진수 문자열로 변경
				sb = new StringBuilder();
				
				for(byte b :data) {
					sb.append(String.format("%02x", b)); //02하면 무조건 두자리씩
					 //b:2 o:8 x:16
				}
				//System.out.println("암호화된 문자열: "+sb.toString());
				//System.out.println("암호 문자열 길이: "+sb.length());
			
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return sb.toString(); //암호문만 반환
		}
	
	public int insert(MemberDTO mdto) {
		//암호화 처리
		//솔트 생성, 암호화 전달
		
		String salt = saltmake();
		System.out.println("insertservice salt:" + salt);
		//평문을 암호문으로 
		String encryptpw =  sha256(mdto.getPasswd(), salt);
		System.out.println("insertservice encryptpw:" + encryptpw);
		mdto.setPasswd(encryptpw);
		mdto.setSalt(salt);
		System.out.println("insertservice:" + mdto);
		
		return mdao.insert(mdto);
		
	}
	
	public int loginCheck(String userid, String passwd) {
		// 0: 성공
		// 1: 아이디불일치
		// 2: 패스워드 불일치
		//아이디를 가진 회원 조회
		System.out.println("받아온:" + passwd);
		MemberDTO mdto = mdao.selectone(userid);
		System.out.println("service:" + mdto);
		if(mdto == null) {
			return 1;
		}else{
			String dbpasswd = mdto.getPasswd();
			String salt = mdto.getSalt();
			System.out.println("loginCheck:dbpasswd:" + dbpasswd);
			System.out.println("loginCheck:salt:" + salt);
			//평문을 암호화한 패스워드
			String encryptpw =  sha256(passwd, salt);
			System.out.println("loginCheck:encryptpw:" + encryptpw);
			
			if (dbpasswd.equals(encryptpw)) {
				System.out.println("패스워드일치");
				return 0;
			}else {
				System.out.println("패스워드불일치");
				return 2;
			}
			
		}
		
	}
	
	

}
