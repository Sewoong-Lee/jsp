<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el (표현언어)</h2>
	${10+20} <br>
	${10/3} <br>
	${10%3} <br>
	${10 mod 3} <br>
	${10 == 10} <br>
	${10 eq 10} <br>
	
	${10>20? 10:20 } <br>
	<!-- 10보다 20이 크면 10을 아니면 20을 출력 -->
	
</body>
</html>