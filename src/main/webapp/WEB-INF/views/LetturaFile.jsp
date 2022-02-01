<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Percorso File</title>
</head>
<body>
<h1>Inserisci File</h1>

<form action="rubricaTipo" method="get">
  <label>Percorso File:</label><br>
  <input type="text" name="pathFile"><br>
  <input type="radio" name="button" value="CSV">
  <label>CSV</label><br><br>
  <input type="radio" name="button" value="XML">
  <label>XML</label><br><br>
  <input type="submit" value="Invia"></input>
</form> 

</body>
</html>