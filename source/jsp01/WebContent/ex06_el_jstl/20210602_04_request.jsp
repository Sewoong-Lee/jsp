<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request scope</h2>
	<%
		request.setAttribute("name", "하하하");
		request.setAttribute("age", 123);
	%>
	<h4>자바 방식</h4>
	<%= request.getAttribute("name") %> <br>
	<%= request.getAttribute("age") %> <br>
		
	<h4>el 방식</h4>
	${requestScope.name} <br>
	${requestScope.age} <br>
	<!-- requestScope는 생략 가능 -->
	<!-- Attribute형만 생략 가능 -->
	${name} <br>
	${age} <br>
	
	
</body>
</html>