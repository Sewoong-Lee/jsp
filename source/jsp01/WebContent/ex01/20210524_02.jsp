<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
주석 단축키 : 컨트롤 쉬프트 /
	주석 해제 : 컨트롤 쉬프트 \
	hello!!!! <br>
	
	<!-- 스크립틀릿 : 자바코드 블록 < % % > -->
	<%
		// 주석을 풀려면 역슬레시
		/* jsp 문법 시작 */
		/* jsp는 was 동적으로 파일을 생성해서 응답 */
		out.println("안뇽하쉐요 센푸란쉬스코 콰트룹 이에효<br>");
	
	%>

<!-- 이름과 나이를 변수에 저장하고 웹 브라우져에 출력 -->
	<%
		String name = "홍홍";
		int age = 30;
		//System.out.println(name + age);
		//시스템 아웃은 콘솔창임
		out.println(name + age +"<br>");
		out.println(name + age);
	%>

</body>
</html>