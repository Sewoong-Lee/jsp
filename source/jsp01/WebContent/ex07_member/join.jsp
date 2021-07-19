<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function joincheck() {
		var email = joinform.email.value;
		var passwd = joinform.passwd.value;
		var nicname = joinform.nicname.value;
		
		if(email ==''){
			alert('이메일 미입력');
			joinform.email.focus();
			return false;
		}else if(passwd==''){
			alert('비밀번호 미입력');
			joinform.passwd.focus();
			return false;
		}else if(nicname==''){
			alert('닉네임 미입력');
			joinform.nicname.focus();
			return false;
		}
		return true;
	}

	
	if('${param.msg}' != ''){
		alert('${param.msg}');
	}
	
	//이메일 기존값 세팅
	function emailsetting() {
		if('${param.email}' != ''){
			//alert('${param.email}');
			joinform.email.value = '${param.email}';
		}	
	}
	
	function emailcheck() {
		var email = joinform.email.value;
		//alert(email);
		//이메일 체크시 서브밋이 아니어서 이메일 형식 체크가 안일어남
		//따로 이메일 @표시 체크(정규식 이용)
		var pattern = new RegExp('@');
		
		if(email ==''){
			alert('이메일 미입력');
			joinform.email.focus();
		//이메일 형식 확인
		}else if(!pattern.test(email)){
			alert('이메일 형식 오류');
		}else{
		
		location.href = '${path}/emailcheck.member?email='+email;
		}
	}


	
</script>
</head>
<!-- 바디가 완료 후 이메일셋팅 실행 -->
<%@ include file="header.jsp" %>
<body onload="emailsetting()">

	<h2>회원가입</h2>
	<form action="${path}/join.member" name="joinform" method="post" onsubmit="return joincheck()">
	<table>
		<tr>
			<th>이메일</th>
			<td>
				<input type="email" name="email">
				<button type="button" onclick="emailcheck()">중복체크</button>
			</td>
			
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nicname"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="tel" name="phone"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="addr"></td>
		</tr>
		<tr>
			<!-- <td> <button type="button" onclick="joincheck()">가입</button> </td> -->
			<td> <button>가입</button> </td>
			<td> <button type="reset">리셋</button> </td>
		</tr>
	</table>
	</form>
</body>
</html>