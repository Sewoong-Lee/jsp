<%@page import="ex03.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
		//String uri = request.getRequestURI();
		String gubun = request.getParameter("gubun");
	
		//아이디 읽어온거
		String userid = request.getParameter("userid");
		//System.out.println(userid);
		System.out.println(gubun);
		
		//오라클 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("셀렉트 오라클 접속 완료");
		//Connection 은 자바의 spl꺼로
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("셀렉트 컨넥션 완료");
		
		String sql = "SELECT*FROM MEMBER WHERE USERID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs =  pstmt.executeQuery();
		
		//선언 아래로 내림
		//String passwd ="", birthyear="", regdate="";
		if(rs.next()){
			userid = rs.getString("userid");
			String passwd = rs.getString("passwd");
			int birthyear = rs.getInt("birthyear");
			String regdate = rs.getString("regdate");
			//투스트링 출력예정으로 지움
			//System.out.println(passwd + birthyear + regdate);
			request.setAttribute("result", 0);
			
			// dto 선언
			MemberDTO mdto = new MemberDTO(userid, passwd, birthyear, regdate);
			//시험 출력
			System.out.println(mdto);
			//dto 넘김
			request.setAttribute("mdto", mdto);
			
			//dto에 넣을거여서 이제 필요가 없당
			/*request.setAttribute("userid", userid);
			request.setAttribute("passwd", passwd);
			request.setAttribute("birthyear", birthyear);
			request.setAttribute("regdate", regdate); */
		}else{
			System.out.println("데이터가 존재하지 않습니다.");
			request.setAttribute("result", -1);
		}
		//컨넥션 끊기
		rs.close();
		pstmt.close();
		conn.close();
		
		//호출한쪽에 따라 경로 변경
		if(gubun.equals("selectOne")){
			//forward는 절대경로명에서 cintextpath 제외
			request.getRequestDispatcher("/ex03/20210526_01_select.jsp").forward(request, response);
		}else if(gubun.equals("update")){
			request.getRequestDispatcher("/ex03/20210527_04_update.jsp").forward(request, response);
			
		}

	%>
</body>
</html>