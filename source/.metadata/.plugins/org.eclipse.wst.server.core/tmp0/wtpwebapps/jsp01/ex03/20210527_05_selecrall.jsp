<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ex03.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="document.getElementsByName('findvalue').focus()">
	<form action="20210527_05_db.jsp">
	<h2>회원 전제 조회</h2>
	조회 조건 <br>
	<fieldset>
	<select name="findkey">
	<%
		System.out.print("파인드키다시받기"+request.getAttribute("findkey"));
		String findKey = (String)request.getAttribute("findkey");
		if(findKey==null) findKey="birthyear";
		if(findKey.equals("userid")){
	%>
		<!-- 옵션을 벨류는 db의 필드명과 같게 해주는게 편함 -->
		<option value="userid" selected>아이디</option>
		<option value="birthyear">출생년도</option>
	<%
		}else if(findKey.equals("birthyear")){
	%>
		<option value="userid">아이디</option>
		<option value="birthyear" selected>출생년도</option>
	<%
		}
		%>
	</select>
	<%
		//findvalue : null체크
		//System.out.print("체크"+request.getAttribute("findvalue"));
		String findValue = (String)request.getAttribute("findvalue");
		if (findValue==null) findValue = "";
	%>
	<input type="text" name="findvalue" value="<%=findValue %>">
	<button>조회</button>
	</fieldset>
	</form>
	<div>
	<h2>전체 멤버</h2>
	<table>
	<tr>
		<td>아이디</td>
		<td>생년월일</td>
		<td>가입일</td>
	</tr>
	<%
		if(request.getAttribute("mlist") != null){
			List<MemberDTO> mlist = (List<MemberDTO>)request.getAttribute("mlist");
			for(int i=0;i<mlist.size();i++){
				//MemberDTO mdto = mlist.get(i);
	%>
	<tr>
		<td><%=mlist.get(i).getUserid()%></td>
		<td><%=mlist.get(i).getBirthyear()%></td>
		<td><%=mlist.get(i).getRegdate()%></td>
	</tr>
	<%-- <table>
		<tr>
			<th>아이디 </th>
			<td> <%=mlist.get(i).getUserid()%> </td>
		</tr>
		<tr>
			<th>비밀번호 </th>
			<td> <%=mlist.get(i).getPasswd()%> </td>
		</tr>
		<tr>
			<th>생년월일 </th>
			<td> <%=mlist.get(i).getBirthyear()%> </td>
		</tr>
		<tr>
			<th>가입일 </th>
			<td> <%=mlist.get(i).getRegdate()%> </td>
		</tr>
	</table>
	<hr> --%>
	<% 
		}
	} %>
	</table>
	</div>
</body>
</html>