<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija korisnika</title>
<script src="js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="styles.css">
</head>
<body>

<div style="margin-left: auto; margin-right: auto; width:920px;">
		

<h1>Registracija Korisnika</h1>
	
	<form action="RegistracijaServlet" method="post">
		<table>
			<tr>
				<th>Ime</th>
				<td><input type="text" name="imeKorisnika"/></td>
			</tr>
			<tr>
				<th>Prezime</th>
				<td><input type="text" name="prezimeKorisnika"/></td>
			</tr>
			<tr>
				<th>Mail</th>
				<td><input type="text" name="mailKorisnika"/></td>
			</tr>
			<tr>
				<th>Lozinka</th>
				<td><input type="password" name="lozinkaKorisnika" /></td>
			</tr>
			<tr>
				<th>Ponovi lozinku</th>
				<td><input type="password" name="ponoviLozinkaKorisnika"/></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><input type="submit" value="Registruj se" /></td>
			</tr>
		
		</table>	
	</form>
	
		<p>${porukaPodaci}</p>
		<p>${porukaLozinka}</p>
		<p>${porukaMail}</p>
	
						
	
</div>

	
</body>
</html>