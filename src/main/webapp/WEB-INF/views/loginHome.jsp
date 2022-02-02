<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body align="center">
<h1> Login </h1>
	<form action="login" method="POST" align="center">
		<label for="username">email:</label><br> 
		<input type="text" name="email"><br> 
		<label for="password">password:</label><br>
		<input type="text" name="password"><br> <br> 
		<input type="submit" value="Login" name="Login">
	</form>
	<br>
	<form action="register" method="GET" align="center">
		<input type="submit" value="Register" name="Register">
	</form>
	<br>
</body>
</html>