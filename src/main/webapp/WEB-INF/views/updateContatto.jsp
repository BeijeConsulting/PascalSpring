<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="webupdateContatto" method="post">
		<label>nome:</label> <br> <input type="text" value="${c.nome}"
			name="nome"> <br> <label>cognome:</label> <br> <input
			type="text" value="${c.cognome}" name="cognome"> <br> <label>email:</label>
		<br> <input type="text" value="${c.email}" name="email">
		<br> <label>telefono:</label> <br> <input type="text"
			value="${c.telefono}" name="telefono"> <br> <label>note:</label>
		<br> <input type="text" value="${c.note}" name="note"> <br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>