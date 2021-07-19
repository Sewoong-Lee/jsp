<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includ/includ.jsp" %>
<%@include file="../header.jsp" %>
<%@include file="../sessioncheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}

</style>
<script type="text/javascript">

	function doardlistgo(e, curpage) {
		e.preventDefault(); //기본이벤트 실행하지 않기
		//하이퍼링크를 클릭해 게시물 조회
		var findkey = listform.findkey.value;
		var findvalue = listform.findvalue.value;
		//alert(findkey+'  '+findvalue+'  '+curpage);
		
		location.href = '${path}/board/list?findkey='+findkey+'&findvalue='+findvalue+'&curpage='+curpage;
		
	}


</script>
</head>
<body>
	<h2>게시물 조회 리스트</h2>
	<form action="${path}/board/list" name="listform">
		<fieldset>
			<legend>검색조건</legend>
			<select name="findkey">
				<option value="userid" ${pdtp.findkey eq 'userid' ? 'selected' : ''}>아이디</option>
				<option value="subject" ${pdtp.findkey eq 'subject' ? 'selected' : ''}>제목</option>
				<option value="content" ${pdtp.findkey eq 'content' ? 'selected' : ''}>내용</option>
				<option value="subcon" ${pdtp.findkey eq 'subcon' ? 'selected' : ''}>제목+내용</option>
			</select>
			<input type="text" name="findvalue" value="${pdtp.findvalue}">
			<button>검색</button>
		</fieldset>
	</form>
	<div>
		<table>
			<tr> 
				<th>번호</th>
				<th>아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>카운트</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="blist" items="${blist}">
			<tr> 
				<td>${blist.BNUM}</td>
				<td>${blist.USERID}</td>
				
				<td>
				<!-- relevel 에 따라 들여쓰기 -->
				<c:forEach begin="1" end="${blist.RELEVEL}">
					&nbsp;&nbsp;
				</c:forEach>
				<c:if test="${blist.RELEVEL != 0}">
					""
				</c:if>
				
				
				<a href="${path}/board/detail?bnum=${blist.BNUM}"><c:out value="${blist.SUBJECT}"/></a>
				</td>
				<!-- c:out : 자바 스크립트를 내용에 적을시 작동을 막아주는 -->
				<td>${blist.CONTENT}</td>
				<td>${blist.READCOUNT}</td>
				<td>${blist.REGDATE}</td>
			</tr>
			</c:forEach>
		</table>
		</div>
	<div class="pagination">
	<c:if test="${pdtp.startpage != 1}">
		<a href="" onclick="doardlistgo(event,${pdtp.startpage-1})">&laquo;</a>
	</c:if>
	
	<c:forEach var="i" begin="${pdtp.startpage}" end="${pdtp.endpage}">
		<c:if test="${pdtp.curpage == i}">
		<a class="active" href="" onclick="doardlistgo(event,${i})">${i}</a>
		</c:if>
		<c:if test="${pdtp.curpage != i}">
		<a id="" href="" onclick="doardlistgo(event,${i})">${i}</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${pdtp.totpage > pdtp.endpage}">
		<a href="" onclick="doardlistgo(event,${pdtp.endpage+1})">&raquo;</a>
	</c:if>
	</div>
	
</body>
</html>