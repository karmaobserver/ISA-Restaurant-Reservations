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
	
			
			<h2>Prikaz Restorana:</h2>
			
			<c:if test="${gost != null}">
				<table border="1">
					<tr>
						<th>Naziv Restorana</th>
						<th>Opis Restorana</th>
						<th>Jelovnik</th>
					
					</tr>
					<c:forEach items="${restorani}" var="restoran">
						<tr> 
							<td>${restoran.nazivRestorana}</td>
							<td>${restoran.opisRestorana}</td>
						    <td><a href="JelovnikServlet?id=${restoran.id_restoran}" name="id" >Jelovnik</a></td>
						     <td><a href="RezervacijaServlet?id=${restoran.id_restoran}" name="id" >Rezervisi</a></td>
						    
							
							
						</tr>
						</c:forEach>
	
				
				</table>
			
			
			
			
			</c:if>
			
			<c:if test="${menadzerRestorana != null}">
				<table border="1">
					<tr>
						<th>Naziv Restorana</th>
						<th>Opis Restorana</th>
						<th>Jelovnik</th>
					
					</tr>
					
						<tr> 
							<td>${restoranId.nazivRestorana}</td>
							<td>${restoranId.opisRestorana}</td>
						    <td><a href="JelovnikServlet?id=${restoranId.id_restoran}" name="id" >Jelovnik</a></td>
							
							
						</tr>

				</table>
				<br>
				<a href="IzmenaRestoranaServlet?id=${restoranId.id_restoran}" name="id" >Izmena podataka restorana</a>	
		
			</c:if>	
			
			<c:if test="${menadzerSistema != null}">
				<table border="1">
					<tr>
						<th>Naziv Restorana</th>
						<th>Opis Restorana</th>
						<th>Jelovnik</th>
					
					</tr>
					<c:forEach items="${restorani}" var="restoran">
						<tr> 
							<td>${restoran.nazivRestorana}</td>
							<td>${restoran.opisRestorana}</td>
						    <td><a href="JelovnikServlet?id=${restoran.id_restoran}" name="id" >Jelovnik</a></td>
							
							
						</tr>
						</c:forEach>
	
				
				</table>
			</c:if>	
			
			
						
	
		</div>
</body>
</html>