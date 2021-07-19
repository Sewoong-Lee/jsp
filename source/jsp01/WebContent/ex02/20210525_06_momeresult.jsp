<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 조회</title>
</head>
<body>
	<h2>메모 조회</h2>
	<%
		request.setCharacterEncoding("utf-8");
		String mail = request.getParameter("mail");
		String memo = request.getParameter("memo");
	%>
	이메일 : <%= mail %> <br>
	한마디 : <%= memo %> <br>
	
	
	
</body>
</html>