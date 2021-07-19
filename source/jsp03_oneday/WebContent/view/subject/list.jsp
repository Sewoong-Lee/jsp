<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../sessioncheck.jsp" %>
<!-- contextpath 변수 생성 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function imgshow(filename) {
		var ret = window.open('${path}/view/subject/imgshow.jsp?filename='+filename , '이미지보이기');
	}

</script>
</head>
<body>
	<h2>원데이 클래스 리스트</h2>
	<form action="${path}/selectlist.subject">
		<fieldset>
			<legend>검색조건</legend>
			<select name="findkey">
				<option value="subcode">클래스코드</option>
				<option value="subname">클래스명</option>
				<option value="kwname">키워드</option>
			</select>
			<input type="text" name="findvalue">
		</fieldset>
		<fieldset>
			<legend>정렬조건</legend>
			<input type="radio" name="orderby" value="lowprice" checked="checked">낮은 가격순	
			<input type="radio" name="orderby" value="highprice">높은 가격순
		</fieldset>
		
		<button>조회</button>
	</form>
	<table>
		<tr>
			<th>클래스 코드</th>
			<th>클래스 명</th>
			<th>가격</th>
			<th>사진</th>
			<th>키워드 코드</th>
			<th>키워드 명</th>
		</tr>
		<c:forEach var="slist" items="${slist}">
		<tr>
			<td>${slist.SUBCODE}</td>
			<td> <a href="${path}/detail.subject?subcode=${slist.SUBCODE}">${slist.SUBNAME}</a> </td>
			<td>${slist.PRICE}</td>
			<td><img alt="" src="/img/${slist.FILENAME}" width="50" onclick="imgshow('${slist.FILENAME}')"></td>
			<td>${slist.KWCODE}</td>
			<td>${slist.KWNAME}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>