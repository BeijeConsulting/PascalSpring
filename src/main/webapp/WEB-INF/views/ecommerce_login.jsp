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
<h1 align="center">Login</h1>
<div align="center">
<form action="ecomLogin" method="post">
<fieldset >
<legend>login</legend>
	  <label for="email">username:</label><br>
	  <input type="text" name="email"><br>
	  <label for="password">password:</label><br>
	  <input type="password" name="password"><br><br>
	  <input type="submit" value="Submit">
</fieldset>
</form>
</div>
</body>
</html>