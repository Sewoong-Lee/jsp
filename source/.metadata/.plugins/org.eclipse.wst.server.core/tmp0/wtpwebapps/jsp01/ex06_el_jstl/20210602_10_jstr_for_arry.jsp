<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>배열변수 출력</h4>
	<c:set var="arr">one,two,three,four,five</c:set>
	
	${arr } <hr>
	
	<c:forEach var="i" items="${arr}" varStatus="sta">
		${sta.index} ${sta.count} ${i} <br>
	</c:forEach>
	
	
	
</body>
</html>