<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Kaarmetalo</title>
<link href="/styles/tyyli.css" rel="stylesheet" type="text/css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>

<body>


	<h1>Käärmetalo</h1>
	
	<h2>Luettelo kaikista lämpöpiilon asukkaista!</h2>

	<c:forEach items="${lista}" var="lista" varStatus="vStatus">
	<table class="table">
		<tr>
			
					<td><c:out value="${lista.ika} vuotias " /></td>
					<td><c:out value="${lista.nimi} " /></td>					
					<td><c:out value="${lista.paino}g " /></td>				
					<img src="/img/karmes.png" alt="kuva" class="kuvituskuva">
		</tr>
	</table>
	</c:forEach>
	<form action="/kaarmetalo">
		<p>Palaa takaisin <input type="submit" name="piilo" value="käärmetalo"/> välilehdelle. </p>
		
	</form>


</body>
</html>