<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>대충 찍어</h4>
	<form action="">
		<input type="checkbox" value="자바" name="check">자바
		<input type="checkbox" value="파이썬" name="check">파이썬
		<input type="checkbox" value="오라클" name="check">오라클
		<button>확인</button>
	</form>

	<div>
	포문 <br>
	<c:forEach var="i" begin="0" end="3" step="1">
		${paramValues.check[i]} <br>
	</c:forEach>
	<hr>
	포이치문 <br>
	<c:forEach var="i" items="${paramValues.check}" varStatus="sta">
		${sta.count} ${i} <br>
	</c:forEach>
	</div>
	
	
</body>
</html>