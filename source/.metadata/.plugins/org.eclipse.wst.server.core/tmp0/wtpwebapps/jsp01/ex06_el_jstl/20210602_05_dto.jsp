<%@page import="ex05.TimeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		TimeDTO tdto = new TimeDTO();
		tdto.setSdate("0000-00-00");
		tdto.setT1("하하");
		tdto.setT2("호호");
		
		request.setAttribute("tdto", tdto);
	%>
	
	<h4>DTO읽기</h4>
	자바형식 <br>
	<%
		TimeDTO tdto2 = (TimeDTO)request.getAttribute("tdto");
	%>
	<%=tdto2.getSdate() %> <br>
	<%=tdto2.getT1() %> <br>
	<%=tdto2.getT2() %> <br>
	<%=tdto2.getT3() %> <br>
	<hr>
	el형식 <br>
	<!-- tdto 보낸 이름 그대로 -->
	getter이 실행 : getter이 있어야한다.
	${tdto}<br>
	${tdto.sdate}<br>
	${tdto.t1}<br>
	${tdto.t2}<br>
	
	
	
	
	
	
	
	
	
	
</body>
</html>