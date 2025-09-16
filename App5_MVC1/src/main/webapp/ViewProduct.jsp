<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pack1.ProductBean" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product Data</title>
</head>
<body>
    <%
        // Retrieve the "list" attribute from the request
        ArrayList<ProductBean> al = (ArrayList<ProductBean>) request.getAttribute("list");
        
        // Check if the list is null or empty
        if (al == null || al.size() == 0) {
            out.println("<h1>Data is NOT retrieved</h1>");
        } else {
            // Iterate over the list and display the employee details
            Iterator<ProductBean> i = al.iterator();
            while (i.hasNext()) {
            	ProductBean eb = i.next();
                out.println("<center>");
                out.println("<h1>");
                out.println("Employee ID: " + eb.getpCode() + "<br>");
                out.println("First Name: " + eb.getpName() + "<br>");
                out.println("Last Name: " + eb.getpCompany() + "<br>");
                out.println("Salary: " + eb.getpPrice() + "<br>");
                out.println("Address: " + eb.getpQty() + "<br>");
                out.println("</h1>");
                out.println("</center>");
            }
        }
    %>
</body>
</html>
