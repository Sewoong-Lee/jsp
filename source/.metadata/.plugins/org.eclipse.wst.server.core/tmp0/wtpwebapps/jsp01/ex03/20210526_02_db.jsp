<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.SQLIntegrityConstraintViolationException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		//가입 데이터 읽기
		//포스트로 쓸거면 문자형 바꿔야댕
		//request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		int birthyear = Integer.parseInt(request.getParameter("birthyear"));
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("오라클 접속 완료");
		
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("컨넥션 완료");
		String msg=" ";
		PreparedStatement pstmt = null;
		
		try{
		String sql ="INSERT INTO MEMBER (USERID,PASSWD,BIRTHYEAR)  VALUES (?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userid);
		pstmt.setString(2, passwd);
		pstmt.setInt(3, birthyear);
		
		
		int rs = pstmt.executeUpdate();
		msg = "가입 완료";
		
		//이건 포워드 할떄 쓰는거
		request.setAttribute("rs", rs);
		request.setAttribute("userid", userid);
		request.setAttribute("passwd", passwd);
		request.setAttribute("birthyear", birthyear);
		
		//중복 에러 캐치
		}catch(SQLIntegrityConstraintViolationException e){
			System.out.println("중복된 아이디");
			msg = "중복된 아이디 입니다.";
			request.setAttribute("msg", msg);
		}
		//(리스펀스방식)다른 프로젝트로도 이용 가능
		msg = URLEncoder.encode(msg,"utf-8");
		response.sendRedirect("/jsp01/ex03/20210526_02_insert.jsp?msg="+msg);
		
		//request.getRequestDispatcher("20210526_02_insert.jsp").forward(request, response);
		
		//연결 해제
		if(conn!=null){
			conn.close();
		}if(pstmt!=null){
			pstmt.close();
		}
	%>

</body>
</html>