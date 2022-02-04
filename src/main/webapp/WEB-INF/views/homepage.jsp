<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
		text-align: center;
	}
	div {
		text-align:left;
		border: 1px solid gray;
		padding: 1%;
		margin: 1%;
	}
	label {
		margin-left: 20px;
	}
	label:first-child {
		margin-left: 0px;
	}
	.cerca {
		margin-left: 50px;
	}
	.form-container {
		display: inline-block;
	}
</style>

</head>
<body>

<form action = "form_login" method = "get">	<input type= "submit" value ="Login"></form>

<div class="form-container">
<form action ="form_privato" method= "get" ><input type= "submit" value ="Registrati"></form>
<form action ="form_agenzia" method= "get" ><input type= "submit" value ="Registra agenzia"></form>
<form action ="form_costruttore" method= "get" ><input type= "submit" value ="Registra costruttore"></form>
<form action="formLoginCommerciale" method="get">
  <input type="submit" value="Accesso Commerciali"></input>
</form>
</div>

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

<div>
	<form action="inserisciAnnuncio" method="GET">
	<input type="submit" value="Aggiungi un annuncio" />
	</form>
</div>

<h1>ANNUNCI IN PRIMO PIANO</h1>
	
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
			
			
			<form action="visualizzaDettagli" action="GET">
				<input type="hidden" value="${annuncio.id}" name="id" />
				<input type="submit" value="Dettagli" />
			</form>
			
			<c:out value="${annuncio.descrizioneLunga}" />
				</div>
		</c:forEach>

</body>
</html>