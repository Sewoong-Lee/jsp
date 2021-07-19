<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	//로그인되면 헤더 로그인버튼 숨기기
	function sessioncheck() {
		if('${sessionScope.email}' != ''){
			document.getElementById('login').style.visibility = 'hidden';
		}else{
			document.getElementById('logout').style.visibility = 'hidden';
		}
	}
</script>
</head>
<body onload="sessioncheck()">
	<header>
		<div>회원 관리 프로그램 v1.0</div>
		<nav>
			<div>
				<button onclick="location.href = '${path}/list.member'">회원조회</button>
				<a href="${path}/ex07_member/login.jsp" id="login">로그인</a>
				<a href="${path}/logout.log" id="logout">로그아웃</a> <br>
				<a href="${path}/detail.member">${sessionScope.email}</a>님 환영합니다. <br>
			</div>
		</nav>
	</header>
	<hr>
</body>
</html>