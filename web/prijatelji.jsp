<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prijatelji</title>
<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<div style="margin-left: auto; margin-right: auto; width:920px;">
		
	<div style="background-color: #555555; font-size: 30px; color: white; text-align: center; padding-top: 20px; padding-bottom: 20px;">Restorani</div>
	
		<%@ include file="menu.jsp" %>
	
			<h2>Moji Prijatelji</h2>
			
			<table title="Moji prijatelji" border="1"  >
					
					<tr>
						<th>Moji prijatelji</th>
					
					
					</tr>
					<c:forEach items="${prijateljiGost.prijatelji}" var="prijatelj">
						<tr>
				
							<td>${prijatelj.ime}&nbsp&nbsp${prijatelj.prezime}</td>
							<td><a href="ObrisiPrijateljaServlet?id=${prijatelj.id}">Obrisi</a></td>
		
						</tr>
					</c:forEach>
			</table>
			<br>
			
			<form method="post" action="PretrazivanjePrijateljaServlet">
				<table>
					<tr>
						<th>Pretraga</th>
						<td><input type="text" name="imePrzime"  alt="Upisite Ime ili Prezime"  /></td>
					</tr>
					<tr>
						<th>&nbsp;</th>
						
						<td><input type="submit" value="Pretrazi" /><input type="hidden" name="saPrijatelja"></td>
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
						<td><a href="PrijateljiServlet?id=${gostNadjen.id}&saPrijatelja=${gostNadjen.id}" >Dodaj</a></td>
						
					
					</tr>
				</c:forEach>
				</table>
			</c:if>
			
			<c:if test="${lista!=null && lista.isEmpty() == true}">
				<p>Nije nista pronadjeno</p>
			</c:if>
			
			
	
</div>

	
</body>
</html>