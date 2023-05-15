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

	<h2>Tervetuloa käärmetaloon!</h2>
	<p>
		Käärmetalo on mukava lepopaikka kaikille viljakäärmeille, tällä
		sivulla voit lisätä oman viljakäärmeesi käärmetaloon ja sivun
		alareunasta voit siirtyä<br> käärmetalon lämpöpiiloon
		vierailemaan paikalla olevien viljakäärmeiden luona.
	</p>
	<p>Lämpöpiilo on käärmeelle tärkeä turvapaikka, jossa käärme voi
		lämmitellä.</p>
	<h3>Lämpöpiilon asukkaat</h3>
	<c:forEach items="${lista}" var="lista" varStatus="vStatus">
		<tr>
			<td><c:out value="${lista.nimi}, ${lista.ika}, ${lista.paino} " /></td>
			<td>
				<form action="/poista" method="post">
					<input type="hidden" name="nimi" value="${lista.nimi}">
					<button class="btn btn-danger" type="submit">Delete</button>
				</form>
			</td>
			<td>
    <form action="/muokkaa" method="post">
        <input type="hidden" name="nimi" value="${lista.nimi}">
        <input type="hidden" name="ika" value="${lista.ika}">
        <input type="hidden" name="paino" value="${lista.paino}">
        <button class="btn btn-primary" type="submit">Edit</button>
    </form>
</td>
		</tr>
	</c:forEach>


	<form method="post">
		<input name="nimi" type="text" required placeholder="Nimi..."
			autofocus /> <input name="ika" type="text" required
			placeholder="Ikä..." autofocus /> <input name="paino" type="text"
			required placeholder="Paino..." autofocus /> <input type="submit"
			value="Lisää lämpöpiiloon" />
	</form>
	<form action="/lampopiilo" method="get">
		<p>
			Siirry <input type="submit" name="piilo" value="lämpöpiilo" />
			välilehdelle.
		</p>

	</form>


</body>
</html>