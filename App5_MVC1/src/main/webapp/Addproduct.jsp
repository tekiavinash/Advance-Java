<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>
			<%
				String data = (String)request.getAttribute("msg");
				out.println(data);
				out.println("<br><br>");
			%>
			 <a href="addProduct.html">Add Product Details</a><br><br>
        	 <a href="View">View Product Details</a>
		</h1>
	</center>
</body>
</html>