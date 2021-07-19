<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includ/includ.jsp" %>
<%@include file="../header.jsp" %>
<%@include file="../sessioncheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
	<h2>게시물 등록</h2>
	<form action="${path}/board/add" method="post" enctype="multipart/form-data">
		작성자 id <input type="text" name="userid" value="${sessionScope.userid}" readonly="readonly"> <br>
		제목 <input type="text" name="subject"> <br>
		내용 <textarea rows="10" cols="25" name="content"></textarea> <br>
		파일 <input type="file" name="filename"> <br>
	
		<button>확인</button>
	</form>
	
	
	
</body>
</html>