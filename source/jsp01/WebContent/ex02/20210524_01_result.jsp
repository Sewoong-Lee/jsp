<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 결과창</h3>
	<%
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
	%>
	
	<%=userid %>님 반갑습니다. <br>
	비밀번호는 <%=passwd %> 입니다.
	
	
	
</body>
</html>