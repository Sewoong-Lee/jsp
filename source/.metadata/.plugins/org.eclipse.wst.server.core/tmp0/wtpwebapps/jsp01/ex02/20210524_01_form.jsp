<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<!-- action : form의 submit이 일어나면 이동할 경로  -->
	<!-- get방식 : url에 데이터 전송 -->
	<form action="20210524_01_result.jsp">
		아이디 <input type="text" name="userid">
		비밀번호 <input type="password" name="passwd">
		<!-- submit기능 버튼 : 액션으로 이동 -->
		<button>로그인</button>
	</form>
	
	
</body>
</html>