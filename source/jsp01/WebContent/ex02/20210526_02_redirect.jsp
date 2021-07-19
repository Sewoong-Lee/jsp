<%@page import="java.net.URLEncoder"%>
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
		//판매 금액 계산
		//post 한글 출력 방식 변경 (시험 출력 위하여(콘솔창 출력))
		//가져오기 전에 제일 첫줄에 해줘야함
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("name");
		String price2 = request.getParameter("price");
		String seq2 = request.getParameter("seq");
		System.out.println(name);
		int sum = 0;
		if(!name.equals("")&&!price2.equals("")&&!seq2.equals("")){
			int price = Integer.parseInt(request.getParameter("price"));
			int seq = Integer.parseInt(request.getParameter("seq"));
			//변수 생성
			sum = price*seq;
			//request.setAttribute("sum", sum);
			//request.setAttribute("name", name);
		}else{
			//request.setAttribute("sum", 0);
			//request.setAttribute("name", "미입력");
		}
		//포워드 이동
		//주소 변경이 안됨(포워드에서 멈춤), 대량의 데이터 전송 가능
		//request.getRequestDispatcher("20210526_02_itemSales.jsp").forward(request, response);
		
		//redirect방식 이동
		//주소가 변경(하이퍼링크처럼 이동)
		//인코딩 방식이 맞지 않아 url 인코딩방식 변경 (application/x-www-form-urlencoded로)
		name = URLEncoder.encode(name,"utf-8");
		response.sendRedirect("20210526_02_itemSales.jsp?name="+name+"&sum="+sum);
	%>
</body>
</html>