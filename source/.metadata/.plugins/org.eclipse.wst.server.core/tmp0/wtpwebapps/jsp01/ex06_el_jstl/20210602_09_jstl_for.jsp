<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>jstl for문</h4>
	<c:forEach var="i" begin="100" end="500" step="50" varStatus="status">
		${status.count} : ${i} <br>
	</c:forEach>
	
	<h4>구구단 찍기</h4>
	<c:set var="dan" value="9"/>
	
	<c:forEach var="i" begin="1" end="9" step="1">
		** ${i} 단 <br>
		<c:forEach var="j" begin="1" end="9" step="1">
			${i} * ${j} = ${j*i} <br>
		</c:forEach>
		<hr>
	</c:forEach>
	
</body>
</html>