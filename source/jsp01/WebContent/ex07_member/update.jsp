<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('${param.msg}' != ''){
		alert('${param.msg}');
	}
	
	
	if('${msg}' != ''){
		alert('${msg}');
	}
</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form action="${path}/update.member">
	<table>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" value="${mdto.email}"> 수정불가</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd" value="${mdto.passwd}"></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nicname" value="${mdto.nicname}"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="tel" name="phone" value="${mdto.phone}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="addr" value="${mdto.addr}"></td>
		</tr>
		<tr>
			<td> <button>확인</button> </td>
		</tr>
	</table>
	</form>
</body>
</html>