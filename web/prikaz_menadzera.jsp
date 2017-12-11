<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menadzeri</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			
			<h2>Prikaz Menadzera:</h2>
						
			<table border="1" bordercolor="red" >
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>Mail</th>
					<th>Lozinka</th>
					<th>Adresa</th>
					<th>Menadzer Restorana</th>
				
				</tr>
			
				<c:forEach items="${menadzeriRestorana}" var="menadzer">
					<tr>
						<td>${menadzer.ime}</td>
						<td>${menadzer.prezime}</td>
						<td>${menadzer.mail}</td>
						<td>${menadzer.lozinka}</td>
						<td>${menadzer.adresa}</td>
						<td>${menadzer.restoran.nazivRestorana}</td>
					</tr>
				</c:forEach>
			
			
			
			
			
			
			</table>
						
						
	
		</div>
</body>
</html>