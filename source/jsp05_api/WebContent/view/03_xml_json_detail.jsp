<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr>
				<th>안전 아이디</th>
				<th>작성일</th>
				<th>영문 대륙 명</th>
				<th>영문 국가명</th>
				<th>한글 국가 명</th>
			</tr>
			<tr>
				<td>${cmap.SFTY_NOTICE_ID}</td>
				<td>${cmap.WRT_DT}</td>
				<td>${cmap.CONTINENT_ENG_NM}</td>
				<td>${cmap.COUNTRY_ENG_NM}</td>
				<td>${cmap.COUNTRY_NM}</td>
			</tr>
			<tr>
				<th colspan="5">타이틀</th>
			</tr>
			<tr>
				<td colspan="5"> ${cmap.TITLE}</td>
			</tr>
			<tr>
				<td colspan="5"> ${cmap.HTML_ORIGIN_CN}</td>
			</tr>
 			<tr>
				<th colspan="5">다운로드 파일</th>
			</tr>
			<tr>
				<td colspan="5"><a href="${cmap.FILE_DOWNLOAD_URL}">${cmap.FILE_PATH}</a></td>
			</tr>
	</table>
</body>
</html>