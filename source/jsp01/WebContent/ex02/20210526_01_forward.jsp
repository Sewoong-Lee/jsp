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
		//1부터 n까지의 합 //다시 1번 창에 보내기
		String n = request.getParameter("nvalue");	
	
		if(!n.equals("")){
			int value = Integer.parseInt(request.getParameter("nvalue"));
			int sum=0;
	 		for(int i=0;i<value+1;i++){
	 			sum += i;
			}
			//System.out.println(sum);
			request.setAttribute("value", value);
			request.setAttribute("sum", sum);
		}else{ //공백이면(자바스크립트로도 함)
			request.setAttribute("sum", 0);
		}
		//System.out.println(value);
		
		request.getRequestDispatcher("20210526_01_asum.jsp").forward(request, response);
	%>

</body>
</html>