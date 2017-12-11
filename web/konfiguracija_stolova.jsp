<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Konfiguracija Stolova</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	
		<div style="margin-left: auto; margin-right: auto; width:920px;">
		
			<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
				<%@ include file="menu.jsp" %>
	
			<h2>Konfiguracija Stolova</h2>
			
	<c:set var="count" value="0" scope="page" />
	<form action="KonfiguracijaServlet?iteracija=${restoranUSesiji.redova*restoranUSesiji.kolona}" method="post" >
		<table>	
		<c:forEach var="i" begin="1" end="${restoranUSesiji.redova}">
			<tr>
			
				<c:forEach var="j" begin="1" end="${restoranUSesiji.kolona}">
					<c:set var="count" value="${count + 1}" scope="page"/>
					<td><input type="checkbox" name="${count}"></td>
					
				</c:forEach>
			</tr>
			
		</c:forEach>
		
		</table>
		
		<input type="submit"  value="konfigurisi"/>
	
	</form>
	
		</div>
</body>
</html>