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
	<h2>조회</h2>
	<form action="/jsp01/list.sche">
	<button>조회</button>
	<button type="button" onclick="location.href='/jsp01/ex05_schedule/20210531_01_insert.jsp'">등록폼</button>
	</form>
	<div>
	<table>
		<tr>
			<th>날짜</th>
			<th>시간</th>
			<th>과목</th>
			<th>내용</th>
			<th>등록일자</th>
			<th>수정일자</th>
			<th>상세조회</th>
		</tr>
	<%
		ScheduleDTO sdto = null;
		List<ScheduleDTO> slist = (List<ScheduleDTO>)request.getAttribute("slist");
		if(slist != null){
			for(int i=0; i< slist.size();i++){
				//System.out.println(slist.get(i));
	%>
		<tr align="center">
			<td><a href="/jsp01/selectone.sche?sdate=<%=slist.get(i).getSdate()%>&stime=<%=slist.get(i).getStime()%>">
					<%=slist.get(i).getSdate()%></a> </td>
			<td> <%=slist.get(i).getStime()%></td>
			<td><%=slist.get(i).getSubject()%></td>
			<td><%=slist.get(i).getContent()%></td>
			<td><%=slist.get(i).getRegdate()%></td>
			<td><%=slist.get(i).getModifydate()%></td>
			<td><button onclick="location.href='/jsp01/selectone.sche?sdate=<%=slist.get(i).getSdate()%>&stime=<%=slist.get(i).getStime()%>'">상세</button> </td>
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