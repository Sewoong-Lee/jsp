<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿매핑</title>
</head>
<body>	
	<h2>서블릿매핑</h2>
	<h3>get</h3>
	<form action="/jsp01/ex04/01" method="get">
		아이디 <input type="text" name="userid" >
		<button>확인</button>
	</form>
	
	<%= request.getAttribute("msg") %>
	
	<h3>post</h3>
	<form action="/jsp01/ex04/01" method="post">
	아이디 <input type="text" name="userid" >
	<button>확인</button>
	</form>
	
	
</body>
</html>