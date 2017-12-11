<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Raspored stolova</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<div style="margin-left: auto; margin-right: auto; width:920px;">
		
	<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
		<%@ include file="menu.jsp" %>
	
			<h2>Raspored stolova</h2>
			<c:if test="${restoranUSesiji.kolona==null}">
				
			
			
			<form action="RasporedServlet" method="post">
				<table>
					<tr>
						<th>Kolona</th>
						<td><input type="text" name="kolona"/></td>
					</tr>
					<tr>
						<th>Redova</th>
						<td><input type="text" name="redova"/></td>
					</tr>
					
					<tr>
						<th>&nbsp;</th>
						<td><input type="submit" value="Napravi raspored" /></td>
					</tr>
				
				</table>	
			</form>
			</c:if>
			
			<c:if test="${restoranUSesiji.kolona!=null}">
				
				
			<c:set var="count" value="0" scope="page" />
				<table>	
				
					
								
								<c:forEach var="stol" items="${stolovi}">
								
									<c:set var="count" value="${count+1}" scope="page"/>
										<!--<c:out value="${count}"></c:out>	
											<c:out value="${restoranUSesiji.kolona}"></c:out>	-->									
									<c:if test="${count == restoranUSesiji.kolona+1}">
											<c:set var="count" value="${count-restoranUSesiji.kolona}" scope="page"/>
											<!--<c:out value="UDJE"></c:out>-->
												<tr>
									</c:if>

									<c:if test="${stol.postoji}">
										<!--<c:out value="POSTOJI "></c:out>-->
										<td><input type="checkbox" name="${stol.id_stol}" checked="checked"   ></td>
									</c:if>
									<c:if test="${!stol.postoji}">
										<!--<c:out value="NEMA "></c:out>-->
										<td><input type="checkbox" name="${stol.id_stol}" disabled="disabled"  ></td>
									</c:if>
									
									
						
								</c:forEach>	
								
								
							
								
						
				
			
				</table>
			
			</c:if>
			
			<p>${porukaPodaci}</p>
			<p>${porukaKonfiguracije}</p>
		
	
</div>

	
</body>
</html>