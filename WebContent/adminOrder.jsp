<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Dettagli dell' ordine</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<style type="text/css">
ul {
	width: 200px
}
</style>
</head>
<body>
	<div class="container">
		<h3>
			Riepilogo dell'ordine ${order.id} <small> <a
				href="<c:url value="/controller/order.list" />"><span
					class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
			</small>
		</h3>
		<table class="table table-hover">
			<tr>
				<th>Nome</th>
				<th>Quantità</th>
				<th>Prezzo unitario</th>
				<th>Prezzo totale</th>
			</tr>
			<c:forEach var="orderLine" items="${orderLines}">
				<tr>
					<td>${orderLine.item}</td>
					<td>${orderLine.quantity}</td>
					<td>${orderLine.unitPrice}</td>
					<c:set var="partialPrice" scope="session"
						value="${orderLine.quantity*orderLine.unitPrice}" />
					<td>${partialPrice}</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td><strong>Totale</strong></td>
				<td><strong>${orderTotalPrice}</strong></td>
			</tr>
		</table>
		<h3>Dati del cliente</h3>
		<address>
			<strong>${order.customer.firstName}
				${order.customer.lastName}</strong><br>${order.customer.address.street}<br>
			${order.customer.address.zipcode} ${order.customer.address.city}<br>
			${order.customer.address.country} <br>
			<a href="mailto:${order.customer.email}">${order.customer.email}</a>
		</address>
		<div align="right">
			<a href="<c:url value="/controller/order.ship?orderId=${order.id}"/>">
				<button type="submit" class="btn btn-success">
					Evadi l'ordine <span class="glyphicon glyphicon-check"
						aria-hidden="true"></span>
				</button>
			</a>
		</div>

	</div>
</body>
</html>