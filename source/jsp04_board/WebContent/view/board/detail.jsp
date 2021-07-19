<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includ/includ.jsp" %>
<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#replyList {
		display: flex;
		
	}

</style>
</head>
<body>
	<h2>디테일</h2>
	순번 ${bmap.BNUM} <br>
	조회수 ${bmap.READCOUNT} <br>
	아이디 ${bmap.USERID} <br>
	제목 <c:out value="${bmap.SUBJECT}"/> <br> <!-- c:out : 자바스크립트를 자체적으로 적을시 작동 막기 -->
	내용 ${bmap.CONTENT} <br>
	파일 ${bmap.FILENAME}
	<img alt="" src="/img/${bmap.FILENAME}" width="80" > <br>
	작성일 ${bmap.REGDATE} <br>
	수정일 ${bmap.MODIFYDATE} <br>
	<hr>
	<button onclick="location.href='${path}/board/modifyform?bnum=${bmap.BNUM}'">수정</button>
	<button onclick="location.href='${path}/board/delete?bnum=${bmap.BNUM}'">삭제</button>
	<a href="${path}/view/board/reply.jsp?ref=${bmap.REF}&restep=${bmap.RESTEP}&relevel=${bmap.RELEVEL}">댓글</a>
	<hr>
	
	
	댓글들
	<c:forEach var="reply" items="${replylist}">
		<div id="replyList">
		<!-- relevel 에 따라 들여쓰기 -->
		<div style="width:${reply.relevel}*50 ">
			<c:forEach begin="1" end="${reply.relevel}">
				&nbsp;&nbsp;
			</c:forEach>
		</div>
			
		<div>
			아이디 : ${reply.userid}  <br>		
			제목 : ${reply.subject} <br>		
			내용 : ${reply.content} <br>
			등록일자 : ${reply.regdate} <br>
			수정일자 : ${reply.regdate} <br>
			<button onclick="location.href='${path}/reply/modifyform?bnum=${reply.bnum}&ref=${reply.ref}'">수정</button>
			
			<button onclick="location.href='${path}/reply/delete?bnum=${reply.bnum}&ref=${reply.ref}'">삭제</button>
			
			<a href="${path}/view/board/reply.jsp?ref=${reply.ref}&restep=${reply.restep}&relevel=${reply.relevel}">댓글</a>
		</div>
		
		</div>
		<hr>
	</c:forEach>
</body>
</html>