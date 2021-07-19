<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>포켓몬 등록</h2>
	<form action="${path}/add.monster">
			타입 코드 
			<select name="tcode">
				<c:forEach var="plist" items="${plist}">
				<option value="${plist.tcode}">${plist.tcode} ${plist.tname}</option>
				</c:forEach>
			</select> <br>
			포켓몬 코드 <input type="text" name="mcode"> <br>
			포켓몬 이름 <input type="text" name="mname"> <br>
			<button>등록</button>
	</form>

</body>
</html>