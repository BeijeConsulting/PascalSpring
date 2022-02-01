<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizzatore Rubrica</title>
</head>
<body>

<h1> VISUALIZZATORE RUBRICA </h1>

<c:forEach items="${rub}" var="Contatto">
         ID: <c:out value = "${Contatto.getId()}"/><p>
         Cognome: <c:out value = "${Contatto.getCognome()}"/><p>
         Nome: <c:out value = "${Contatto.getNome()}"/><p>
         Telefono: <c:out value = "${Contatto.getTelefono()}"/><p>
         Email: <c:out value = "${Contatto.getEmail()}"/><p>
         Note: <c:out value = "${Contatto.getNote()}"/><p>
</c:forEach>

<form action= "xml" method= "get">
	<input type= "submit" value= "Torna alla Pagina di Scelta">
</form>

</body>
</html>