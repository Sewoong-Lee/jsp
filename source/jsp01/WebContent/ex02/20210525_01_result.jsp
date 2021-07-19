<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function newgo() {
		//새로운 결과 창으로 이동
		var name = document.getElementById('name').innerText;
		console.log(name);
		//alert('성공');
		var gender = document.getElementById('gender').innerText;
		console.log(gender);
		location.href ='20210525_01_newresult.jsp?name='+name +'&gender='+gender;
	}
	
</script>
</head>
<body>
	<h3>결과창</h3>
	request : 요청 하는쪽, 요청을 받는쪽 두화면만 데이터 공유
	<%
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String jop = request.getParameter("jop");
		String[] habby = request.getParameterValues("habby");
	%>
	
	당신의 이름은 <span id="name"><%=name %></span> <br>
	당신의 성별은 <span id="gender"><%=gender %></span> <br>
	당신의 직업은 <span id="jop"><%=jop %></span> <br>
	<%
	if(habby != null){ //널포인트이셉션 (이거 안하면 널일때 에러남)
		for(int i=0;i<habby.length;i++){
			String habbyv = habby[i];	
	%>
	당신의 취미는 <%=habbyv %> <br>
		<%} 
	}%>
	<hr>
	<button onclick="newgo()">다른폼으로 이동</button>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>