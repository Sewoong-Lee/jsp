<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이름, 성별, 직업은 옵션, 취미 체크박스 -->
	<form action="20210525_01_result.jsp">
		이름: <input type="text" name="name"> <br>
		성별: <input type="radio" name="gender" value="men">남자
			<input type="radio" name="gender" value="women">여자 <br>
		직업: <select name="jop">
				<option value="학생">학생</option>
				<option value="선생님">선생님</option>
			</select>
			<br>
		취미: <input type="checkbox" name="habby" value="game">게임
			<input type="checkbox" name="habby" value="movie">영화
			<input type="checkbox" name="habby" value="cooking">요리
	<button>버튼</button>
	<button onclick="history.go()">다음페이지</button>
	</form>

</body>
</html>