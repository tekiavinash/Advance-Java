<%@page import="java.util.Iterator"%>
<%@page import="pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
				AdminBean abean=(AdminBean)session.getAttribute("abean");
				ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("ProductsList");
				out.println("<u><i>Hello "+abean.getaFname()+" These are your Product Details </u></i><br><br>");
				if(al.size()==0)
				{
					out.println("Products are NOT available!!! <br><br>");
				}
				else
				{
					Iterator<ProductBean> i = al.iterator();
					while(i.hasNext())
					{
						ProductBean pb = i.next();
						out.println(pb.getpCode()+" "+pb.getpName()+" "+pb.getpCompany()+" "+pb.getpPrice()+" "+pb.getpQuantity()+"<a href='edit?pcode="+pb.getpCode()+"'>Edit</a>"+" "+"<a href='delete?pcode="+pb.getpCode()+"'>Delete</a><br><br>");
					}
				}
			%>
			<a href="Logout">Logout</a>
		</h1>
	</center>
</body>
</html>