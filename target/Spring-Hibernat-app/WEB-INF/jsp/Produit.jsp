<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>springandhibernat</title>


</head>


<body>
	<h2>List of Prodoct</h2>	
	
        
        <table border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>NOM</th>
			<th>DESCRIPTION</h>
			<th>PRIX</th>
			<th>Option</th>
		</tr>
		
		<!--  listeProduit  -->
		<c:forEach items="${produit}" var="o" >
			<tr>
				<td>${o.id }</td>
				<td>${o.name }</td>
				<td>${o.description }</td>
				<td>${o.prix }</td>
				<td><a href="<c:url value='/delete-${o.name}-employee' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>