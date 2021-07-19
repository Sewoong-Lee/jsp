<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<input type="checkbox" name="menu" value="짜장면"> 짜
		<input type="checkbox" name="menu" value="짬뽕"> 짬
		<input type="checkbox" name="menu" value="고기"> 고
		<button>확인</button>
	</form>
	<%	//자바로 하면 이렇게됨
		String[] menus = request.getParameterValues("menu");
		if(menus != null){
			for(int i=0; i<menus.length;i++){
	%>
			<%= i+1 %><%= menus[i] %> <br>
	<%			
			}	
		}
	%>
	<h2>파라메터 배열 읽기(Values)</h2>
	반복문은 jstl라이브러리로
	${paramValues.menu[0] } <br>
	${paramValues.menu[1] } <br>
	${paramValues.menu[2] } <br>
</body>
</html>