<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>
			<%
				session.invalidate();
				out.println("Logged Out Successfully <br><br>");
			%>
			<jsp:include page="AdminLogin.html"/>
			<!-- <a href="index.html">Login Page</a> -->
		</h1>
	</center>
</body>
</html>