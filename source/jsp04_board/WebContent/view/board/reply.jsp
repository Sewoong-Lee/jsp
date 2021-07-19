<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includ/includ.jsp" %>
<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 등록</title>
</head>
<body>
	<h2>댓글 등록</h2>
	<form action="${path}/reply/add" method="post">
		<input type="hidden" name="ref" value="${param.ref}">
		<input type="hidden" name="restep" value="${param.restep}"> 
		<input type="hidden" name="relevel" value="${param.relevel}"> 
		<hr>
	
		작성자 id <input type="text" name="userid"> <br>
		제목 <input type="text" name="subject"> <br>
		내용 <textarea rows="3" cols="25" name="content"></textarea> <br>
	
		<button>확인</button>
	</form>
	
</body>
</html>