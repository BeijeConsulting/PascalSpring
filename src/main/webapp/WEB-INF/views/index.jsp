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

<form action="hello" method="post">
  <label>fname:</label><br>
  <input type="text" name="fname"><br>
  <label>lname:</label><br>
  <input type="text" name="lname2"><br><br>
  <input type="submit" value="Submit">
</form> 
<br>
<form action="rubricaTipo" method="post">
  <label>Vedi Contatti Rubrica da File</label><br><br>
  <input type="submit" value="Vedi">
</form>

<br>
<form action="database" method="get">
  <label>Vedi Contatti Rubrica da DB</label><br><br>
  <input type="submit" value="Vedi">
</form>

</body>
</html>