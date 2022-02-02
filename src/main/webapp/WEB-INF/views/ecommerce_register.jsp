<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
<h2>Registrazione</h2>
<form action="ecomRegister" method="post">
	<label>Nome</label><br>
	<input name="name"><br>
	<label>Cognome</label><br>
	<input name="surname"><br>
	<label>Email</label><br>
	<input name="email" type="email"><br>
	<label>Password</label><br>
	<input name="password" type="password"><br>
	<input type="submit" value="Registrati">
</form>

</body>
</html>