<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 결과</h2>
	<!-- 포워드 폴더의 내용이 나오는 창 -->
	<%
		String id = (String)request.getAttribute("id");
		String msg = (String)request.getAttribute("msg");
		int result = (int)request.getAttribute("result");
		
		if(result==0){
	%>
		<%=id %> 님 환영환영~
	<%		
		}else{
	%>
		<%=id %> 님 가입한거 맞아요??
	<%} %>
	<br>
	<%=id %> <%=msg %>
	

</body>
</html>