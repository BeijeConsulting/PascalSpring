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
	<form action="webInsertContatto" method="post">
		<label>nome:</label><br> <input type="text" name="nome"><br>
		<label>cognome:</label><br> <input type="text" name="cognome"><br>
		<label>email:</label><br> <input type="text" name="email"><br>
		<label>telefono:</label><br> <input type="text" name="telefono"><br>
		<label>note:</label><br> <input type="text" name="note"><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>