<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli annuncio</title>
</head>
<body>

	<form action="home" action="GET">
		<input type="submit" value="Home" />
	</form>

	<div>
		<h1><c:out value="${annuncio.tipoAnnuncio}" /> <c:out value="${annuncio.tipoImmobile}" /></h1>
			
		<p>VENDITORE: <c:out value="${annuncio.utente.username}" /> </p>
		<p>TOT. PIANI: <c:out value="${annuncio.totPiani}" /> </p>
		<p>PIANO: <c:out value="${annuncio.piano}" /> </p>
		<p>ASCENSORE: <c:out value="${annuncio.ascensore}" /> </p>
		<p>POSTI AUTO: <c:out value="${annuncio.postiAuto}" /> </p>
			<p>BALCONE: <c:out value="${annuncio.balcone}" /> </p>
			<p>TERRAZZO: <c:out value="${annuncio.terrazzo}" /> </p>
			<p>GIARDINO: <c:out value="${annuncio.giardino}" /> </p>
			<p>CONDIZIONE: <c:out value="${annuncio.condizione}" /> </p>
			<p>CLASSE ENERGETICA: <c:out value="${annuncio.classeEnergetica}" /> </p>
			<p>RISCALDAMENTO: <c:out value="${annuncio.riscaldamento}" /> </p>
			<p>ARIA CONDIZIONATA: <c:out value="${annuncio.ariaCondizionata}" /> </p>
			<p>ARREDAMENTO: <c:out value="${annuncio.arredamento}" /> </p>
			<p>PISCINA: <c:out value="${annuncio.piscina}" /> </p>
			<p>PORTINERIA: <c:out value="${annuncio.portineria}" /> </p>
			<!-- qui ci dovrebbe essere l'anno di costruzione, ma causa un errore  -->
			
			<p>INDIRIZZO: <c:out value="${annuncio.indirizzo.indirizzo}" /> </p>
			<p>CAP: <c:out value="${annuncio.indirizzo.cap}" /> </p>
			<p>NUMERO CIVICO: <c:out value="${annuncio.indirizzo.NCivico}" /> </p>
			
			<p>PREZZO: <c:out value="${annuncio.prezzo}" /> euro </p>
			<p>METRI QUADRI: <c:out value="${annuncio.mq}" /> </p>
			<p>CLASSE ENERGETICA: <c:out value="${annuncio.classeEnergetica}" />  </p>
			<p>LOCALI: <c:out value="${annuncio.locali}" /> </p>
			<p>BAGNI: <c:out value="${annuncio.bagni}" /> </p>
				
			<p>DESCRIZIONE: <c:out value="${annuncio.descrizioneLunga}" /></p>
	</div>
</body>
</html>