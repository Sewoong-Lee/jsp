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
	<h4>사각형의 넓이 구하기</h4>
	<!-- 변의 길이가 모두 양수인지 체크 -->
	<form action="">
		길이1 <input type="number" name="ar1">cm <br>
		길이3 <input type="number" name="ar2">cm <br>
		<button>확인</button>
	</form>
	길이 1번 : ${param.ar1}cm <br>
	길이 2번 : ${param.ar2}cm <br>
	
	<hr>
	
	<c:set var="area1" value="${param.ar1}"/>
	<c:set var="area2" value="${param.ar2}"/>
	

	<c:if test="${not empty param.ar1}">
	<c:if test="${not empty param.ar2}">
		<c:choose>
			<c:when test="area1<0 && area2<0">
				0이상을 입력하세요
			</c:when>
			<c:otherwise>
				${area1}cm * ${area2}cm = ${area1 * area2} cm
			</c:otherwise>
		</c:choose>
	</c:if>	
	</c:if>
	
	
</body>
</html>