<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>
<c:choose>
<c:when test="${not empty loggedUser}"> 
Welcome: <c:out value="${loggedUser.getName() } "></c:out>
</c:when>
<c:otherwise>
<form action="goto_login">login
<input type ="submit" value="Login">
</form>
</c:otherwise>
</c:choose>


<h1>Shop</h1>

<form action="ecomSearch" target="frame">
<input name="name"> 
<input type="submit">
</form>

<iframe name="frame"></iframe>

<c:choose>
<c:when test="${not empty product}">
	<form action="ecomAddToOrder">
	<label>Price: </label> 
	${product.price }
	<br>
	<fieldset>
	<legend>Order</legend>
	<label>Amount: </label>
	<input type="number" name="amt" max="${product.getQuantity() }" >
	<br>
	</fieldset>
	</form>
</c:when>

</c:choose>

</body>
</html>