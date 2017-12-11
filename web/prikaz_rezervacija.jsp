<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Moje rezervacije</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h2>Moje rezervacije</h2>
	
			<table border="1" bordercolor="red" >
				<tr>
					<th>Restoran</th>
					<th>Datum</th>
					<th>Trajanje</th>
					
					
				
				</tr>
			
				<c:forEach items="${listaRezervacija}" var="rezervacija">
					<tr>
						<td>${rezervacija.restoran.nazivRestorana}</td>
						
						
            			<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" 
            value="${rezervacija.datum}"/></td>
            
						<td>${rezervacija.trajanje}</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>