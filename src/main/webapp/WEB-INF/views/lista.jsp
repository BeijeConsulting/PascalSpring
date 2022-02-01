<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RUBRICA</title>
</head>
<body>
Questi i contatti:<br>
<br>
<c:choose>
	<c:when test="${empty contatto}">NESSUN CONTATTO</c:when>
	<c:otherwise>${contatto.nome}&nbsp;${contatto.cognome}</c:otherwise>
</c:choose>
<br>

<h2>Filtri</h2>
<form action=""></form>

<br>
<c:forEach items= "${listaContatti }" var="i">
	<c:out value="${i.toString() }"/><br>
</c:forEach>

</body>
</html>