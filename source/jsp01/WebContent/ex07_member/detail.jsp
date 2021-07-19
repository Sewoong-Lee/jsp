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
	
/* 	if('${param.cnt}' != ''){
		location.href="${path}/detail.member";
	}  */
	
	function deletecheck() {
		if('${sessionScope.email}' != '${mdto.email}'){
			alert('당신의 아이디가 아닙니다.');
			//리턴으로 함수 강제 종료
			return;
		}
		var rs = confirm('정말 탈퇴 하실겁니까?');
		if(rs){
			location.href = '${path}/delet.member';
		}
		
	}
	
	function updheck() {
		if('${sessionScope.email}' != '${mdto.email}'){
			alert('당신의 아이디가 아닙니다.');
			//리턴으로 함수 강제 종료
			return;
		}
		
		location.href = '${path}/updateform.member';
	}
	

</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h2>상세조회</h2>
	<!-- 이런식으로 하이드해서 값을 가지고 있을 수 있다. -->
	<input type="hidden" id="email" value="${mdto.email}">
	
	이메일 : ${mdto.email} <br>
	닉네임 : ${mdto.nicname} <br>
	전화번호 : ${mdto.phone} <br>
	주소 : ${mdto.addr} <br>
	등록일자 : ${mdto.regdate} <br>
	수정일자 : ${mdto.modifydate} <br>
	
	<%-- 이메일 : <input type="email" name="email" value="${mdto.email}"> <br>
	비밀번호 : <input type="password" name="passwd" value="${mdto.passwd}"> <br>
	닉네임 : <input type="text" name="nicname" value="${mdto.nicname}"> <br>
	전화번호 : <input type="tel" name="phone" value="${mdto.phone}"> <br>
	주소 : <input type="text" name="addr" value="${mdto.addr}"> <br> --%>
		
	<button onclick="location.href = '${path}/ex07_member/main.jsp'">뒤로</button>
	<button onclick="updheck()">수정</button> 
	<button onclick="deletecheck()">탈퇴</button>
	
	
</body>
</html>