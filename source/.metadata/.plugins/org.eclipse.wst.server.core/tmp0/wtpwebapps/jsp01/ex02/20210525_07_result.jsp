<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 결과창</title>
</head>
<body>
	<h2>forward 결과창</h2>
	<%
		int weight = (int)request.getAttribute("weight"); //다운캐스팅
		int height = (int)request.getAttribute("height");
	%>
	사각형의 넓이는? <br>
	<%=weight*height%> <br>
	
</body>
</html>