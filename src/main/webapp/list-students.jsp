<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.demo.jdbc.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>

</head>
  <%
    	List<Student> students=(List<Student>) request.getAttribute("Students-list");
  %>
<body>
<table border="1">
<tr>
	<th>ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email Address</th>
	
</tr>
  
    	<%
    		for(Student tempStudent : students){
    	%>
    <tbody>	
    	<tr>
    	<td><%= tempStudent.id %>
    	<td><%= tempStudent.firstname %></td>
    	<td><%= tempStudent.lastname %></td>
    	<td><%= tempStudent.email %></td>
    	
    	</tr>
    	</tbody>
    	<%} %>
    	</table>
    	
</body>
</html>