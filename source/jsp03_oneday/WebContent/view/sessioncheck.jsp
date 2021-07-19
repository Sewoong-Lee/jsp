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
<!-- 로그인 체크 -->
<script type="text/javascript">

if('${sessionScope.userid}' == ''){
	var msg = "로그인하셈";
	location.href='${path}/view/login/login.jsp?msg='+msg;
}

</script>