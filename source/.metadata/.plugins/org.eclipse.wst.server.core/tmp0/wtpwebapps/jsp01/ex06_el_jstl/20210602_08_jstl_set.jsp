<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- prefix : 접두사 -->
<!-- core : 핵심태그 모여있는 라이브러리 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자바 방식 표현</h2>
	<%
		String path = request.getContextPath();
	%>
	<%=path %>
	
	<h2>el</h2>
	${pageContext.request.contextPath}
	
	<h4>jstl 변수 생성</h4>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	${path}
	
	
	
	
	
	
	
	
</body>
</html>