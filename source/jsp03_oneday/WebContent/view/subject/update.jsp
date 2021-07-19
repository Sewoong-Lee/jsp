<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../sessioncheck.jsp" %>
<!-- contextpath 변수 생성 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>과목 수정</h2>
	<img alt="" src="/img/${smap.FILENAME}" width="50">
	
	<form action="${path}/update.subject"  method="post" enctype="multipart/form-data">
		과목코드 <input type="text" name="subcode" value="${smap.SUBCODE}" readonly="readonly"> <br>
		과목이름 <input type="text" name="subname" value="${smap.SUBNAME}" > <br>
		가격 <input type="number" name="price" value="${smap.PRICE}" > <br>
		
		사진 <input type="file" name="filename" >
		
		<input type="text" name="oldfilename" value="${smap.FILENAME}" readonly="readonly">
		
		<img alt="" src="/img/${smap.FILENAME}" width="50"><br>
		키워드코드 <br>
		<c:forEach var="kdto" items="${klist}">
			<c:if test="${smap.KWCODE eq kdto.kwcode}">
			<input type="radio" name="kwcode" value="${kdto.kwcode}" checked="checked"> ${kdto.kwcode} ${kdto.kwname}
			</c:if>
			<c:if test="${smap.KWCODE != kdto.kwcode}">
			<input type="radio" name="kwcode" value="${kdto.kwcode}" > ${kdto.kwcode} ${kdto.kwname}
			</c:if>
		</c:forEach>
		 <br>
		<button>수정</button>
	</form>
	
</body>
</html>