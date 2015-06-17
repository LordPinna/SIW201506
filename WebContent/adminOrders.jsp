<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Ordini</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>
			Lista ordini <small><a
				href="<c:url value="/adminHome.jsp" />"> <span
					class="glyphicon glyphicon-home" aria-hidden="true"
					data-toggle="tooltip" data-placement="span" title="Home"></span>
			</a></small>
		</h2>

		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Creato il</th>
				<th>Chiuso il</th>
				<th>Evaso il</th>
			</tr>
			<c:forEach var="order" items="${orders}">
				<tr>
					<td><a
						href="<c:url value="/controller/order.get?orderId=${order.id}" />">${order.id}</a></td>
					<td>${order.creationTime}</td>
					<td>${order.closedTime}</td>
					<td>${order.deliveryDate}</td>
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