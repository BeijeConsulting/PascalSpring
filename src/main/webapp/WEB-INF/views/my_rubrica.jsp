<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyRubrica</title>
</head>
<body>
	
	<form action="rubricaInsertContatto">
		<fieldset>
		<legend>Inserisci nuovo contatto:</legend>
		<label>Nome: </label> <br> 
		<input name="nome" type="text"><br> 
		<label>Cognome: </label> <br> 
		<input name="cognome" type="text"> <br> 
		<label>Telefono</label> <br> 
		<input name="telefono" type="text"> <br> 
		<label>Email</label> <br>
		<input name="email" type="email"> <br> 
		<label>Note</label> <br> 
		<input name="note" type="text"> <br> 
		<input type="submit" value="Submit">
		</fieldset>
	</form>
	
	<form action="rubricaCercaNomeCognome" target="list_iframe">
		<fieldset>
			<input type="submit" value="Cerca">
			<label>Nome:</label>
			<input name="nome">
			<br>
			<label>Cognome:</label>
			<input name="cognome"><br>
		</fieldset>
	</form><br>
	
	<form action="rubricaListWithTelefono" target="list_iframe">
		<label>Visualizza contatti con numero di telefono</label>
		<input type="submit" value="Visualizza">
	</form><br>
	
	<form action="rubricaListWithEmail" target="list_iframe">
		<label>Visualizza contatti con email</label>
		<input type="submit" value="Visualizza">
	</form><br>
	
	<form action="rubricaListAll" target="list_iframe">
		<label>Visualizza tutti i contatti </label>
		<input type="submit" value="Visualizza">
		<br>
		<label>Ordina per:</label><br>
		<input type="radio" name="orderBy" value="nome">
		<label>nome</label><br>
		<input type="radio" name="orderBy" value="cognome">
		<label>cognome</label><br>
		<label>Ordina in ordine:</label>
		<br>
		<input type="radio" name="ascDesc" value="asc">
		<label>ascendente</label><br>
		<input type="radio" name="ascDesc" value="desc">
		<label>discendente</label><br>
	</form>
	
	
	<iframe name="list_iframe" width="1024"></iframe>
</body>
</html>