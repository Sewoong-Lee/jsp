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
	<h2>게시물 수정</h2>
	<form action="${path}/board/update" method="post" enctype="multipart/form-data">
	
		번호 <input type="text" name="bnum" readonly="readonly"  value="${bmap.BNUM}"><br>
		작성자 id <input type="text" name="userid" readonly="readonly" value="${bmap.USERID}"> <br>
		제목 <input type="text" name="subject" value="${bmap.SUBJECT}"> <br>
		내용 <textarea rows="10" cols="25" name="content" >${bmap.CONTENT}</textarea> <br>
		파일 <input type="text" value="${bmap.FILENAME}" name="oldfilename"> <br>
		<input type="file" name="filename"><br>
	
		<button>확인</button>
	</form>
</body>
</html>