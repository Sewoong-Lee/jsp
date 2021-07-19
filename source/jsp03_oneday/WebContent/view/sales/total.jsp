<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%@include file="../sessioncheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>신청 집계</h2>
	<form action="${path}/listtotal.sales">
	<fieldset>
		<legend>기간 조회</legend>
		시작일<input type="date" name="startdate" value="${startdate}">
		종료일<input type="date" name="enddate" value="${enddate}">
		<button>확인</button>
	</fieldset>
	</form>
	<table>
		<tr align="center">
			<th>클래스 코트</th>
			<th>클래스 명</th>
			<th>가격</th>
			<th>인원</th>
			<th>합금액</th>
		</tr>
		<c:forEach var="slist" items="${slist}">
		<tr align="center">
			<td>${slist.SUBCODE}</td>
			<td><a href="${path}/detail.sales?subcode=${slist.SUBCODE}">${slist.SUBNAME}</a></td>
			<td>${slist.PRICE}</td>
			<td>${slist.CNT}</td>
			<td>${slist.AMOUNT}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>