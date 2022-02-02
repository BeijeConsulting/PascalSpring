<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body align="center">
<h1> Register </h1>
	<form action="register" method="POST" align="center">
		<label>email:</label><br> 
		<input type="text" name="email"><br> 
		<label>name:</label><br> 
		<input type="text" name="name"><br> 
		<label>surname:</label><br> 
		<input type="text" name="surname"><br> 
		<label>password:</label><br>
		<input type="password" name="password"><br> <br> 
		<input type="submit" value="Register" name="Register">
	</form>
	<br>
	<form action="login" method="GET" align="center">
		<input type="submit" value="Login" name="Login">
	</form>
</body>
</html>