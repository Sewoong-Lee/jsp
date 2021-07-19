<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>포켓몬 전체 조회</h2>
	<fieldset>
		<form action="${path}/selectlist.monster">
		<input type="radio"  name="findkey" value="tcode" ${findkey=='tcode' ? 'checked' : ''}>타입코드 
		<input type="radio" name="findkey" value="mcode"  ${findkey=='mcode' ? 'checked' : ''}>포켓몬코드
		<input type="radio" name="findkey" value="mname" ${findkey=='mname' ? 'checked' : ''}>포켓몬이름 <br>
		<input type="text" name="findvalue" value="${findvalue}">
		<button>확인</button>
		</form>
	</fieldset>

	<c:forEach var="mlist" items="${mlist}">
		타입코드 : ${mlist.tcode} <br>
		타입이름 : ${mlist.tname} <br>
		포켓몬코드 : ${mlist.mcode} <br>
		포켓몬네임 : <a href="${path}/updateform.monster?mcode=${mlist.mcode}">${mlist.mname}</a> <br>
		<button onclick="location.href='${path}/delet.monster?mcode=${mlist.mcode}'">삭제</button>
		<hr>
	</c:forEach>
</body>
</html>