<%@page import="pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
/*<style>
body {
    font-family: sans-serif;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    margin: 0;
}

center {
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
    width: 300px; /* Adjust width as needed */
    text-align: center;
}

h1 {
    color: #333;
    margin-bottom: 20px;
}

a {
    display: block;
    padding: 10px 15px;
    margin: 10px 0;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 14px;
    transition: background-color 0.3s;
}

a:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
	<center>
		<h1>
			<%
				CustomerBean cbean = (CustomerBean)session.getAttribute("cbean");
				out.println("Wlecome Mr. "+cbean.getuFirstName()+"!!!<br><br>");
			%>
			<a href="view2">View Product</a><br>
			<a href="Logout1">Logout</a>
		</h1>
	</center>
</body>
</html>