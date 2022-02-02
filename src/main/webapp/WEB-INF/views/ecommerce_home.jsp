<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>
<h1>Shop</h1>
<form action="goto_login">login
<input type ="submit">
</form>

<form action="ecomSearch" target="frame">
<input name="name"> 
<input type="submit">
</form>

<iframe name="frame"></iframe>
</body>
</html>