<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>기본 if문</h4>
	<h4>성인인지 아닌지 출력</h4>
	<c:set var="age" value="10"/>
	
	<c:if test="${age>=20}" >
		성인입니다. <br>
	</c:if>
	<c:if test="${age<20}" >
		미성년입니다. <br>
	</c:if>
	
	
	<h4>choose문(레알 if문)</h4>
	스위치문같다 (choose문 안에 choose문 적용 가능)<br>
	<c:choose>
		<c:when test="${age>=20}">
			성인
		</c:when>
		<c:when test="${age>=13}">
			청소년
		</c:when>
		<c:otherwise>
			어린이
		</c:otherwise>
	</c:choose>	

	<h4>choose문2(레알 if문)</h4>
	<c:choose>
		<c:when test="${age>=20}">
			성인이다
		</c:when>
		<c:when test="${age<20}">
			미성년이다
		</c:when>
	</c:choose>	
	
</body>
</html>