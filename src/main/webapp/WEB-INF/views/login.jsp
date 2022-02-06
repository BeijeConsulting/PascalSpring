<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="home" action="GET">
		<input type="submit" value="Home" />
	</form>

<form action="login" method="post">
<fieldset >
<legend>login</legend>
	  <label for="email">Email:</label><br>
	  <input type="text" name="email"><br>
	  <label for="password">password:</label><br>
	  <input type="password" name="password"><br><br>
	  <input type="submit" value="Submit">
</fieldset>
</form>

</body>
</html>