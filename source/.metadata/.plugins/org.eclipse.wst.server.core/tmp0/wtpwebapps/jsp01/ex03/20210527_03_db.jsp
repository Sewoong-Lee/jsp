<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
		String userid = request.getParameter("userid");
		System.out.println(userid);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("오라클 접속 완료");
		
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("컨넥션 완료");
		PreparedStatement pstmt = null;
		String msg = ""; 
		
		try{
			String sql ="DELETE FROM MEMBER WHERE USERID = ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt);
			
			if(cnt > 0 ){
				msg = "삭제 완료";
			}if(cnt == 0){
				msg = "다시 확인해 주세요.";
			}
	
		}catch(Exception e){
			System.out.println("예외 발생");
			//e.getStackTrace(); //예외 추적출력문
		}
		//연결 해제
			if(conn!=null){
				conn.close();
			}if(pstmt!=null){
				pstmt.close();
			}
	
		msg = URLEncoder.encode(msg,"utf-8");
		response.sendRedirect("/jsp01/ex03/20210527_03_delete.jsp?msg="+msg);
		
	%>
	
</body>
</html>