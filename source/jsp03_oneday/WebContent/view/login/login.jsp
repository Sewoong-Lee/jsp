<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<!-- contextpath 변수 생성 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	if('${param.msg}' != ''){
		alert('${param.msg}');
	}

</script>
</head>
<body>
	<h2>로그인</h2>
	<form name="loginform" action="${path}/login.member">
	아이디 <input type="text" name="userid">
	비밀번호 <input type="password" name="passwd">
	<button>확인</button>
	<button type="button" onclick="location.href='${path}/view/member/join.jsp'">회원가입</button>
	</form>
</body>
</html>