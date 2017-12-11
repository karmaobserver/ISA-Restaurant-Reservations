<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login korisnika</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div style="margin-left: auto; margin-right: auto; width:920px;">
	<h1>Logovanje Korisnika</h1>
	
	
	<form method="post" action="LoginServlet">
		<table>
			<tr>
				<th>Mail</th>
				<td><input type="text" name="mail" /></td>
			</tr>
			<tr>
				<th>Lozinka</th>
				<td><input type="password" name="lozinka" /></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><input type="submit" value="Prijavi se" /></td>
				
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><input type="button" value="Registracija" name="registracija"
    			onclick="openPage('registracija.jsp')"/></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>

						
						<p>${poruka}</p>
						<p>${porukaReg}</p>
						
						
						
<br>
<br>
<br>
<br>


	
</div>
</body>
</html>