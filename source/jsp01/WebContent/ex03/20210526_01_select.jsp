<%@page import="ex03.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db접속</title>
</head>
<body>
	<h2>한건 조회</h2>
	<form action="20210526_01_db.jsp">
	아이디 <input type="text" name="userid">
	<!-- hidden: 화면엔 안보이지만 url로 값을 가져갈 수 있다.  -->
	<input type="hidden" name="gubun" value="selectOne">
	<button>조회</button>
	</form>
	
	<div>
		<%if(request.getAttribute("result")!=null){ 
			int result = (int)request.getAttribute("result");
			if(result==0){
				//dto 변환
				MemberDTO mdto = (MemberDTO)request.getAttribute("mdto");
		%>
				<h2>회원 정보</h2>
				<%=mdto.getUserid()%> <br>
				<%=mdto.getPasswd()%> <br>
				<%=mdto.getBirthyear()%> <br>
				<%=mdto.getRegdate()%> <br>
				
				<%-- <%=request.getAttribute("userid")%> <br>
				<%=request.getAttribute("passwd")%> <br>
				<%=request.getAttribute("birthyear")%> <br>
				<%=request.getAttribute("regdate")%> <br> --%>
		<%}else{
		%>
			확인되지 않는 아이디
		<%} 
		} %>
	</div>
</body>
</html>