<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//세션 접속시간 보여주기
	/* var t = 100;
	
	//setInterval : 일정시간동안 함수를 실행
	var showTime = setInterval(() => {
		t --;
		document.getElementById('time').innerHTML = t;	
		if(t<1){
			alert('세션 종료');
			clearInterval(showTime);
			//logout.log 실행
			location.href="${path}/logout.log";
		}
	}, 1000); //1초 간격 */


/* 	if('${param.msg}' != ''){
		alert('${param.msg}');
	} */
	if ('${msg}' != ''){
		alert('${msg}');
	}
	
	//세션 체크
	//세션이 없으면 로그인페이지로 보내버리기
	//로그인을 한 후 이용해주세요 메세지 보내기
	<%-- var se = '<%= (String)session.getAttribute("email") %>';
	if(se == 'null'){
		var msg = "로그인하셈";
		location.href='${path}/ex07_member/login.jsp?msg='+msg;
	} --%>
				
	if('${sessionScope.email}' == ''){
		var msg = "로그인하셈";
		location.href='${path}/ex07_member/login.jsp?msg='+msg;
	} 
</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div id= "time"></div>
	
	<h2>메인</h2>
	<!-- session 내장객체 : 이미 jsp가 만들어 놓음 -->
	<%-- <%= session.getAttribute("email") %> <br> --%>
	
	<!-- sessionScope범위 -->
	<!-- 먼저 requestScope를 찾은 후 없으면 sessionScope를 찾으므로 생략 하지 말자-->
	<!-- 만약 requestScope에 동일한게 있으면 그거로 됨 -->
	<%-- ${email}님 환영합니다. <br> --%>
	
	<!-- 값을 넘겨서 pk를 받을 수 있지만 세션 사용 예정 -->
<%-- 	<a href="${path}/detail.member?email=${sessionScope.email}">${sessionScope.email}</a>님 환영합니다. <br> --%>
	<a href="${path}/detail.member">${sessionScope.email}</a>님 환영합니다. <br>
	<a href="${path}/logout.log">로그아웃</a> <br>
	
	세션id : <%= session.getId()%> <br>
	<!-- requestScope범위 -->
	${msg} <br>
	
	<!-- 파라메터 방식 -->
	${param.msg} <br>
	
	<button onclick="location.href='${path}/list.member'">전체 회원 조회</button>
</body>
</html>