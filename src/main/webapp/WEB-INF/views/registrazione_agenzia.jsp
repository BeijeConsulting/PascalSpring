<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Pagina di registrazione Agenzia</h1>
<form action="registerAgenzia" method="post">

	  <label for="username">Username:</label><br>
	  <input type="text" name="username"><br>
	  
	  <label for="email">Email:</label><br>
	  <input type="text" name="email"><br>
	  
	  <label for="password">Password:</label><br>
	  <input type="password" name="password"><br><br>
	  
	  <label for="telefono">Telefono:</label><br>
	  <input type="text" name="telefono"><br><br>
	  
	  <label for="pIva">Partita Iva:</label><br>
	  <input type="text" name="p_iva"><br><br>
	  
	  <label for="agenzia">Ragione sociale agenzia:</label><br>
	  <input type="text" name="ragione_sociale"><br><br>
	  
	  <label for="comune">Comune:</label><br>
	  <input type="text" name="comune"><br>
	  
	  <label for="cap">Cap:</label><br>
	  <input type="text" name="cap"><br>
	  
	  <label for="indirizzo">Indirizzo:</label><br>
	  <input type="text" name="indirizzo"><br>
	  	
	  <label for="num_civico">Numero civico:</label><br>
	  <input type="text" name="num_civico"><br>
	  
	  <label for="spam">Desideri rimanere aggiornato sulle ultime novità di fondamenta.it?</label>
	  <input type="checkbox" name="spam"><br><br>
	  
	  <input type="submit" value="Registra">
	  
	</form>
</body>
</html>

