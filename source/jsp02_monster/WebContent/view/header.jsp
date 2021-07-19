<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h2>포켓몬 관리 프로그램</h2>
		<nav>
			<a href="${path}/view/main.jsp">홈</a>
			<a href="${path}/view/ptype/add.jsp">타입 등록 수정</a>
			<a href="${path}/view/ptype/selectlist.jsp">타입 리스트</a>
			<a href="${path}/addform.monster">포켓몬등록</a>
			<a href="${path}/selectlist.monster">포켓몬조회</a>
		</nav>
	</header>
	<hr>
</body>
</html>