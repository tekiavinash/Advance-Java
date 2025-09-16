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
				String data = (String)request.getAttribute("msg");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,data);
				
			%>
			<%= data %><br><br>
			<a href="AddProduct.html">Add Product</a><br><br>
			<a href="view1">View Products</a><br><br>
			<a href="Logout">Logout</a><br><br>
		</h1>
	</center>
</body>
</html>