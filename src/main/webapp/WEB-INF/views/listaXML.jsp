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
	<c:forEach items="${contatti}" var="contatto">
	<div style="padding: 20px;">
		<h1><c:out value="${contatto.nome}"></c:out></h1>
	</div>
	</c:forEach>
</body>
</html>