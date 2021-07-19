<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function gogo() {
			const ban = formarea.ban.value;
			//alert(ban);
			//get방식으로 전송 : url뒤에 데이터 전송
			location.href='20210525_03_circleresult.jsp?ban='+ban;
			//ban의 결과값이 만들어져 있지 않아 + 로 추후 연결
		}
	
	</script>
</head>
<body>
	<h2>원의 넓이를 구하기</h2>
	get방식으로 전송 : url뒤에 데이터 전송
	<form name="formarea" action="20210525_03_circleresult.jsp">
		반지름 <input type="number" name="ban">
		<button>계산(submit)</button>
	</form>
	
	<button onclick="gogo()">계산(button)</button>
</body>
</html>