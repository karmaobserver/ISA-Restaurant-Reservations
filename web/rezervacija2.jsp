<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezervacija Restorana</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h2>Rezervacija Restorana</h2>
		
<c:if test="${restoranUSesijiRezervacije.kolona!=null}">

		<form method="post" action="Rezervacija2Servlet?iteracija=${restoranUSesijiRezervacije.redova*restoranUSesijiRezervacije.kolona}">
			<table>
				<tr>
					<th>Restoran</th>
					<td>${restoranUSesijiRezervacije.nazivRestorana}</td>
				</tr>
				<tr>
					<th>Datum i vreme</th>
					<td>${stringDatumUSesiji}</td>
				</tr>
			
				<tr>
					<th>Trajanje</th>
					<td>${trajanjeUSesiji}</td>		
	
				</tr>
				
			</table>
				
		
		<br>
		<p>Cekirajte stolove koje zelite da rezervisete.</p> 
		<c:if test="${restoranUSesijiRezervacije.kolona!=null}">

			<c:set var="count" value="0" scope="page" />
			<c:set var="countItems" value="0" scope="page" />
			<c:set var="broj" value="2" scope="page" />
				<table>	
						
								
								<c:forEach var="stol" items="${stolovi}">
									<c:set var="countItems" value="${countItems+1}" scope="page"/>
									<c:set var="count" value="${count+1}" scope="page"/>
									<c:set var="broj" value="2" scope="page" />
										
										<!--<c:out value="${count}"></c:out>	
											<c:out value="${restoranUSesiji.kolona}"></c:out>	-->									
									<c:if test="${count == restoranUSesijiRezervacije.kolona+1}">
											<c:set var="count" value="${count-restoranUSesijiRezervacije.kolona}" scope="page"/>
											<!--<c:out value="UDJE"></c:out>-->
												<tr>
									</c:if>
								
									<c:if test="${stol.postoji}">
										<!--<c:out value="POSTOJI "></c:out>-->
										<c:if test="${stol.zauzet}">
										
											<td><input type="checkbox" name="${countItems}" checked="checked" disabled="disabled" value="${stol.id_stol}"  ></td>
										</c:if>
										
										<c:if test="${!stol.zauzet}">
										
											<td><input type="checkbox" name="${countItems}"  value="${stol.id_stol}"  ></td>
										</c:if>
									</c:if>
									<c:if test="${!stol.postoji}">
										<!--<c:out value="NEMA "></c:out>-->
										
										<td><input type="checkbox" name="${countItems}" disabled="disabled" value="${stol.id_stol}" ></td>
									</c:if>
									
									
						
								</c:forEach>	
								

			
				</table>
				
			</c:if>
			
			
				
		<input type="submit" value="Dalje"/>
		</form>
		</c:if>
		<c:if test="${restoranUSesijiRezervacije.kolona==null}">
					<p>Nije napravljena konfiguracija stolova jos. Pozovite menadzera.</p>
			</c:if>
		</div>
</body>
</html>