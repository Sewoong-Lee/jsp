<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사칙연산</title>
<script type="text/javascript">
	function calGo() {
		var num1 = document.getElementById("num1").value;
		var num2 = document.getElementById("num2").value;
		var giho = document.getElementById("giho").value;
		alert(num1 + num2 + giho);
		
		location.href='/jsp01/ex04/04?num1='+num1+'&num2='+num2+'&giho='+giho;
	}
</script>
</head>
<body>
	두수 <input type="number" id="num1"> <input type="number" id="num2">
	기호 <input type="text" id="giho">
	<button onclick="calGo()">확인</button>
	
	<div>
		합은 : <%=request.getParameter("sum") %>
	</div>
</body>
</html>