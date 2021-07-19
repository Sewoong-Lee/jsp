<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<!-- 입력받기 위한 창 -->
	<h2>로그인창</h2>
	<form action="20210525_08_forward.jsp" method="post">
		아이디 <input type="text" name="id">
		비밀번호 <input type="password" name="pass">
		<button>확인</button>
	</form>
	
	<!-- 실재로 돌아가는 서버 확인 -->
	<!-- 아래 경로로 복사하여 실행 -> 조금 늦음 -->
	<!-- 느려진 경우 서버 우클릭 클린, 클린톰캣, 프로젝트의 클린 -->
	<%-- <%=request.getRealPath("/") %> --%>
</body>
</html>