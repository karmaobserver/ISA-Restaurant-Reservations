<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Izmena jelovnika</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
		<h2>Izmena jelovnika</h2>
		
		<form action="IzmenaJelovnikaServlet" method="post">
						<table>
							<tr>
								<th>Naziv Jela:</th>
								<td><input type="text" name="nazivJela" value="${jeloPoId.nazivJela}"></td>
							
							</tr>
							<tr>
								<th>Opis Jela:</th>
								<td><input type="text" name="opisJela" value="${jeloPoId.opisJela}"></td>
							
							</tr>
							<tr>
								<th>Cena Jela:</th>
								<td><input type="text" name="cenaJela" value="${jeloPoId.cenaJela}"></td>
							
							</tr>
							
							<tr>
								<td><input type="submit" name="submit" value="Izmeni podatke"></td>
							</tr>
						
						</table>
		</form>
			
			<p>${porukaIzmene}</p>
			<p>${porukaPodaci}</p>
			<p>${porukaMail}</p>
						
	
		</div>
</body>
</html>