<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page errorPage="Error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!    /* declaration tag */
		int findFactorial(int x)
		{
			int fact = 1;
			for(;x>=1;x--)
				fact = fact*x;
			return fact;
		}
	%>
	<%
		int i = Integer.parseInt(request.getParameter("num"));
		int result = findFactorial(i);
		out.println("<center><h1>Factorial is : "+result+"</h1></center><br>");
	%>
	<%@ include file="input.html" %>
</body>
</html>