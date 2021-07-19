<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript"> 
	function logincheck() {
		var email = loginform.email.value;
		var passwd = loginform.passwd.value;
		//alert(email);
		if(email==''){
			alert('이메일을 입력해주세요');
		}else if(passwd==''){
			alert('비밀번호를 입력해주세요');
		}else{
			loginform.submit();
		}
	}
	
	if('${param.msg}' != ''){
		alert('${param.msg}');
		//localStorage.clear();
	}
	
	if('${msg}' != ''){
		alert('${msg}');
	}
	
	if('${param.cnt}' != ''){
		session.invalidate();
		location.replace()
		localStorage.clear();
	}
	
	if('${cnt}' != ''){
		session.invalidate();
	}
</script>
</head>
<body>
	<h2>로그인</h2>
	<form action="${path}/login.log" name="loginform" method="post">
		이메일 <input type="email" name="email"> <br>
		비밀번호 <input type="password" name="passwd"> <br>
		<button type="button" onclick="logincheck()">로그인</button>
		<button type="button" onclick="location.href = '${path}/ex07_member/join.jsp'">회원가입</button> <br>
	</form>
	
	${param.msg }
</body>
</html>