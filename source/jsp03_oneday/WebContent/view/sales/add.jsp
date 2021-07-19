<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%@include file="../sessioncheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function amountcal() {
		//선택된 수강료
		var subject = document.getElementById('subject');
		console.log(subject);
		var subjectsel = subject.options[subject.selectedIndex].id;
		//alert(subjectsel);
		
		//인원수
		var subjectcnt = document.getElementById('cnt').value;
		//alert(subjectcnt);
		
		//금액에 값 넣기
		document.getElementById("amount").value = subjectsel*subjectcnt;
	}

if('${param.cnt}' != ''){
	alert('${param.cnt}');
}
	
</script>
</head>
<body>
	<h2>클래스 신청</h2>
	<form action="${path}/add.sales" name="addform">
	<table>
		<tr>
			<th>아이디</th>
			<td> <input type="text" name="userid" value="${sessionScope.userid}" readonly="readonly"> </td>
		</tr>
		<tr>
			<th>신청날짜</th>
			<td> <input type="date" name="saledate"> </td>
		</tr>
		<tr>
			<th>클래스 선택</th>
			<td>
				<select name="subcode" onchange="amountcal()" id="subject">
					<c:forEach var="salesmap" items="${salesmap}">
					<option value="${salesmap.SUBCODE}" id="${salesmap.PRICE}">코드 : ${salesmap.SUBCODE}  과목명 : ${salesmap.SUBNAME} 가격 : ${salesmap.PRICE}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>인원수</th>
			<td> <input id="cnt" type="number" name="cnt" value="0" onchange="amountcal()"> </td>
		</tr>
		<tr>
			<th>금액</th>
			<td> <input id="amount" type="number" name="amount" readonly="readonly"> </td>
		</tr>
		<tr>
			<td colspan="2" align="right"> <button>확인</button> </td>
		</tr>
	</table>
	</form>
</body>
</html>