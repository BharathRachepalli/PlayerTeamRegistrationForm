<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<title>DisplayPlayer</title>
</head>
<body>

<table border=1 class="table">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Player_Team</th>
		</tr>

		<%-- <%for(Authentication i : authList) {%> --%>

		<c:forEach var="i" items="${player_list}">
					
					
			<tr>
				<td>${i.id }</td>
				<td>${i.name }</td>
				<td>${i.age }</td>
				<td>${i.gender }</td>
				<td>${i.playerTeam }</td>
			</tr>
		</c:forEach>
		<%-- <%} %> --%>

	</table>
<br><br>
<input type="button" value="Main Menu"
		onclick="window.location.href='Login.jsp'; return false;"
		 />

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>