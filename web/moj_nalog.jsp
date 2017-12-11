<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Moj Nalog</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
			
			<h3>Moj profil</h3>
			<c:if test="${gost != null}">
				<c:if test="${gost.slika == null}">
						<span>Slika:  - nema slike - </span> <br/>
				</c:if>
				<c:if test="${gost.slika != null}">
						<span>Slika: </span> <br/> <span>  <a href="${gost.slika}" target="_blank"><img src="${gost.slika}" width="180px" /></a> </span> <br/>
				</c:if>
				<table>
					<tr>
						<th>Ime:</th>
						<td>${gost.ime}</td>
					
					</tr>
					<tr>
						<th>Prezime:</th>
						<td>${gost.prezime}</td>
					
					</tr>
					<tr>
						<th>Adresa:</th>
						<td>${gost.adresa}</td>
					
					</tr>
					<tr>
						<th>Mail:</th>
						<td>${gost.mail}</td>
					
					</tr>
					<tr>
						<th>Lozinka:</th>
						<td>${gost.lozinka}</td>
					
					</tr>
				
				</table>
				<br>
				<br>
				<a href="IzmenaNalogaServlet">Izmena podataka</a>
				
				<br>
				<br>
				
				<table title="Moji prijatelji" border="1"  >
					
					<tr>
						<th>Moji prijatelji</th>
					
					
					</tr>
					<c:forEach items="${prijateljiGost.prijatelji}" var="prijatelj">
					<tr>
						
						<td>${prijatelj.ime}&nbsp&nbsp${prijatelj.prezime}</td>
						
					
					</tr>
				</c:forEach>
				</table>
				<br>
			<!--  	<table title="svi gosti" border="1" >
					<tr>
						<th>Ime:</th>
						<th>Prezime:</th>
					
					</tr>
					
					<c:forEach items="${gosti}" var="gostP">
						<tr>
							<td>${gostP.ime}</td>
							<td>${gostP.prezime}</td>
							
							<td><a href="PrijateljiServlet?id=${gostP.id}">Dodaj</a></td>
				
						<tr>
			
					</c:forEach>
				</table>-->
				
				
						
				<form method="post" action="PretrazivanjePrijateljaServlet">
				<table>
					<tr>
						<th>Nadji korisnika</th>
						<td><input type="text" name="imePrzime"  alt="Upisite Ime ili Prezime"  /></td>
					</tr>
					<tr>
						<th>&nbsp;</th>
						<td><input type="submit" value="Pretrazi" /></td>
					</tr>
				</table>
			</form>
			
			<c:if test="${lista!=null && lista.isEmpty() == false}">
				
				<table title="Rezultat Pretrage" border="1"  >
					
					<tr>
						<th>Rezultat pretrage</th>
					
					
					</tr>
					<c:forEach items="${lista}" var="gostNadjen">
					<tr>
						
						<td>${gostNadjen.ime}&nbsp&nbsp${gostNadjen.prezime}</td>
						<td><a href="PrijateljiServlet?id=${gostNadjen.id}">Dodaj</a></td>
						
					
					</tr>
				</c:forEach>
				</table>
			</c:if>
			
			<c:if test="${lista!=null && lista.isEmpty() == true}">
				<p>Nije nista pronadjeno</p>
			</c:if>
						
			
	
				
				
				
			</c:if>
			<c:if test="${menadzerRestorana != null}"  >
				<c:if test="${menadzerRestorana.slika == null}">
						<span>Slika:  - nema slike - </span> <br/>
				</c:if>
				<c:if test="${menadzerRestorana.slika != null}">
						<span>Slika: </span> <br/> <span>  <a href="${menadzerRestorana.slika}" target="_blank"><img src="${menadzerRestorana.slika}" width="180px" /></a> </span> <br/>
				</c:if>
				<table>
					<tr>
						<th>Ime:</th>
						<td>${menadzerRestorana.ime}</td>
					
					</tr>
					<tr>
						<th>Prezime:</th>
						<td>${menadzerRestorana.prezime}</td>
					
					</tr>
					<tr>
						<th>Adresa:</th>
						<td>${menadzerRestorana.adresa}</td>
					
					</tr>
					<tr>
						<th>Mail:</th>
						<td>${menadzerRestorana.mail}</td>
					
					</tr>
					<tr>
						<th>Lozinka:</th>
						<td>${menadzerRestorana.lozinka}</td>
					
					</tr>
					
					<tr>	
						<th>Menadzer restorana:</th>
						<td>${menadzerRestorana.restoran.nazivRestorana}</td>
					</tr>
				
				</table>
				<br>
			<br>
			<a href="IzmenaNalogaServlet">Izmena podataka</a>
			
			</c:if>		
			<c:if test="${menadzerSistema != null}">
				
				<c:if test="${menadzerSistema.slika == null}">
						<span>Slika:  - nema slike - </span> <br/>
				</c:if>
				<c:if test="${menadzerSistema.slika != null}">
						<span>Slika: </span> <br/> <span>  <a href="${menadzerSistema.slika}" target="_blank"><img src="${menadzerSistema.slika}" width="180px" /></a> </span> <br/>
				</c:if>
				<table>
					<tr>
						<th>Ime:</th>
						<td>${menadzerSistema.ime}</td>
					
					</tr>
					<tr>
						<th>Prezime:</th>
						<td>${menadzerSistema.prezime}</td>
					
					</tr>
					<tr>
						<th>Adresa:</th>
						<td>${menadzerSistema.adresa}</td>
					
					</tr>
					<tr>
						<th>Mail:</th>
						<td>${menadzerSistema.mail}</td>
					
					</tr>
					<tr>
						<th>Lozinka:</th>
						<td>${menadzerSistema.lozinka}</td>
					
					</tr>
				
				
				</table>
				<br>
			<br>
			<a href="IzmenaNalogaServlet">Izmena podataka</a>
			
			</c:if>
		
		</div>
</body>
</html>