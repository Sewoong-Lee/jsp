<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../includ/includ.jsp" %>
<%@include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="${path}/join.member">
		<table>
			<tr>
				<th>아이디</th>
				<td> <input type="text" name = "userid"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input type="password" name = "passwd"> </td>
			</tr>
			<tr>
				<th>이름</th>
				<td> <input type="text" name = "name"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"> 
					<button>확인</button> 
					<button type="reset">취소</button> 
				</td>
			</tr>
			
		</table>
		
	
	</form>

</body>
</html>