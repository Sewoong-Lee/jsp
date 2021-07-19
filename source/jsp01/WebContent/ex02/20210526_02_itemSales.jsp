<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" >
		function check() {
			if(sumfrm.name==''&&sumfrm.price==''&&sumfrm.seq==''){
				alert('전부 입력해주세요');
			}else{
				sumfrm.submit();
			}
		}
	</script>
</head>
<body>
	<form name="sumfrm" action="20210526_02_redirect.jsp" method="post" enctype="application/x-www-form-urlencoded">
	상품명 <input type="text" name="name">
	단가 <input type="number" name="price">
	판매수량 <input type="number" name="seq">
	<button type="button" onclick="check()">확인</button>
	</form>
	
	
	판매금액
	<%
		String name = (String)request.getAttribute("name");
		int sum = 0;
		if(request.getAttribute("sum")!=null){
			sum = (int)request.getAttribute("sum");
		}
	%>
<%-- 	상품명 <%= name%>
	총 판매 금액 <%= sum %> --%>
	총 판매 금액 <%= request.getParameter("sum") %>
	상품명 <%= request.getParameter("name")%>

</body>
</html>