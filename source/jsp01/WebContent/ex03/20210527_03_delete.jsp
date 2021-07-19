<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
/* 	function del() {
			alert('전부 입력 해주세요');
			String userid = delform.userid.value;
			if(userid==''){
				alert('전부 입력 해주세요');
			}else{
				delform.submit();
			}
		} */

		if('<%=request.getParameter("msg")%>' !='null'){
			alert('<%=request.getParameter("msg")%>');
		}
		function deletecheck() {
			//입력값 확인
			var userid = document.getElementById('userid').value;
			//alert(userid);
			
			//삭제 여부 확인
			var re = confirm(userid+'정말 삭제하시겠습니까?');
			//alert(re);
			
			//확인이 트루면 진행
			if(confirm){
				location.href='20210527_03_db.jsp?userid='+userid;
			}
		}
	
	</script>
</head>
<body>
	<h2>아이디 삭제</h2>
	<!-- 하나의 정보만을 보낼때 속도를 위해 폼을 안써보자 -->
	<!-- <form name = "delform" action="20210527_03_db.jsp"> -->
	아이디 <input type="text" name="userid" id="userid">
	<button onclick="deletecheck()">확인</button>
	<!-- </form> -->
	
	<div>
	<%=request.getParameter("msg")%>
	
	
	</div>
</body>
</html>