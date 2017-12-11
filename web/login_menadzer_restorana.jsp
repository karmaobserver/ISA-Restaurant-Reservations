<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login menadzera restorana</title>

<script src="jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div style="margin-left: auto; margin-right: auto; width:920px;">
	<h1>Login menadzera restorana</h1>
	
	
	<form method="post" action="LoginMenadzerRestoranaServlet">
		<table>
			<tr>
				<th>Mail</th>
				<td><input type="text" name="mail" /></td>
			</tr>
			<tr>
				<th>Lozinka</th>
				<td><input type="password" name="lozinka" /></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><input type="submit" value="Prijavi se" /></td>
			</tr>
		</table>
	</form>

						
						<p>${poruka}</p>
	
</div>
</body>
</html>