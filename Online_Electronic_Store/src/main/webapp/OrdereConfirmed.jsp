<%@page import="pack1.ProductBean"%>
<%@page import="pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderConfirmed</title>
</head>
<body>
	<center><h1>
		<%
			CustomerBean cbean = (CustomerBean)session.getAttribute("cbean");
			ProductBean pbean = (ProductBean)session.getAttribute("pbean");	
		
			String pPrice = (String)request.getParameter("pPrice");
			String rqno = (String)request.getParameter("rqNo");
			
			if (pPrice == null || rqno == null) 
			{
			    out.println("Values should not be null <br><br>");
			} 
			else 
			{
			    try {
			        int pPrice1 = Integer.parseInt(pPrice);
			        int rqno1 = Integer.parseInt(rqno);

			        int amount = pPrice1*rqno1;
					out.println("Hello "+cbean.getuFirstName()+"<br><br>");
					out.println("You have charged "+ amount+" /rs<br><br>");
					out.println("Your order is placed successfully!!!"+"<br><br>");

			    } 
			    catch (NumberFormatException e) 
			    {
			        out.println("Invalid Input");
			    }
			}			
		%>
		<a href="view2">View Products</a><br><br>
		<a href="Logout1">Logout</a>
</body>
</html>