<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- contextpath 변수 생성 -->
	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>방명록 조회</h2>
	<form action="${path}/guest/list">
	<fieldset>
		<input type="radio" name="findkey" value="nicname" checked>닉네임
		<input type="radio" name="findkey" value="email">이메일
		<input type="radio" name="findkey" value="nicemail">닉네임 + 이메일
		<input type="radio" name="findkey" value="content">내용
		<input type="text" name="findvalue"> 
		<button>조회</button>
	</fieldset>
	</form>
		<%-- ${glist} --%>
	<c:forEach var="guest" items="${glist}">
		<form action="${path}/guest/modify">
			<table>
				<tr>
					<th>순번</th>
					<td><input type="text" name="seq" value="${guest.seq}" readonly></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nicname" value="${guest.nicname}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${guest.email}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="3" cols="18" name="content">${guest.content}</textarea> </td>
				</tr>
				<tr>
					<th>등록일자</th>
					<td>${guest.regdate}</td>
				</tr>				
				<tr><td colspan="2" align="center">
					<button>저장</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='${path}/guest/remove?seq=${guest.seq}'">삭제</button>
					</td>
				</tr>
			</table>
		</form>
		<hr>
		
	</c:forEach>
	
</body>
</html>