<%@page import="java.util.Map"%>
<%@page import="ex05.TimeDTO"%>
<%@page import="ex05.ScheduleDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('<%=request.getParameter("msg")%>' != 'null'){
		alert('<%=request.getParameter("msg")%>');
		//get 파라메터 제거 (새로고침해도 alert 안나오게)
		history.replaceState({}, null, location.pathname);
	}

</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<h2>맵테이블</h2>
	<fieldset>
	<%
		//컨트롤러에서 넘어온 데이트 값 저장
		String startdate = (String)request.getAttribute("startdate");
		String enddate = (String)request.getAttribute("enddate");
		System.out.println(startdate);
		System.out.println(enddate);
	%>
		<form action="/jsp01/map.sche">
			날짜 <input type="date" name="startdate" value="<%= startdate%>"> ~ <input type="date" name="enddate" value="<%= enddate%>">
			<button>조회</button>
			<button type="button" onclick="location.href='/jsp01/ex05_schedule/20210531_01_insert.jsp'">등록폼</button>
		</form>
	</fieldset>
	<div>
	<table>
		<tr>
			<th>날짜</th>
			<th>1교시</th>
			<th>2교시</th>
			<th>3교시</th>
			<th>4교시</th>
			<th>5교시</th>
			<th>6교시</th>
			<th>7교시</th>
			<th>8교시</th>
		</tr>
	<%
		TimeDTO tdto = null;
		List<Map<String, String>> tlist = (List<Map<String, String>>)request.getAttribute("tlist");
		if(tlist != null){
			for(int i=0; i<tlist.size();i++){
				//System.out.println(slist.get(i));
	%>
		<tr align="center">
			<td> <%=tlist.get(i).get("sdate")%></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=1">
					<%=tlist.get(i).get("t1")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=2">
					<%=tlist.get(i).get("t2")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=3">
					<%=tlist.get(i).get("t3")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=4">
					<%=tlist.get(i).get("t4")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=5">
					<%=tlist.get(i).get("t5")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=6">
					<%=tlist.get(i).get("t6")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=7">
					<%=tlist.get(i).get("t7")%></a></td>
			<td> <a href="/jsp01/selectone.sche?sdate=<%=tlist.get(i).get("sdate")%>&stime=8">
					<%=tlist.get(i).get("t8")%></a></td>
		</tr>
	<%
			}
		}
	%>
	</table>
	</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>