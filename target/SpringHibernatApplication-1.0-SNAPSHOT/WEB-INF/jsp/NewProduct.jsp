<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
        <form:form method="POST" modelAttribute="produit" >
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/> <form:errors path="name" cssClass="error"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		      </tr>
	    
			<tr>
				<td><label for="description">descreption: </label> </td>
				<td><form:input path="description" id="description"/></td>
				<td><form:errors path="description" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="prix">Prix: </label> </td>
				<td><form:input path="prix" id="prix"/></td>
				<td><form:errors path="prix" cssClass="error"/></td>
		    </tr>
	
			
	
			<tr>
				<td colspan="3">
					
					
						<c>
							<input type="submit" value="Register"/>
						</c>
					
						
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/' />">List of All Produit</a>
</body>
</html>