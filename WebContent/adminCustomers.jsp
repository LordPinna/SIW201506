<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Clienti</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>
			Clienti <small><a href="<c:url value="/adminHome.jsp" />">
					<span class="glyphicon glyphicon-home" aria-hidden="true"
					data-toggle="tooltip" data-placement="span" title="Home"></span>
			</a></small>
		</h2>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Indirizzo e-mail</th>
				<th>Data di nascita</th>
				<th></th>
			</tr>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>${customer.dateOfBirth}</td>
					<td><a
						href="<c:url value="/controller/customer.get?id=${customer.id}"/>"><button
								type="submit" class="btn btn-default">Visualizza
								l'indirizzo</button></a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>