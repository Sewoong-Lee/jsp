<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모장</title>
</head>
<body>
	<h2>한줄 인사</h2>
	<!-- 절대 경로 --><!-- http://localhost:8081 까지는 톰캣 -->
	<%
		String ContextPath = request.getContextPath();
	%>
	<%=ContextPath %>
	<!-- 컨테스트패스는 배포단계에서 바뀔수 있어서 변수에 담아 경로 설정 -->
	<!-- <%=request.getContextPath()%> 이거 바로 넣어도댐-->
	<form action="<%=ContextPath%>/ex02/20210525_06_momeresult.jsp" method="post">
	
	<!-- 컨페스트패스 jsp02 진입 -->
	<!-- <form action="/jsp02/20210525_06_momeresult.jsp" method="post"> -->

	이메일 : <input type="email" name="mail"> <br> <br>
	메모 : <textarea name="memo" rows="5" cols="15"></textarea> <br>
	<button>확인</button>
	</form>
	
	
</body>
</html>