<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과창</h2>
	<%
		String ban = request.getParameter("ban");
		int r = Integer.parseInt(ban);
	%>
	원의 넓이는 <%=(double)r*r*3.14 %>
	
	
	
</body>
</html>