<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('${param.msg}' != ''){
		alert('${param.msg}');
	}


</script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>포켓몬 타입 등록</h2>
	<form action="${path}/insert.ptype" method="post">
	타입코드 <input type="text" name="tcode">
	타입네임 <input type="text" name="tname">
	<button>확인</button>
	</form>

</body>
</html>