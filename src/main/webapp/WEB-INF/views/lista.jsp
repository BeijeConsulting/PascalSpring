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
<%-- c:if test="${empty contatto}">NESSUN CONTATTO</c:if --%>
	
	
	
<form action="rubrica" method="post">
	<label for="type">scegli il tipo di file che vuoi leggere</label>
	<input type="text" name="type" />
	
	<input type="submit" value="Invia" />
</form>

</body>
</html>