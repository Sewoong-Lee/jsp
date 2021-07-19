<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function nn() {
			const n = frmsum.nvalue.value;
			//alert(n);
			if(n=='' || n==0){
				alert('0보다 큰값을 입력해 주세요!');
				frmsum.nvalue.focus();
			}else{
				frmsum.submit();
			}
		}
	</script>
</head>
<body>
	<h2>n까지의 합계 구하기</h2>
	<form name="frmsum" action="/jsp01/ex02/20210526_01_forward.jsp">
	n값은? <input type="number" name="nvalue" required="required">
	<!-- required="required": 값을 입력하도록 유도 -->
	<button type="button" onclick="nn()">확인</button>
	</form>
	
	
	<div>
		<span>결과</span> <br>
		<%
			int sum = 0;
			if(request.getAttribute("sum")!=null){
				sum = (int)request.getAttribute("sum");
			}
		%>
		합계는 <%=sum%>
		
	
	</div>
</body>
</html>