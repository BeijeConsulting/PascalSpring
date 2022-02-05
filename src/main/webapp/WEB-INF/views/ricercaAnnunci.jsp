<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annunci Cercati</title>
<style>
	div{
		border: 1px solid black;
		padding: 1%;
		margin: 10px;
	}
</style>
	
</head>
<body>

<form action="home" method="GET">
	<input type="submit" value="Home">
</form>

<div>
	<form class="form_ricerca" action="ricerca" method="GET">
	
	<label for="tipoImmobile">Tipo Immobile</label>
	<select name="tipoImmobile">
		<option value="CASA">Casa</option>
		<option value="NUOVA_COSTRUZIONE">Nuova costruzione</option>
		<option value="COMMERCIALE">Commerciale</option>
		<option value="TERRENO">Terreno</option>
		<option value="GARAGE">Garage</option>
		<option value="STANZA">Stanza</option>
		<option value="POSTO_LETTO">Posto letto</option>
		<option value="CANTINA_SOLAIO">Cantina/solaio</option>
		<option value="POSTO_BARCA">Posto barca</option>
	</select>
	
	<label for="comune">Comune</label>
	<input type="text" name="comune" />
	
	<label for="tipoAnnuncio">Tipo Annuncio</label>
	<select name="tipoAnnuncio">
		<option value="VENDITA">Vendita</option>
		<option value="AFFITTO">Affitto</option>
		<option value="AFFITTO_BREVE">Affitto breve</option>
	</select>
	
	<input class="cerca" type="submit" value="Cerca" />
	
	</form>
</div>

<!-- <form action="salvaRicerca" method="POST">
	<input type="hidden" value="${ricerca.id}" name="annuncioId" />
	<input type="hidden" value="${utente.id}" name="utenteId" />
	<input type="submit" value="Salva Ricerca" />
</form> -->


<h1>ANNUNCI TROVATI</h1>
	
		<c:forEach items="${annunci}" var="annuncio">
		<div>
			<c:out value="${annuncio.tipoAnnuncio}" /> <c:out value="${annuncio.tipoImmobile}" />
			
			<hr />
			<p>INDIRIZZO: <c:out value="${annuncio.indirizzo.indirizzo}" /> </p>
			<p>CAP: <c:out value="${annuncio.indirizzo.cap}" /> </p>
			<p>NUMERO CIVICO: <c:out value="${annuncio.indirizzo.NCivico}" /> </p>
			
			<hr />
			
			<p>PREZZO: <c:out value="${annuncio.prezzo}" /> euro </p>
			<p>METRI QUADRI: <c:out value="${annuncio.mq}" /> </p>
			<p>CLASSE ENERGETICA: <c:out value="${annuncio.classeEnergetica}" />  </p>
			<p>LOCALI: <c:out value="${annuncio.locali}" /> </p>
			<p>BAGNI: <c:out value="${annuncio.bagni}" /> </p>
			
			
			<c:out value="${annuncio.descrizioneLunga}" />
			
			<br />
			<br />
			
			<form action="visualizzaDettagli" action="GET">
				<input type="hidden" value="${annuncio.id}" name="id" />
				<input type="submit" value="Dettagli" />
			</form>
			
				</div>
		</c:forEach>


</body>
</html>