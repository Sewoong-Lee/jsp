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
	<h2>과목등록</h2>
	<!-- 파일을 가져가려면 포스트방식, enctype="multipart/form-data" 로 바꿈 -->
	<form name="addform" action="${path}/add.subject" method="post" enctype="multipart/form-data">
		과목코드 <input type="text" name="subcode"> <br>
		과목이름 <input type="text" name="subname"> <br>
		가격 <input type="number" name="price"> <br>
		사진 <input type="file" name="filename"> <br>
		키워드코드 <br>
		<c:forEach var="kdto" items="${klist}">
		<input type="radio" name="kwcode" value="${kdto.kwcode}"> ${kdto.kwcode} ${kdto.kwname}
		</c:forEach>
		 <br>
		<button>확인</button>
	</form>
</body>
</html>