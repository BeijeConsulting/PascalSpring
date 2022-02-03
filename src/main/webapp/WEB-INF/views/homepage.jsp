<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>lista prodotti</h1>
<!--  <table>
    <tr>
        <th>TIPO IMMOBILE</th>
        <th>TIPO ANNUNCIO</th>
        <th>PREZZO</th>
        <th>METRI QUADRI</th>
        <th>LOCALI</th>
        
        <th>BAGNI</th>
        <th>TOT. PIANI</th>
        <th>PIANO</th>
        <th>ASCENSORE</th>
        <th>POSTI AUTO</th>
        
        <th>BALCONE</th>
        <th>TERRAZZO</th>
        <th>GIARDINO</th>
        <th>CONDIZIONE</th>
        <th>CLASSE ENERGETICA</th>
        
        <th>RISCALDAMENTO</th>
        <th>ARIA CONDIZIONATA</th>
        <th>ARREDAMENTO</th>
        <th>PISCINA</th>
        <th>PORTINERIA</th>
        
        <th>ANNO COSTRUZIONE</th>
        <th>STATO AL ROGITO</th>
        <th>VISITA GUIDATA</th>
        <th>DESCRIZIONE LUNGA</th>
        <th>VISITA GUIDATA</th>
        <th>VISITA GUIDATA</th>
    </tr>
    <c:forEach items="${products}" var="prod">
    <tr>
        <td>
            <c:out value="${prod.name}" />
        </td>
        <td>
            <c:out value="${prod.description}" />
        </td>
        <td>
            <c:out value="${prod.price}" />
        </td>
        <td>
            <c:out value="${prod.quantity}" />
        </td>
        <td>
            <form action="" method="post">
            	<input type="hidden" value="${prod.id}" name="id">
            	<input type="submit" value="Elimina">
            </form>
        </td>
        <td>
            <form action="" method="GET">
            	<input type="hidden" value="${prod.id}" name="id">
            	<input type="submit" value="Update">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
 -->
</body>
</html>