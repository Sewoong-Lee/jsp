<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 리스트 생성 -->
	<%
		List<String> list = new ArrayList<String>();
		list.add("파파");
		list.add("자자");
	
		request.setAttribute("list", list);
	%>
	<h4>java</h4>
	<!-- 기존 방법 출력 -->
	<% 
		List<String> list2 = (List<String>)request.getAttribute("list"); 
		
		for(int i=0;i<list.size();i++){
	%>
		<%=list.get(i) %> <br>
	<%		
		}
	%>
	
	<h4>el</h4>
	<!-- el식 -->
	${list[0] } <br>
	${list[1] } <br>
	
</body>
</html>