<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	List<Map<String,String>> list = new ArrayList<>();
	
		Map<String,String> map = new HashMap<String,String>();
		map.put("aa", "가");
		map.put("bb", "나");
		map.put("cc", "다");
		list.add(map);
		
		request.setAttribute("map", map);
		
		map = new HashMap<String,String>();
		map.put("a", "에이");
		map.put("b", "비");
		map.put("c", "씨");
		list.add(map);
		
		request.setAttribute("list", list);
		
	%>
	
	<h4>자바</h4>
	<%
		Map<String,String> rmap = (Map<String,String>)request.getAttribute("map");
		List<Map<String,String>> rlist = (List<Map<String,String>>)request.getAttribute("list");
	%>
	<%=rmap %> <br>
	<%=rmap.get("aa") %> <br>
	<%=rmap.get("bb") %> <br>
	<%=rmap.get("cc") %> <br>
	
	<%=rlist%>
	
	<h4>el</h4>
	<!-- 키가 숫자면 못읽음 다른 방법으로-->
	${map } <br>
	${map.aa} <br>
	${map.bb} <br>
	${map.cc} <br>
	
	${list } <br>
	${list[0].aa} <br>
	
	
	
</body>
</html>