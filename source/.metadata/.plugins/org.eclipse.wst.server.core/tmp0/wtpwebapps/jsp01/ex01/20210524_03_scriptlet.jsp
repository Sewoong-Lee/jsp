<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 동적인 웹 페이지 자바로 구현 -->
	<h2>스크립트 테스트</h2>
	<!-- 아래처럼 jsp코드를 감싸주면 효과 가능 -->
	<h2>
	<%
		for (int i=0; i<11; i++){
			out.print(i + "<br>");
		}
	
	%>
	</h2>
	
	<h2>변수 짝 홀수 판별</h2>
	<%
	int arr[] = {1,2,3,4,5,6,7,8,9,10};
	
	for(int i=0; i<arr.length; i++){
		if(arr[i]%2==0){
			out.print("짝수" + arr[i] + " ");
		}
	}
	out.print("<br>");
	
	for(int i=0; i<arr.length; i++){
		if(arr[i]%2!=0){
			out.print("홀수" + arr[i] + " ");
		}
	}
	%>
	
	<h2>구구단 출력</h2>
	<%
		int dan =3;
		for(int i=1; i<10; i++){
			out.print(dan+"x"+i+"="+dan*i+"<br>");
		}
	
	
	%>
	
	
	
	
</body>
</html>