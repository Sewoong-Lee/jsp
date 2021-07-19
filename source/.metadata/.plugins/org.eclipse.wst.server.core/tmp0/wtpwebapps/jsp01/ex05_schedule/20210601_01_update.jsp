<%@page import="ex05.ScheduleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function up() {
		if(upform.subject.value==''){
			alert('과목을 입력해주세여');
		}else{
			upform.submit();
		}
	}

</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<%
	ScheduleDTO sdto = (ScheduleDTO)request.getAttribute("sdto"); 
	%>
	<h2>수정</h2>

	<hr>
	<h4>**수정 정보</h4>
	<!-- 현재 각 테이블의 값을 sdto로 읽어왔으므로 수정 이후 다시 받아야 값들이 유지됨 -->
	<form action="/jsp01/ex05/update.sche" name="upform">
	<table>
		<tr>
			<th>날자 </th>
			<td><input type="date" name="sdate" value="<%=sdto.getSdate()%>" readonly> 수정불가 </td>
		</tr>
		<tr>
			<th>시간</th>
			<td><input type="number" name="stime" min="1" max="8" value="<%=sdto.getStime()%>" readonly>수정불가</td>
		</tr>
		<tr>
			<th>과목</th>
			<td><input type="text" name="subject" placeholder="<%=sdto.getSubject()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="25" name="content" placeholder="<%=sdto.getContent()%>"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"> 
				<input type="button" onclick="up()" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
<%-- 	결과 : <%= request.getAttribute("msg") %> 
			<%= request.getAttribute("cnt") %> 건 --%>
	<%@ include file="footer.jsp" %>
</body>
</html>