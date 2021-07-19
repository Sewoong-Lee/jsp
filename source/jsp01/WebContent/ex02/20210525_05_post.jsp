<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스트 방식</title>
</head>
<body>
	<h2>상품 등록</h2>
	<!-- 상품 코드, 상품명, 단가 -->
	<!-- post : request객체 내부에 담아서 보낸다.(url에 정보가 안나옴) -->
	<!-- 한글 인코딩 방식이 달라 바꿔야함 -->
	<form action="" method="post">
		<table>
			<tr>
			<th>상품코드</th>
			<td> <input type="text" name="itemcode"> </td>
			</tr>
			<tr>
			<th>상품명</th>
			<td> <input type="text" name="itemname"> </td>
			</tr>
			<tr>
			<th>단가</th>
			<td> <input type="number" name="itemprice"> </td>
			</tr>
			<tr align="center">
			<td colspan="2"> <input type="submit" value="확인">
				<input type="reset" value="취소"> </td>
			</tr>
		</table>
	</form>
	<!-- 인코딩 방식 바꿈 -->
	<%
	//post : 포스트 방식일때 캐릭터의 인코딩 방식을 utf-8로 바꿔야 한글 읽힘
		request.setCharacterEncoding("utf-8");
		String itemcode = request.getParameter("itemcode");
		String itemname = request.getParameter("itemname");
		String itemprice = request.getParameter("itemprice");
	%>
		
	<%	
		if(itemcode != null){
	%>
			상품코드 : <%= itemcode %> <br>
	<%
		}
		if(itemname != null){
	%>
	상품이름 : <%= itemname %> <br>
	<%
		} 
		if(itemprice != null){
	%>
	상품가격 : <%=itemprice%> <br>
	
	<%}%>
	
</body>
</html>