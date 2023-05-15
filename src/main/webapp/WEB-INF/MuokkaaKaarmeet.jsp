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




	<form method="get" action="/muokkaa">
    <input name="nimi" type="hidden" required placeholder="Nimi..." autofocus value="${nimi}" />
    <input name="ika" type="text" required placeholder="Ikä..." value="${ika}" />
    <input name="paino" type="text" required placeholder="Paino..." value="${paino}" />
    <input type="submit" value="Muuta tietoja" />
</form>



</body>
</html>