<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- request 파라메터  -->
	<h2>request 파라메터(자바 표현식)</h2>
	이름 <%=request.getParameter("name") %> <br>
	나이 <%=request.getParameter("age") %><br>
	
	<h2>el 표현식(널처리)</h2>
	이름 ${param.name } <br>
	나이 ${param.age } <br>
	
</body>
</html>