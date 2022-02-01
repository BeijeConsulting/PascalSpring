<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pascal Spring</title>
</head>
<body>

Ciao ${name}!

<form action="rubrica" method="post">
  <label>fname:</label><br>
  <input type="text" name="fname"><br>
  <label>lname:</label><br>
  <input type="text" name="lname2"><br><br>
  <input type="submit" value="Submit">
</form> 

<br><hr><br>

<form action="rubrica" method="post">
  <label>Path del file CSV da leggere:</label><br>
  <input type="text" name="path"><br><br>
  
  <input type="submit" value="Submit">
</form>

<br><hr><br>

<form action="database" method="get">
  <label>Vuoi vedere tutti i contatti della rubrica?</label><br><br>
  
  <input type="submit" value="Vedi">
</form>

</body>
</html>