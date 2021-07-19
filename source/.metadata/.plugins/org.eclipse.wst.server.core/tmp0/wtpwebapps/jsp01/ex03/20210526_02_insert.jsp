<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function insert() {
			var userid = inform.userid.value;
			var passwd = inform.passwd.value;
			var birthyear = inform.birthyear.value;
			//alert(userid);
			if(userid==''|| passwd=='' || birthyear==''){
				alert('전부 입력 해주세요');
			}else{
				inform.submit();
			}
		}
		
		//메세지창 띄우기
		if('<%=request.getParameter("msg")%>' !='null'){
			alert('<%=request.getParameter("msg")%>');
		}
		</script>
</head>
<body>
	<h2>회원 가입</h2>
	<form name="inform" action="20210526_02_db.jsp">
		아이디 <input type="text" name="userid">
		패스워드 <input type="text" name="passwd">
		생년월일 <input type="number" name="birthyear">
		<button type="button" onclick="insert()">확인</button>
	</form>
	
	<div>
	<!-- 리스펀스 사용시 -->
	<%=request.getParameter("msg")%>
		<%
		if(request.getAttribute("rs")!=null){
			int rs = (int)request.getAttribute("rs");
			if(rs>0){
		%>
			아이디 <%=request.getAttribute("userid") %> <br>
			패스워드 <%=request.getAttribute("passwd") %> <br>
			생년 <%=request.getAttribute("birthyear") %> <br>
			가입 완료
		<%	
			}else{
		%>		
				가입 실패
		<%		
			}
		}
		%>
	
	
	</div>

</body>
</html>