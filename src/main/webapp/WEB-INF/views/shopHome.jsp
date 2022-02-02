<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop Home</title>
</head>
<body align="center">
<h1>lista prodotti</h1>
<table border=2 align="center">
    <tr>
        <th>NAME</th>
        <th>DESCIPTION</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
    </tr>
    <c:forEach items="${products}" var="prod">
    <tr>
        <td>
            <c:out value="${prod.name}" />
        </td>
        <td>
            <c:out value="${prod.description}" />
        </td>
        <td>
            <c:out value="${prod.price}" />
        </td>
        <td>
            <c:out value="${prod.quantity}" />
        </td>
        <td>
            <form action="" method="post">
            	<input type="hidden" value="${prod.id}" name="id"> 
            	<input type="submit" value="Elimina">
            </form>
        </td>
        <td>
            <form action="" method="GET">
            	<input type="hidden" value="${prod.id}" name="id"> 
            	<input type="submit" value="Update">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>