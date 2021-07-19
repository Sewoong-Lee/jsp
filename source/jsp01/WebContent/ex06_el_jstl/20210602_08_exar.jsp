<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>두수를 jstl변수에 넣고 더하기</h4>
	<c:set var="one" value="10"/>
	<c:set var="two" value="3"/>
	
	${one} + ${two} = ${one + two} <br>
	${one} / ${two} = ${one / two} <br>
	
	fmt 사용1 : <fmt:formatNumber value="${one / two}" pattern="#.##"/> <br>
	fmt 사용2 : <fmt:formatNumber value="${one / two}" pattern="000.##"/> <br>
	
	
</body>
</html>