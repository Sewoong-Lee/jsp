<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- contextpath 변수 생성 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>경상남도_모범음식점</h2>
	
	<form action="${path}/list.food">
		<fieldset>
			메뉴<input type="text" name="findmenu" > 
			<button>검색</button>
			<button onclick="location.href='${path}/add.food'">db에저장</button>
		</fieldset>
	</form>
	<table border="1">
			<tr>
				<th>시.도</th>
				<th>시.군.구</th>
				<th>업태</th>
				<th>주메뉴</th>
				<th>업소명</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
		<c:forEach var="jlist" items="${jlist}">
			<tr>
				<td>${jlist.CTPRVNNM}</td>
				<td>${jlist.SIGNGUNM}</td>
				<td>${jlist.UPTAENM}</td>
				<td>${jlist.MAINMENU}</td>
				<td>${jlist.ENTRPRSNM}</td>
				<td>${jlist.RDNMADR}</td>
				<td>${jlist.TELNO}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>