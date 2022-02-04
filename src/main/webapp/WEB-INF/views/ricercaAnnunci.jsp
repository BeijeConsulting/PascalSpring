<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annunci Cercati</title>
</head>
<body>

<form action="salvaRicerca" method="POST">
	<input type="hidden" value="${ricerca.id}" name="annuncioId" />
	<input type="hidden" value="${utente.id}" name="utenteId" />
	<input type="submit" value="Salva Ricerca" />
</form>


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
			
			
			<form action="visualizzaDettagli" action="GET">
				<input type="hidden" value="${annuncio.id}" name="id" />
				<input type="submit" value="Dettagli" />
			</form>
			
			<c:out value="${annuncio.descrizioneLunga}" />
				</div>
		</c:forEach>


</body>
</html>