<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includ.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delcheck(mcode) {
		//alert(mcode);
		if(confirm('정말 삭제?')){
			location.href="${path}/delet.monster?mcode="+mcode;
		}
	}

</script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>포켓몬 등록</h2>
	<form action="${path}/update.monster">
			타입 코드 
			<select name="tcode">
				<c:forEach var="plist" items="${plist}">
					<c:if test="${plist.tcode == mdto.tcode}">
					<option value="${plist.tcode}" selected="selected">${plist.tcode} ${plist.tname}</option>
					</c:if>
					<c:if test="${plist.tcode != mdto.tcode}">
					<option value="${plist.tcode}">${plist.tcode} ${plist.tname}</option>
					</c:if>
				</c:forEach>
			</select> <br>
			포켓몬 코드 <input type="text" name="mcode" readonly value="${mdto.mcode}"> 수정불가 <br>
			포켓몬 이름 <input type="text" name="mname" value="${mdto.mname}"> <br>
			<button>수정</button>
			<button type="button" onclick="delcheck(${mdto.mcode})">삭제</button>
			<%-- <button onclick="location.href='${path}/delet.monster?mcode=${mdto.mcode}'">바로 삭제</button> --%>
	</form>

</body>
</html>