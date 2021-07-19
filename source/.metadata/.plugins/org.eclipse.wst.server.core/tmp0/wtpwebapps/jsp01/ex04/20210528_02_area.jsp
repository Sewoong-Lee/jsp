<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원주율 구하기</title>
</head>
<body>
	<form action="/jsp01/ex04/02" method="post">
		반지름 <input type="number" name="ban"> cm <br>
		<button>계산</button>
	</form>
	<div>
	<%
		if(request.getAttribute("area")!=null){
	%>
		원의 넓이는 : <%=request.getAttribute("area") %>
	<%		
		}
	%>
	</div>
</body>
</html>