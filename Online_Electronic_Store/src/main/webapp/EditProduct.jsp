<%@page import="pack1.ProductBean"%>
<%@page import="pack1.AdminBean"%>
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
				AdminBean abean = (AdminBean)session.getAttribute("abean");
				ProductBean pb = (ProductBean)request.getAttribute("pbean");
				out.println("Hello "+abean.getaFname()+" "+pb.getpName()+" these are the product details available for edit");						
			%>
			
			<form action="update" method="post">
				Product Price : <input type="text" name="pPrice" value="<%=pb.getpPrice() %>"><br><br>
				Product Quantity : <input type="text" name="pQty" value="<%=pb.getpQuantity() %>"><br><br>
				<input type="hidden" name="pCode" value="<%=pb.getpCode() %>">
				<input type="submit" value="Update">
			</form>
		</h1>
	</center>
</body>
</html>