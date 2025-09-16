<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>
			Invalid Data<br><br>
			<%= exception %> <!-- experssion tag -->
		</h1>
	</center>
	<%@ include file="input.html" %>
</body>
</html>