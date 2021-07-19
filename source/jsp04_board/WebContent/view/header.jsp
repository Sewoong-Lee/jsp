<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function loginToggle() {
		var login = document.getElementById('login');
		var logout = document.getElementById('logout');
		console.log(login.style);
		if ('${sessionScope.userid}'==''){
			login.style.visibility = 'visible';
			logout.style.visibility = 'hidden';
		}else{
			login.style.visibility = 'hidden';
			logout.style.visibility = 'visible';
		}
		
	}

</script>
</head>
<body onload="loginToggle()">
	<header>
		<h2>게시판</h2>
		<div>
			<a id="login" href="${path}/view/member/login.jsp" >로그인</a>
			<span>${sessionScope.userid}</span>
			<a id ="logout"  href="${path}/logout.member">로그아웃</a>
		</div>
		
	</header>
	<nav>
		<a href="${path}/view/home.jsp">홈</a>
		<a href="${path}/view/board/add.jsp">게시물 등록</a>
		<a href="${path}/board/list">게시물 리스트</a>
	</nav>
</body>
</html>