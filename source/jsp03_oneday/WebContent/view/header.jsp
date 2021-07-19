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
<!-- 로그인 체크 -->
<script type="text/javascript">

	if('${param.mag}' != ''){
		alert('${param.mag}');
	}
	
	if('${mag}' != ''){
		alert('${mag}');
	}

</script>

<style> 
	header{
		display: flex;
		justify-content : space-around;
	  	align-items:baseline;
	}
#test_btn1{ 
	margin-right:-4px;
	border-top-left-radius: 5px; 
	border-bottom-left-radius: 5px;
 } 
#test_btn2{
 	margin-left:-3px;
 	border-top-left-radius: 5px; 
	border-bottom-left-radius: 5px;
 } 
 #test_btn3{
 	margin-left:-7px;
 	border-top-left-radius: 5px; 
	border-bottom-left-radius: 5px;
 } 
#btn_group button{ 
	border: 1px solid skyblue; 
	background-color: rgba(0,0,0,0); 
	color: skyblue; 
	padding: 5px; 
	
} 
#btn_group button:hover{ 
	color:white; background-color: skyblue; 
}
</style>
</head>
<body>
	<header>
	<div>
		<h2>헤더</h2>
	</div>
	<div id="btn_group">
		<span>${sessionScope.userid} 님</span>
		<button onclick="location.href='${path}/view/login/login.jsp'" id="test_btn1">로그인</button>
		<button onclick="location.href='${path}/logout.member'" id="test_btn3">로그아웃</button>
	</div>
	</header>
		<nav id="btn_group">
			<button onclick="location.href='${path}/view/home.jsp'" id="test_btn1">홈</button>
			<button onclick="location.href='${path}/selectlist.subject'" id="test_btn2">과목 리스트</button>
			<button onclick="location.href='${path}/addform.subject'" id="test_btn3">과목 등록</button>
			<button onclick="location.href='${path}/addform.sales'" id="test_btn3">클래스 신청</button>
			<button onclick="location.href='${path}/list.sales'" id="test_btn3">클래스 조회</button>
			<button onclick="location.href='${path}/listtotal.sales'" id="test_btn3">신청 집계</button>
		</nav>
	<hr>
</body>
</html>