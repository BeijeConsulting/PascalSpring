<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registrati</h1>
	<form action="registration" method="post">
		<label> Nome: <input type="text" name="nome"></label>
		<label> Cognome: <input type="text" name="cognome"></label>
		<label> Email: <input type="text" name="email"></label> 
		<label> Password: <input type="text" name="password"></label>
		<input type="submit" value="submit">
	</form>
</body>
</html>