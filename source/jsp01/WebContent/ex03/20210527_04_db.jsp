<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		String passwd = request.getParameter("passwd");
		int birthyear = Integer.parseInt(request.getParameter("birthyear"));
		System.out.print(userid+passwd+birthyear);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("업뎃 오라클 접속 완료");
		
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("업뎃 컨넥션 완료");
		
		String msg = "";
		String sql = "UPDATE MEMBER SET PASSWD = ? , BIRTHYEAR = ?  WHERE USERID = ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, passwd);
		pstmt.setInt(2, birthyear);
		pstmt.setString(3, userid);
		
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt);
		
		if(cnt > 0){
			msg = "수정 완료";
		}else{
			msg = "수정 실패";
		}
		System.out.println(msg);
		msg = URLEncoder.encode(msg,"utf-8");
		response.sendRedirect("/jsp01/ex03/20210527_04_update.jsp?msg="+msg+"&cnt="+cnt);
	%>
</body>
</html>