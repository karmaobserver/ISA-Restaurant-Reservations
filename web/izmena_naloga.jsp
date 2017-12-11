<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Izmena naloga</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h3>Izmena mog profila</h3>
				<c:if test="${gost != null}"  >
					<form action="IzmenaNalogaServlet" method="post">
						<table>
							<tr>
								<th>Ime:</th>
								<td><input type="text" name="ime" value="${gost.ime}"></td>
							
							</tr>
							<tr>
								<th>Prezime:</th>
								<td><input type="text" name="prezime" value="${gost.prezime}"></td>
							
							</tr>
							<tr>
								<th>Adresa:</th>
								<td><input type="text" name="adresa" value="${gost.adresa}"></td>
							
							</tr>
							<tr>
								<th>Mail:</th>
								<td><input type="text" name="mail" value="${gost.mail}"></td>
							
							</tr>
							<tr>
								<th>Lozinka:</th>
								<td><input type="text" name="lozinka" value="${gost.lozinka}"></td>
							
							</tr>
							<tr>
								<td><input type="submit" name="submit" value="Izmeni podatke"></td>
							</tr>
						
						</table>
					</form>
			</c:if>
			<c:if test="${menadzerRestorana != null}"  >
			
					<form action="IzmenaNalogaServlet" method="post">
				
						<table>
							<tr>
								<th>Ime:</th>
								<td><input type="text" name="imeRest" value="${menadzerRestorana.ime}"></td>
							
							</tr>
							<tr>
								<th>Prezime:</th>
								<td><input type="text" name="prezimeRest" value="${menadzerRestorana.prezime}"></td>
							
							</tr>
							<tr>
								<th>Adresa:</th>
								<td><input type="text" name="adresaRest" value="${menadzerRestorana.adresa}"></td>
							
							</tr>
							<tr>
								<th>Mail:</th>
								<td><input type="text" name="mailRest" value="${menadzerRestorana.mail}"></td>
							
							</tr>
							<tr>
								<th>Lozinka:</th>
								<td><input type="text" name="lozinkaRest" value="${menadzerRestorana.lozinka}"></td>
							
							</tr>
							<tr>
								<td><input type="submit" name="submit" value="Izmeni podatke"></td>
							</tr>
						
						</table>
					</form>
			</c:if>		
			<c:if test="${menadzerSistema != null}">
				<form action="IzmenaNalogaServlet" method="post">
				
					<table>
							<tr>
								<th>Ime:</th>
								<td><input type="text" name="imeSis" value="${menadzerSistema.ime}"></td>
							
							</tr>
							<tr>
								<th>Prezime:</th>
								<td><input type="text" name="prezimeSis" value="${menadzerSistema.prezime}"></td>
							
							</tr>
							<tr>
								<th>Adresa:</th>
								<td><input type="text" name="adresaSis" value="${menadzerSistema.adresa}"></td>
							
							</tr>
							<tr>
								<th>Mail:</th>
								<td><input type="text" name="mailSis" value="${menadzerSistema.mail}"></td>
							
							</tr>
							<tr>
								<th>Lozinka:</th>
								<td><input type="text" name="lozinkaSis" value="${menadzerSistema.lozinka}"></td>
							
							</tr>
							<tr>
								<td><input type="submit" name="submit" value="Izmeni podatke"></td>
							</tr>
						
						</table>
				</form>
			</c:if>
		<br>
		<a href="MojNalogServlet">Natrag</a>
	
						
		<p>${porukaIzmene}</p>
		<p>${porukaPodaci}</p>
		<p>${porukaMail}</p>
		</div>
</body>
</html>