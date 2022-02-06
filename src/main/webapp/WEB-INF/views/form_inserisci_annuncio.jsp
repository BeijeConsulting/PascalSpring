<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.beije.pascal.model.enums.TipoImmobile"%>
<%@page import="it.beije.pascal.model.enums.StatoRogito"%>
<%@page import="it.beije.pascal.model.enums.Arredamento"%>
<%@page import="it.beije.pascal.model.enums.AriaCondizionata"%>
<%@page import="it.beije.pascal.model.enums.Riscaldamento"%>
<%@page import="it.beije.pascal.model.enums.ClasseEnergetica"%>
<%@page import="it.beije.pascal.model.enums.Condizione"%>
<%@page import="it.beije.pascal.model.enums.Giardino"%>
<%@page import="it.beije.pascal.model.enums.TipoAnnuncio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h1>Aggiunta di un nuovo annuncio</h1>
<div>

<form action="home" method="GET">
	<input type="submit" value="Home">
</form>

<form action="inserisciAnnuncio" method="post">

	  <label for="tipo_immobile">Tipo immobile:</label>
	  <select name="tipo_immobile">
	  
	  <c:set var="tipo_immobile" value="<%=TipoImmobile.values()%>"/>
	  
	  <c:forEach items="${tipo_immobile}" var="tipo">
	  	<option value="${tipo.name()}">${tipo.name()}</option>
	  </c:forEach>
	  
	  </select>
	  
	  <br />
	  
	  <label for="tipo_annuncio">Tipo Annuncio:</label>
	  <select name="tipo_annuncio">
	  <c:set var="tipo_annuncio_values" value="<%=TipoAnnuncio.values()%>"/>
	  
	  <c:forEach items="${tipo_annuncio_values}" var="tipo_annuncio">
	  	<option value="${tipo_annuncio.name()}">${tipo_annuncio.name()}</option>
	  </c:forEach>
	  
	  </select>
	  
	  <br />
	  
	  <label for="aria_condizionata">Aria Condizionata:</label>
	  <select name="aria_condizionata">
	  <c:set var="aria_condizionata_values" value="<%=AriaCondizionata.values()%>"/>
	  
	  <c:forEach items="${aria_condizionata_values}" var="aria">
	  	<option value="${aria.name()}">${aria.name()}</option>
	  </c:forEach>
	  
	  </select>
	  
	  <br />
	  
	  <label for="classe_energetica">Classe energetica:</label>
	  <select name="classe_energetica">
	  <c:set var="classe_energetica_values" value="<%=ClasseEnergetica.values()%>"/>
	  
	  <c:forEach items="${classe_energetica_values}" var="classe_energetica">
	  	<option value="${classe_energetica.name()}">${classe_energetica.name()}</option>
	  </c:forEach>
	  
	  </select>
	 
	 <br />
	 
	 <label for="condizione">Condizione:</label>
	  <select name="condizione">
	  <c:set var="condizione_values" value="<%=Condizione.values()%>"/>
	  
	  <c:forEach items="${condizione_values}" var="condizione">
	  	<option value="${condizione.name()}">${condizione.name()}</option>
	  </c:forEach>
	  
	  </select>
	 
	 <br />
	  
	  <label for="giardino">Giardino:</label>
	  <select name="giardino">
	  <c:set var="giardino_values" value="<%=Giardino.values()%>"/>
	  
	  <c:forEach items="${giardino_values}" var="giardino">
	  	<option value="${giardino.name()}">${giardino.name()}</option>
	  </c:forEach>
	  
	  </select>

<br />	  
	  <label for="riscaldamento">Riscaldamento:</label>
	  <select name="riscaldamento">
	  <c:set var="riscaldamento_values" value="<%=Riscaldamento.values()%>"/>
	  
	  <c:forEach items="${riscaldamento_values}" var="riscaldamento">
	  	<option value="${riscaldamento.name()}">${riscaldamento.name()}</option>
	  </c:forEach>
	  
	  </select>
	  
	  <br />
	  <label for="arredamento">Arredamento:</label>
	  <select name="arredamento">
	  <c:set var="arredamento_values" value="<%=Arredamento.values()%>"/>
	  
	  <c:forEach items="${arredamento_values}" var="arredamento">
	  	<option value="${arredamento.name()}">${arredamento.name()}</option>
	  </c:forEach>
	  
	  </select>
	  <br />
	  
	  <label for="stato_rogito">Stato rogito:</label>
	  <select name="stato_rogito">
	  <c:set var="stato_rogito_values" value="<%=StatoRogito.values()%>"/>
	  
	  <c:forEach items="${stato_rogito_values}" var="stato_rogito">
	  	<option value="${stato_rogito.name()}">${stato_rogito.name()}</option>
	  </c:forEach>
	  
	  </select>
	  
	  
	  <br><br>
	 	 
	  <div>
	  <h3>Indirizzo</h3>
	  <label for="comune">Comune:</label><br>
	  <input type="text" name="comune"><br><br>
	 
	  <label for="indirizzo">Via:</label><br>
	  <input type="text" name="indirizzo"><br><br>
	 
	  <label for="numero_civico">Numero civico:</label><br>
	  <input type="text" name="numero_civico"><br><br>
	 
	  <label for="cap">CAP:</label><br>
	  <input type="text" name="cap"><br><br>
	  </div>
	 
	  <br>
	 
	  <label for="prezzo">Prezzo:</label><br>
	  <input type="text" name="prezzo"><br><br>
	 
	  <label for="mq">Metri quadrati:</label><br>
	  <input type="text" name="mq"><br><br>
	 
	  <label for="locali">Locali:</label><br>
	  <input type="text" name="locali"><br><br>
	 
	  <label for="bagni">Bagni:</label><br>
	  <input type="text" name="bagni"><br><br>
	 
	  <label for="tot_piani">Numero di piani:</label><br>
	  <input type="text" name="tot_piani"><br><br>
	 
	  <label for="piano">Piano:</label><br>
	  <input type="text" name="piano"><br><br>
	 
	  <label for="ascensore">Ascensore:</label> 
	  <input type="checkbox" name="ascensore"><br><br>
	 
	  <label for="posti_auto">Posti auto:</label><br>
	  <input type="text" name="posti_auto"><br><br>
	 
	  <label for="balcone">Balcone:</label>
	  <input type="checkbox" name="balcone"><br><br>
	 
	  <label for="terrazzo">Terrazzo:</label>
	  <input type="checkbox" name="terrazzo"><br><br>
	 
	  <label for="piscina">Disponibilità piscina:</label>
	  <input type="checkbox" name="piscina"><br><br>
	 
	  <label for="portineria">Presenza portineria:</label>
	  <input type="checkbox" name="portineria"><br><br>
	 
	  <label for="anno_costruzione">Anno di costruzione:</label><br>
	  <input type="text" name="anno_costruzione"><br><br>
	 
	  <br><br>
	 
	  <label for="visita_guidata">Disponibilità di visita guidata:</label>
	  <input type="checkbox" name="visita_guidata"><br><br>
	 
	  <label for="descrizione_lunga">Descrizione dell'immobile:</label><br>
	  <textarea id="descrizioneLunga" name="descrizione_lunga" rows="10" cols="50">Inserire qui la descrizione completa dell'immobile...
 	  </textarea><br><br>
 	 
 	  <label for="virtual_tour">Disponibilità di visita virtuale:</label>
	  <input type="checkbox" name="virtual_tour"><br><br>
	 
	  <input type="submit" value="Crea Annuncio">
	 
</form>
</div>
</div>
</body>
</html>