<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- contextpath 변수 생성 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코로나 확진자 현황</title>
<script type="text/javascript">
	function covidadd() {
		var startdate = covidform.startdate.value;
		var enddate = covidform.enddate.value;
		//alert(startdate);
		
		location.href='${path}/add.do?startdate='+startdate+'&enddate='+enddate;
		
	}

	if('${param.msg}' != ''){
		alert('${param.msg}');
	}

</script>
</head>
<body>
	<h2>코로나 확진자 현황</h2>
	<form name="covidform" action="${path}/selectlist.do">
	<fieldset>
		검색날짜<input type="date" name="startdate" value="${startdate}"> 
						~ <input type="date" name="enddate" value="${enddate}">
		<button>검색</button>
		<button type="button" onclick="covidadd()">db생성</button>
	</fieldset>
	</form>
		<table border="1">
			<tr>
				<th>기준일</th>
				<th>확진자수</th>
				<th>일일 확진자</th>
				<th>격리해제수</th>
				<th>검사진행수</th>
				<th>사망자수</th>
				<th>치료중환자수</th>
				<th>결과음성수</th>
				<th>누적검사수</th>
				<th>누적검사완료수</th>
				<th>누적확진률</th>
			</tr>
			<c:forEach var="covidlist" items="${clist}">
			<tr>
				<td>${covidlist.stateDt}</td>
				<td>${covidlist.decideCnt}</td>
				<td>${covidlist.diffcnt}</td>
				<td>${covidlist.clearCnt}</td>
				<td>${covidlist.examCnt}</td>
				<td>${covidlist.deathCnt}</td>
				<td>${covidlist.careCnt}</td>
				<td>${covidlist.resutlNegCnt}</td>
				<td>${covidlist.accExamCnt}</td>
				<td>${covidlist.accExamCompCnt}</td>
				<td>${covidlist.accDefRate}</td>
			</tr>
			</c:forEach>
		</table>

</body>
</html>