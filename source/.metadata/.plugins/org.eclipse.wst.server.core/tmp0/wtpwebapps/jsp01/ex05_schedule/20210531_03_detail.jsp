<%@page import="ex05.ScheduleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
	ScheduleDTO sdto = (ScheduleDTO)request.getAttribute("sdto"); 
	%>
<script type="text/javascript">
	function del() {
		//alert('삭제 할거야?');
		var rs = confirm("삭제 할거야?")
		if(rs){
		location.href='/jsp01/delete.sche?sdate=<%=sdto.getSdate()%>&stime=<%=sdto.getStime()%>'
		}
	}
</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<h2>상세조회</h2>


	날짜 : <%=sdto.getSdate()%> <br>
	시간 : <%=sdto.getStime()%> <br>
	과목 : <%=sdto.getSubject()%> <br>
	내용 : <%=sdto.getContent()%> <br>
	등록일자 : <%=sdto.getRegdate()%> <br>
	수정일자 : <%=sdto.getModifydate()%> <br>
	
	
	<button onclick="location.href='/jsp01/updateform.sche?sdate=<%=sdto.getSdate()%>&stime=<%=sdto.getStime()%>'">수정</button>
	<button onclick="del()">삭제</button>
	<!-- 알림창 버튼만듬 -->
	<%-- <button onclick="location.href='/jsp01/delete.sche?sdate=<%=sdto.getSdate()%>&stime=<%=sdto.getStime()%>'">삭제</button> --%>
	<%@ include file="footer.jsp" %>
</body>
</html>