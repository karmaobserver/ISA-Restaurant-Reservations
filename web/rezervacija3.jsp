<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				
		<form method="post" action="Rezervacija3Servlet">
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
				
				<input type="submit" value="Rezervisi"/>
		</form>
		
		
						
	
		</div>
</body>
</html>