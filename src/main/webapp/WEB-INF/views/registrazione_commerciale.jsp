<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registerCommerciale" method="post">

	  <label for="username">Username:</label><br>
	  <input type="text" name="username"><br>
	  
	  <label for="email">Email:</label><br>
	  <input type="text" name="email"><br>
	  
	  <label for="password">Password:</label><br>
	  <input type="password" name="password"><br><br>
	  
	  <label for="telefono">Telefono:</label><br>
	  <input type="text" name="telefono"><br><br>
	  
	  <label for="pIva">Partita Iva:</label><br>
	  <input type="text" name="pIva"><br><br>
	  
	  <label for="agenzia">Ragione sociale agenzia:</label><br>
	  <input type="text" name="agenzia"><br><br>
	  
<!-- 	   <label for="agenzia">Nome referente: </label><br>
	  <input type="text" name="nomeRef"><br><br> -->
	  
	  <label for="spam">Desideri rimanere aggiornato sulle ultime novità di fondamenta.it?</label>
	  <input type="checkbox" name="spam"><br><br>
	  
	  <input type="submit" value="Registra">
	  
	</form>
</body>
</html>