<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ins() {
		var sdate = insertform.sdate.value;
		//alert(sdate);
		if(sdate==''){
			alert('날짜를 입력해 주세여');
			insertform.sdate.focus();
		}else if(insertform.stime.value==''){
			alert('시간을 입력해 주세여');
		}else if(insertform.subject.value==''){
			alert('과목을 입력해 주세여');
		}else{
			insertform.submit();
		}
	}

</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<h2>시간표 추가</h2>  <!-- .을 이요한게 확장자 패턴 -->
	<form action="/jsp01/ex05/insert.sche" name ="insertform">
<!-- 	<form action="/jsp01/ex05/sche/insert" name ="insertform"> -->
	<table>
		<tr>
			<th>날자 </th>
			<td><input type="date" name="sdate"> </td>
		</tr>
		<tr>
			<th>교시</th>
			<td><input type="number" name="stime" min="1" max="8"></td>
		</tr>
		<tr>
			<th>과목</th>
			<td><input type="text" name="subject"></td>
		</tr>
		<tr>
			<th>비고</th>
			<td><textarea rows="5" cols="25" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"> 
				<input type="button" onclick="ins()" value="저장">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
	결과 : <%= request.getAttribute("cnt") %> 
				<%= request.getAttribute("msg") %>
	<%@ include file="footer.jsp" %>
	
</body>
</html>