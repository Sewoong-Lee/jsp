<%@page import="ex03.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function selgo() {
			var findid = document.getElementById('findid').value;
			//alert(findid);
			//앞에서 쓰고 있으니까 이름은 그냥 userid로
			location.href='20210526_01_db.jsp?userid='+findid+"&gubun=update";
		}
	</script>
</head>
<body>
	<h2>기존 회원 조회</h2>
	<fieldset>
	아이디 <input type="text" id="findid">
	<button onclick="selgo()">조회</button>
	</fieldset>
	
	<%
		MemberDTO mdto = (MemberDTO)request.getAttribute("mdto");
		if(mdto!=null){
	%>
	<h2>회원 수정</h2>
	<form action="20210527_04_db.jsp">
							<!-- readonly : 수정이 안됨 -->
	아이디 <input type="text" name="userid" readonly 
					value="<%=mdto.getUserid()%>" ><br>
	비밀번호 <input type="password" name="passwd" 
					value="<%=mdto.getPasswd()%>"> <br>
	생년월일 <input type="number" name="birthyear" 
					value="<%=mdto.getBirthyear()%>"> <br>
	<button>수정</button>
	</form>
	<% } %>
	<div>
		수정 결과 : <%=request.getParameter("msg") %> <br>
		수정 건수 : <%=request.getParameter("cnt") %> 건 <br>
	
	
	</div>
	
</body>
</html>