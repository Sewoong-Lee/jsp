<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 상품명, 상품단가, 판매수량 -->
	<form action="/jsp01/ex04/03" method="post">
		상품명 <input type="text" name="itemname"> <br>
		상품단가 <input type="number" name="price"> <br>
		판매수량 <input type="number" name="seq"> <br>
		<button>확인</button>
	</form>
	
	<%
		if(request.getAttribute("itemname")!=null && 
						request.getAttribute("sales")!= null ){
	%>
		<div>
			판매상품 : <%=request.getAttribute("itemname") %> <br>
			판매금액 : <%=request.getAttribute("sales") %> 
		</div>
	<%
		}
	%>
</body>
</html>