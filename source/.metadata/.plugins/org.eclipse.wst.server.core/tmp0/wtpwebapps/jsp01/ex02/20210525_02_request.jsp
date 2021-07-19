<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>request 객체</h3>
	두 페이지간의 데이터를 전송 <br>
	현재 페이지의 경로(ContextPath) : <%= request.getContextPath() %> <br>
	URI : <%=request.getRequestURI() %> <br>
	URL : <%=request.getRequestURL() %> <br>
	ip주소 : <%=request.getRemoteAddr() %> <br>
	도메인 : <%=request.getServerName() %> <br>
	포트번호 : <%=request.getServerPort() %> <br>
	
	<hr>
	<h2>request 헤더 정보</h2>
	<%
		Enumeration<String> rh = request.getHeaderNames();
		while(rh.hasMoreElements()){
			//헤더 목록 
			String h = rh.nextElement();
			//헤더 목록 및 값
			String hh = request.getHeader(h);
	%>
		<%=h %> : <%=hh %> <br>
	<%
		}
	
	%>
	
	
	
	
</body>
</html>