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
</head>
<body>
	<h2>상세조회</h2>
	과목코드 ${smap.SUBCODE} <br>
	과목이름 ${smap.SUBNAME} <br>
	가격 ${smap.PRICE} <br>
	사진 <img alt="" src="/img/${smap.FILENAME}" width="50"> 
		<button onclick="location.href='${path}/filedownload.file?filename=${smap.FILENAME}'" >다운로드</button> <br>
	키워드코드 ${smap.KWCODE} <br>
	키워드 네임 ${smap.KWNAME} <br>
	<button onclick="location.href='${path}/updateform.subject?subcode=${smap.SUBCODE}'">수정</button>
</body>
</html>