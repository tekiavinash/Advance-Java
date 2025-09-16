<%@page import="java.util.Iterator"%>
<%@page import="pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pack1.CustomerBean"%>
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
				CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
				ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("ProductsList");
				out.println("<u><i>Hello "+cbean.getuFirstName()+"</u></i><br><br>");
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
						out.println(pb.getpCode()+" "+pb.getpName()+" "+pb.getpCompany()+" "+pb.getpPrice()+" "+pb.getpQuantity()+"<a href='buy?pcode="+pb.getpCode()+"'> Buy</a>"+"<br><br>");
					}
				}
			%>
			<a href="Logout1">Logout</a>
		</h1>
	</center>
</body>
</html>