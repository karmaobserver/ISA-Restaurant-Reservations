<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jelovnik</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			
			<h2>Jelovnik</h2>
			
			<c:if test="${gost != null}">
			
			<table border="1" bordercolor="blue">
				<tr>
					<th>Naziv Jela</th>
					<th>Opis Jela</th>
					<th>Cena Jela</th>
				
				
				</tr>
				<c:forEach items="${jela}" var="jelo">
					<tr> 
						<td>${jelo.nazivJela}</td>
						<td>${jelo.opisJela}</td>
						<td>${jelo.cenaJela}</td>
						
						
						
					</tr>
					</c:forEach>

					
			</table>
			<br>
				<p>${porukaIzmene}</p>
			<p>${porukaPodaci}</p>
			<p>${porukaMail}</p>
			
			<br>
			<c:if test="${saPosecenihRestorana ne 'da'}">
					<a href="PrikazRestoranaServlet">Natrag</a>
				</c:if>
				
				<c:if test="${saPosecenihRestorana eq 'da'}">
					<a href="PrikazPosecenihRestoranaServlet" >Natrag</a>
				</c:if>
			</c:if>
			
			
			
						
			<c:if test="${menadzerRestorana != null}">
			<table border="1" bordercolor="blue">
				<tr>
					<th>Naziv Jela</th>
					<th>Opis Jela</th>
					<th>Cena Jela</th>
				
				
				</tr>
				<c:forEach items="${jela}" var="jelo">
					<tr> 
						<td>${jelo.nazivJela}</td>
						<td>${jelo.opisJela}</td>
						<td>${jelo.cenaJela}</td>
						<td><a href="ObrisiServlet?idJela=${jelo.id_jela}">Obrisi</a></td>
						<td><a href="IzmenaJelovnikaServlet?idJela=${jelo.id_jela}">Izmena jela</a></td>
						
						
					</tr>
					</c:forEach>

					
			</table>
			<br>
				<p>${porukaIzmene}</p>
			<p>${porukaPodaci}</p>
			<p>${porukaMail}</p>
			
			
			<a href="DodavanjeJelaServlet">Dodaj novo jelo</a>
			<br>
			<br>
			<a href="PrikazRestoranaServlet?id=${menadzerRestorana.restoran.id_restoran}">Natrag</a>
			</c:if>
			
			
					
			
				
				
		
			<c:if test="${menadzerSistema != null}">
			
			<table border="1" bordercolor="blue">
				<tr>
					<th>Naziv Jela</th>
					<th>Opis Jela</th>
					<th>Cena Jela</th>
				
				
				</tr>
				<c:forEach items="${jela}" var="jelo">
					<tr> 
						<td>${jelo.nazivJela}</td>
						<td>${jelo.opisJela}</td>
						<td>${jelo.cenaJela}</td>
						
						
						
					</tr>
					</c:forEach>

					
			</table>
			<br>
				<p>${porukaIzmene}</p>
			<p>${porukaPodaci}</p>
			<p>${porukaMail}</p>
			
			<br>
				<a href="PrikazRestoranaServlet">Natrag</a>
			</c:if>
		
		
			
		</div>
</body>
</html>