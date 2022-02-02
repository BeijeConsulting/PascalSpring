<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

<h1> Lista dei Prodotti</h1>

<c:forEach items="${list}" var="Product">
         ID: <c:out value = "${Product.getId()}"/><p>
         Nome: <c:out value = "${Product.getName()}"/><p>
         Descrizione: <c:out value = "${Product.getDescription()}"/><p>
         Prezzo: <c:out value = "${Product.getPrice()}"/><p>
         Quantità: <c:out value = "${Product.getQuantity()}"/><p>
</c:forEach>

</body>
</html>