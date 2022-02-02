<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Benvenuto nell'e-Commerce</h1>

<h3>Registrati</h3>
<p style="color:green">
${corretto}
</p>
<form action="registra" method="post">
  <label>Nome:</label><br>
  <input type="text" name="nome"><br>
  <label>Cognome:</label><br>
  <input type="text" name="cognome"><br>
  <label>Email:</label><br>
  <input type="text" name="email"><br>
  <label>Password:</label><br>
  <input type="password" name="password"><br><br>
  
  <input type="submit" value="Registrati">
</form>

<br><hr><br>

<h3>Accedi</h3>
<p style="color: red">
${errore}
</p>
<form action="login" method="post">
  <label>Email:</label><br>
  <input type="text" name="email"><br>
  <label>Password:</label><br>
  <input type="password" name="password"><br><br>
  
  <input type="submit" value="Accedi">
</form>

</body>
</html>