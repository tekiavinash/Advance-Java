<%@page import="pack1.ProductBean"%>
<%@page import="pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product Details</title>
</head>
<body>
	<center>
		<h1>Update Product Details</h1>
		<%	
			CustomerBean cbean = (CustomerBean)session.getAttribute("cbean");
			ProductBean pb = (ProductBean)request.getAttribute("pbean");
		%>
		<form action="Buy" method="post">
			Product code : <input type="text" name="pcode" value="<%=pb.getpCode() %>"><br><br>
			Product Name : <input type="text" name="pname" value="<%=pb.getpName() %>" readonly><br><br>
			Product Company : <input type="text" name="pcompany" value="<%=pb.getpCompany() %>" readonly><br><br>
			Product price : <input type="text" name="pPrice" value="<%=pb.getpPrice() %>" readonly><br><br>
			Product Quantity : <input type="text" name="pqty" value="<%=pb.getpQuantity() %>"><br><br>
			Required No : <input type="text" name="rqNo"><br><br>
			
			<input type="submit" value="Buy">
		</form>
	</center>
</body>
</html>