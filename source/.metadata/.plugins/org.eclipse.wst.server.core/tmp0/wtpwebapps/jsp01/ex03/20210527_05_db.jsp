<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="ex03.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//조회할 아이디 가져오기
		String findvalue = request.getParameter("findvalue");
		String findkey = request.getParameter("findkey");
		System.out.println("파인드키 : "+findkey);
		System.out.println("파인드벨류 : "+findvalue);
		//전체 조회
		List<MemberDTO> mlist = new ArrayList<>();
		//오라클 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("셀렉트올 오라클 접속 완료");
		//Connection 은 자바의 spl꺼로
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("셀렉트올 컨넥션 완료");
		
		//findkey의 벨류값이 db의 필드명과 같아서 findkey그대로 넣음
		//만약 db의 필드명과 다르면 if문 사용
		//String sql = "SELECT*FROM MEMBER WHERE "+findkey+" LIKE '%'|| ? ||'%' ORDER BY USERID";
		String sql = "";
		PreparedStatement pstmt = null;
		if(findkey.equals("userid")){
			sql = "SELECT*FROM MEMBER WHERE USERID LIKE '%'|| ? ||'%' ORDER BY USERID";
			//문자열 사이에(?) 문자열 들어가면 따옴표도 같이 들어감
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, findvalue);
		}else if(findkey.equals("birthyear")){
			//int findvalue2 = Integer.parseInt(request.getParameter("findvalue"));
			sql = "SELECT*FROM MEMBER WHERE BIRTHYEAR BETWEEN 0 AND ? ORDER BY USERID";
			pstmt = conn.prepareStatement(sql);
			if(findvalue.equals("")){ //년도가 없을때 현재년도로 default설정
				//현재시간 가져오기
				Date date = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy");
				findvalue = sf.format(date);	
			}
			
			pstmt.setInt(1, Integer.parseInt(findvalue));
		}
		

		//MemberDTO mdto =null;
		ResultSet rs =  pstmt.executeQuery();
		while(rs.next()){
			String userid = rs.getString("userid");
			String passwd = rs.getString("passwd");
			int birthyear = rs.getInt("birthyear");
			String regdate = rs.getString("regdate");
			//mdto = new MemberDTO(userid, passwd, birthyear, regdate);
			mlist.add(new MemberDTO(userid, passwd, birthyear, regdate));
		}
		//request에 값 넣기
		request.setAttribute("mlist", mlist);
		request.setAttribute("findkey", findkey);
		request.setAttribute("findvalue", findvalue);
		
/* 		for(int i=0;i<mlist.size();i++){
			MemberDTO mdto = mlist.get(i);
			System.out.println(mdto);
		} */
		request.getRequestDispatcher("20210527_05_selecrall.jsp").forward(request, response);
		
	
	%>
</body>
</html>