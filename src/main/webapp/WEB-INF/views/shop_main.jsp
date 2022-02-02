<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MiniShop</title>
</head>
<body>

<H1>BENVENUTO NEL NEGOZIO</H1>

<form action="login" method="get">
  <label>Premere qui per effettuare il login:</label>
  <input type="submit" value="Login">
</form>

<br>
<br>

<form action="list" method = "post">
	<label>Premere qui vedere l'elenco dei prodotti:</label>
	<input type="submit" value="elenco">
</form>



</body>
</html>