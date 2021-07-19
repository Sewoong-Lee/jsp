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
if('${param.msg}' != ''){
	alert('${param.msg}');
}
if('${msg}' != ''){
	alert('${msg}');
}
</script>
</head>
<body>

</body>
</html>