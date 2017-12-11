<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<div style="margin-left: auto; margin-right: auto; width:920px;">
		
	<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
		<%@ include file="menu.jsp" %>
	
			<h2>Dobro dosli</h2>
			
		<c:if test="${gost != null}">
			<p> ${gost.ime}</p>
		</c:if>
		
		<c:if test="${menadzerRestorana != null}">
			<p>${menadzerRestorana.ime}</p>
			<!--  response.sendRedirect("PrikazRestoranaServlet"); -->
			<p>${porukaKonfiguracije}</p>
		</c:if>
		
		<c:if test="${menadzerSistema != null}">
			<p>${menadzerSistema.ime}</p>
		</c:if>
						
	
</div>

	
</body>
</html>