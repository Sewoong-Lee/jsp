<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//로그인 성공 여부
		String dbid = "java";
		String dbpasswd = "1111";
		// 일치하면 로그인 성공
		//불일치면 로그인 실패
		//결과창에 전송하고 출력
		//결과창 이동시 forward방식 이동
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
 		if(id.equals(dbid)&&pass.equals(dbpasswd)){
 			request.setAttribute("id", id);
 			request.setAttribute("msg", "님 환영합니다.");
 			request.setAttribute("result", 0);
		}else{
			request.setAttribute("id", id);
			request.setAttribute("msg", "로그인 확인 불가");
			request.setAttribute("result", -1);
		}
 		//절대경로 만들기 (얘는 컨텍스트 패스를 빼야함)
 		//자바 코드이며 같은 프로젝트로만 이동 가능하므로
 		//절대경로 : contextpath제외
 		request.getRequestDispatcher("/ex02/20210525_08_result.jsp").forward(request, response);
	%>

</body>
</html>