<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Benvenuto</h1>
<p>Utente: <span style=color:green>${utente.getNome()}</span></p>

<form action="vediProdotti" method="get">
  <input type="submit" value="Vedi prodotti">
</form>

</body>
</html>