<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식</title>
</head>
<body>
	<h2>표현식</h2>
	<%
		String name = "홍홍";
		out.println(name+"님 할로<br>");
	%>
	
	<!-- 아래처럼 변수를 html처럼 사용 가능 : 변수를 돔에 표현 표현식 -->
	<%=name %> 님 반갑습니다. <br>
	
	<h2>성인 여부</h2>
	<%  //아래처럼 중간에도 표현식 조건문 가능
		//20살 이상이면 성인, 아니면 미성년자
		int age = 19;
		if(age >= 20){
	%>
		<%=age %> 살은 성인 <br>
	<%
		}else{
	%>
		<%=age %> 살은 미성년 <br>
	<%} %>
	
	<!-- 표현식 출력 -->
	<h2>1~10 까지 출력</h2>
	<%
		for(int i=0;i<11;i++){
	%>
		<%=i %> <br>
	<%
		}
	%>	
		
	<!-- 표현식 구구단 -->
	<%
	int dan = 3;
	for(int i=1;i<10;i++){
	%>
	<%=dan%> X <%=i%> = <%=dan*i%> <br>
	<%} %>
	
	<!-- 표현식 배열 -->
	<h2>배열안의 데이터 출력</h2>
	<%
		String arr[] = {"키득","히히","푸풉"};
		for(int i=0;i<arr.length;i++){
	%>
	<ol>
		<li> <%= arr[i]%> </li>
	</ol>
	<%}%>
	
	
<table border="1">
		<tr>
			<td>번호</td>
			<td>언어</td>
		</tr>
		<%
			String arr2[] = {"키득","히히","푸풉"};
			for(int i=0;i<arr.length;i++){
		%>
		<tr>	
			<td><%=i+1%></td>
			<td><%=arr2[i]%></td>
		</tr>
		<!-- 아래 } 가 밖으로 빠지면 위의 번호, 언어 까지 반복(테이블 전체 반복)  -->
		<%}%> 
	</table>
	
	<h2>자바스크립트의 표현식</h2>
	<%
		String id = "자비스";
	%>
	<script type="text/javascript">
	/* 자바의 변수가 공백이므로 자바를 계산 후 출력 하려니 값이 
		없어 자스 변수에'' 넣어야함 */
		if('<%=id%>' == ''){
			alert('아이디를 입력해주세요.');
		}else{
			alert('<%=id%>님 하이루.');
		}
	</script>
	
	
	
	
	
	
	
	
</body>
</html>