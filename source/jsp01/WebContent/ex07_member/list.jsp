<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		//권한 체크
		//const loginemail = '${sessionScope.email}';
		//alert(loginemail);
		if('${sessionScope.email}' == ''){
			var msg = "로그인하셈";
			location.href='${path}/ex07_member/list.jsp?msg='+msg;
		}else{
			var listfield = document.getElementById('listfield').value;
			var listvalue = document.getElementById('listvalue').value;
			//alert(listfield);
			//alert(listvalue);
			if(listfield != 'all' && listvalue==''){
				alert('값을 입력해 주세요.');
			}else{  
				location.href="${path}/list.member?listfield="+listfield+"&listvalue="+listvalue;
			}	
			
		}
	}
	if('${param.msg}' != ''){
		alert('${param.msg}');
		//localStorage.clear();
	}

</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h2>전체 회원 조회</h2>
	<c:out value="${listfield == 'email'?'selected' : ''}"/>
	<!-- 만약에 email이라면 selected를 출력 하고 아니면 ''을 출력 -->
	<!-- 기존값 저장 적용 -->
	<fieldset>
		<select name="listfield" id="listfield">
			<option value="all" ${listfield == 'all'?'selected' : ''}>전체조회</option>
			<option value="email" ${listfield == 'email'?'selected' : ''}>이메일</option>
			<option value="nicname" ${listfield == 'nicname'?'selected' : ''}>닉네임</option>
			<option value="phone" ${listfield == 'phone'?'selected' : ''}>폰번호</option>
			<option value="addr" ${listfield == 'addr'?'selected' : ''}>주소</option>
		</select>
		<input type="text" name="listvalue" id="listvalue" value="${listvalue}">
		<button type="button" onclick="check()">확인</button>
	</fieldset>
	<div>
	출력값 <br>
		<table>
			<tr>
				<th>이메일</th>
				<th>닉네임</th>
				<th>폰</th>
				<th>주소</th>
				<th>생성일</th>
				<th>수정일</th>
			</tr>
	<c:forEach var="list" items="${list}">
		<tr>
			<td><a href="${path}/onedet.member?email=${list.email}">${list.email}</a></td>
			<td>${list.nicname}</td>
			<td>${list.phone}</td>
			<td>${list.addr}</td>
			<td>${list.regdate}</td>
			<td>${list.modifydate}</td>
		</tr>
	</c:forEach>
	</table>
	</div>
	
</body>
</html>