<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includ/includ.jsp" %>
<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>댓글 수정</h2>
	<form action="${path}/reply/update" >
	<input type="hidden" name="ref" value="${param.ref}">
		번호 <input type="text" name="bnum" readonly="readonly"  value="${replydto.bnum}"><br>
		작성자 id <input type="text" name="userid" readonly="readonly" value="${replydto.userid}"> <br>
		제목 <input type="text" name="subject" value="${replydto.subject}"> <br>
		내용 <textarea rows="10" cols="25" name="content" >${replydto.content}</textarea> <br>
	
		<button>확인</button>
	</form>
</body>
</html>