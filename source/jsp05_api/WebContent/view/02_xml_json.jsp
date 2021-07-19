<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- contextpath 변수 생성 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function name() {
		
	}


</script>
</head>
<body>
	<h2>국가·지역별 최신안전소식(코로나관련)</h2>
	<form action="${path}/list.country">
		<fieldset>
			국가명<input type="text" name="countryname" > 
			<button>검색</button>
			<button onclick="location.href='${path}/add.country'">db에저장</button>
		</fieldset>
	</form>
	<table border="1">
			<tr>
				<th>안전 아이디</th>
				<th>작성일</th>
				<th>영문 대륙 명</th>
				<th>영문 국가명</th>
				<th>한글 국가 명</th>
				<th>타이틀</th>
				<!-- <th>HTML원본 내용</th> -->
				<!-- <th>파일 다운로드</th> -->
			</tr>
		<c:forEach var="clist" items="${clist}">
			<tr>
				<td>${clist.SFTY_NOTICE_ID}</td>
				<td>${clist.WRT_DT}</td>
				<td>${clist.CONTINENT_ENG_NM}</td>
				<td>${clist.COUNTRY_ENG_NM}</td>
				<td>${clist.COUNTRY_NM}</td>
				<td> <a href="${path}/detail.country?sfty_notice_id=${clist.SFTY_NOTICE_ID}">${clist.TITLE}</a> </td>
				<%-- <td>${clist.HTML_ORIGIN_CN}</td> --%>
				<%-- <td><a href="${clist.file_download_url}">${clist.file_path}</a></td> --%>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>