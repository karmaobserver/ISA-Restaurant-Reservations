<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezervacija</title>



		<link rel="stylesheet" type="text/css" href="styles.css">
	
			
	<link rel="stylesheet" type="text/css" href="jquery.datetimepicker.css"/>
	<script src="jquery.js"></script>
	<script src="jquery.datetimepicker.full.min.js"></script>
		
		<script>
			$(document).ready(function() {
				$(function() {
					
					$( "#datum" ).datetimepicker({
						format:'d.m.Y H:i',
						  
					});
				
					
				});
			});
		</script>

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h2>Rezervacija</h2>
			
		<form method="post" action="RezervacijaServlet">
			<table>
				<tr>
					<th>Restoran</th>
					<td>${restoranUSesijiRezervacije.nazivRestorana}</td>
				</tr>
				<tr>
					<th>Datum i vreme</th>
					<td><input type="text" name="datum" id="datum" readonly/></td>
				</tr>
			
				<tr>
					<th>Trajanje</th>
					<td>
						<select name="trajanje">
						<c:forEach begin="1" end="24" var="sati">
							<option value="${sati}">${sati}</option>
						</c:forEach>
						</select>
					</td>		
				</tr>
				<tr>
					<td><input type="submit" value="Dalje"/></td>
				</tr>
			</table>
				
		</form>
		<p>${porukaParsiranja}</p>
		<p>${porukaTrajanja}</p>
		
		</div>
</body>
</html>