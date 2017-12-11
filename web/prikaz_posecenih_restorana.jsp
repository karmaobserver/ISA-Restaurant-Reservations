<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Postojeci restorani</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h2>Prikaz posecenih restorana</h2>
	
				<table border="1">
					<tr>
						<th>Naziv Restorana</th>
						<th>Opis Restorana</th>
						<th>Jelovnik</th>
					
					</tr>
					<c:forEach items="${listaRezervacija}" var="rezervacija">
						<tr> 
							<td>${rezervacija.restoran.nazivRestorana}</td>
							<td>${rezervacija.restoran.opisRestorana}</td>
						    <td><a href="JelovnikServlet?id=${rezervacija.restoran.id_restoran}&poseceni=da" name="id" >Jelovnik</a></td>
						  
						    
							
							
						</tr>
						</c:forEach>
	
				
				</table>
						
	
		</div>
</body>
</html>