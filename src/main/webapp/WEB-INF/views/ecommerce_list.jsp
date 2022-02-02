<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati</title>
</head>
<body>
<table>
	<tr>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Description</th>
	</tr>
	
	<c:forEach items= "${searchResults }" var="prod">
	<tr>
		<td> <c:out value="${prod.getName() }"/></td>
		<td> <c:out value="${prod.getPrice() }"/></td>
		<td> <c:out value="${prod.getQuantity() }"/></td>
		<td> <c:out value="${prod.getDescription() }"/></td>
		<td>
			<form action="ecomViewProduct" target="">
			<input type="hidden" name="productId" value="${prod.getId() }"> 
			<input type="submit" value="Ordina...">
			</form>
		</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>