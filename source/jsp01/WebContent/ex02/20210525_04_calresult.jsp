<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사칙연산 결과창</h2>
	<%
		String one = request.getParameter("one");
		String two = request.getParameter("two");
		int one2 = Integer.parseInt(one);
		int two2 = Integer.parseInt(two);
	%>
	더하기 <%=one2+two2%> <br>
	빼기 <%=one2-two2%> <br>
	곱하기 <%=one2*two2%> <br>
	나누기 <%=(double)one2/two2%> <br>
	
	
</body>
</html>