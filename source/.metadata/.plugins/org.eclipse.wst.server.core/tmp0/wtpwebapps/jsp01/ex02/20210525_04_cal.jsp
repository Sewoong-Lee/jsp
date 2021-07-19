<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function gocal() {
			var one = calform.one.value;
			var two = calform.two.value;
			//alert(one);
			location.href='20210525_04_calresult.jsp?one='+one+'&two='+two;
		}
	</script>
</head>
<body>
	<form name="calform" action="20210525_04_calresult.jsp">
		<h2>계산시</h2>
		<input type="number" name="one">
		<input type="number" name="two">
		<input type="submit" value="계산(submit)">
	</form>
	
	<input onclick="gocal()" type="button" value="그냥버튼">
</body>
</html>