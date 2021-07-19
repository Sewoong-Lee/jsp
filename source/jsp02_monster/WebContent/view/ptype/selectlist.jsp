<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('${param.msg}' != ''){
		alert('${param.msg}');
	}
	
	function removecheck(tcode) {
		//alert(tcode);
		if(confirm('정말 삭제?')){
			location.href = '${path}/delet.ptype?tcode='+tcode;
		}
	}
	
</script>
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>타입 전체 조회</h2>
	<fieldset>
		<form action="${path}/list.ptype" method="post">
			<input type="radio" name="findkey" value="tcode" ${findkey == 'tcode' ? 'checked' : ''}> 코드
			<input type="radio" name="findkey" value="tname" ${findkey == 'tname' ? 'checked' : ''}> 이름
			<input type="text" name="findvalue" value="${findvalue}">
			<button>조회</button>
		</form>
	</fieldset>
	<div>
		<c:forEach var="plist" items="${plist}">
			타입 코드 : ${plist.tcode} <br>
			타입 네임 : ${plist.tname} <br>
			<button onclick="removecheck('${plist.tcode}')">삭제</button>
			<hr>
		</c:forEach>
	
	</div>
</body>
</html>