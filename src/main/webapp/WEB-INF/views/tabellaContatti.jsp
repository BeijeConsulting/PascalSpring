<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Note</th>
		</tr>

		<c:forEach items="${listaContatti }" var="c" >
		<tr>
			<td><c:out value="${c.getId()}"/></td>
			<td><c:out value="${c.getNome()}"/></td>
			<td><c:out value="${c.getCognome()}"/></td>
			<td><c:out value="${c.getTelefono()}"/></td>
			<td><c:out value="${c.getEmail()}"/></td>
			<td><c:out value="${c.getNote()}"/></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>