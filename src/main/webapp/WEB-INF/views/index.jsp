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

<form action="rubrica">
	<h3>Tipo File:</h3>
	<input type="radio" name="tipo" value="CSV">
	<label>CSV</label>
	<input type="radio" name="tipo" value="XML">
	<label>XML</label>

	<br>
	<h3>Filtra per: </h3>
	<input type="radio" name="dato" value="email">
	<label>email</label>
	<br>
	<input type="radio" name="dato" value="tel">
	<label>elefono</label>
	<br>
		<input type="submit" value="import">
</form>

</body>
</html>