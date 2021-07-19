<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	?표로 가져온건 Parameter 읽을 수 있어!!
	당신의 이름은 <%=request.getParameter("name") %>
	당신의 성별은 <%=request.getParameter("gender") %>
</body>
</html>