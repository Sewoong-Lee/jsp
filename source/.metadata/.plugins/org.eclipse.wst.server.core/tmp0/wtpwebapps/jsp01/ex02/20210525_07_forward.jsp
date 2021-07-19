<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화면 이동</title>
</head>
<body>
	<h2>변수저장 + 화면이동</h2>

	<%
		int weight = 10, height = 20;
		//request 객체에 변수 값을 세팅 
		//request.setAttribute 장점 : 어떤 데이터형이든 저장 가능
		//								대량의 데이터 전송 가능(dto,list 등)
		request.setAttribute("weight", weight); //업캐스팅(자식형을 부모형으로 저장)
		request.setAttribute("height", height);
	%>
	
<%-- 	<h2>변수 읽기</h2>
	<%=request.getAttribute("weight")%> <br>
	<%=request.getAttribute("height")%> <br> --%>
	
	<h2>결과창으로 이동</h2>
	<%
		//자바 코드로 화면 이동
		//url은 변경 안되고 내용만 변경
		//페이지에 대한 정보 획득
		//RequestDispatcher rd = request.getRequestDispatcher("20210525_07_result.jsp");
		//rd.forward(request, response);
		
		//request : 요청 객체
		//response : 응답 객체 
		//한줄로
		request.getRequestDispatcher("20210525_07_result.jsp").forward(request, response);
	%>
	
	
</body>
</html>