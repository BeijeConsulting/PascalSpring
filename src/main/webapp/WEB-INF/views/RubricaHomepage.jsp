<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubrica homepage</title>
</head>
<body>	
	<table>
    <!-- here should go some titles... -->
    <tr>
        <th>NOME</th>
        <th>COGNOMR</th>
        <th>EMAIL</th>
        <th>TELEFONO</th>
        <th>NOTE</th>
    </tr>
    <c:forEach items="${contatti}" var="contatto">
    <tr>
        <td>
            <c:out value="${contatto.nome}" />
        </td>
        <td>
            <c:out value="${contatto.cognome}" />
        </td>
        <td>
            <c:out value="${contatto.email}" />
        </td>
        <td>
            <c:out value="${contatto.telefono}" />
        </td>
        <td>
            <c:out value="${contatto.note}" />
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>