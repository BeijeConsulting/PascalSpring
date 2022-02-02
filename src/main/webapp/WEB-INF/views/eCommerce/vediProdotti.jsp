<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Ecco i prodotti in vendita</h2>

<c:forEach items="${prodotti}" var="Product">
         ID: <c:out value = "${Product.getId()}"/><p>
         Name: <c:out value = "${Product.getName()}"/><p>
         Description: <c:out value = "${Product.getDescription()}"/><p>
         Price: <c:out value = "${Product.getPrice()}"/><p>
         Quantity: <c:out value = "${Product.getQuantity()}"/>
         
         <form action="carrello" method="get">
         <label style="font-weight:bold; color:#555">Quanti pezzi vuoi acquistare?</label>
         <input type="number" name="quantity">
         <input type="hidden" name="idProdotto" value="${Product.getId()}">
         <input type="hidden" name="prezzo" value="${Product.getPrice()}">
         <input type="submit" value="carrello">
         </form>
         <hr>
</c:forEach>

</body>
</html>