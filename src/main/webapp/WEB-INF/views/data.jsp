<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visual</title>
</head>
<body>

<h1> ELENCO FUNZIONALITA' </h1>
<form action="data" method="post">
	<input type="submit" value="Stampa la Rubrica dal DB">
</form>
<br>
<br>
<form action= "csv" method="post">
	<input type="submit" value="Stampa la Rubrica da un File CSV">
</form>

<br>
<br>
<form action= "xml" method= "post">
	<input type= "submit" value= "Stampa la Rubrica da un File XML">
</form>



</body>
</html>