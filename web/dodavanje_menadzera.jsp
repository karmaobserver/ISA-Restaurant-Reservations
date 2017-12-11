<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restorani</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h2>Dodavanje Menadzera</h2>
		
		<form action="DodavanjeMenadzeraServlet" method="post">
		<table>
			<tr>
				<th>Ime</th>
				<td><input type="text" name="imeMenadzera"/></td>
			</tr>
			<tr>
				<th>Prezime</th>
				<td><input type="text" name="prezimeMenadzera"/></td>
			</tr>
			<tr>
				<th>Mail</th>
				<td><input type="text" name="mailMenadzera"/></td>
			</tr>
			<tr>
				<th>Lozinka</th>
				<td><input type="password" name="lozinkaMenadzera" /></td>
			</tr>
			<tr>
				<th>Adresa</th>
				<td><input type="text" name="adresaMenadzera"/></td>
			</tr>
			<tr>
				<th>Menadzer za restoran</th>
				<td>
					<select name="restorani">
						<c:forEach items="${restorani}" var="restoran">
							<option value="${restoran.id_restoran}">${restoran.nazivRestorana}</option>
						</c:forEach>
					</select>
				</td>				
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><input type="submit" value="Dodaj menadzera" /></td>
			</tr>
		
		</table>	
	</form>
		
		<p>${porukaMail}</p>
		<p>${porukaPodaci}</p>
		<p>${porukaDodato}</p>
	
	
						
	
						
	
		</div>
</body>
</html>