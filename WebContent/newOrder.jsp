<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.sin {
	margin: 0;
	padding: 0;
	width: 200px;
	background: transparent;
	float: left;
}

.des {
	margin: 0;
	padding: 0;
	width: 200px;
	background: transparent;
	float: right;
	text-align: right;
}
</style>
<meta charset="US-ASCII">
<title>Riepilogo dell' ordine</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<style type="text/css">
ul {
	width: 200px
}
</style>
</head>
<body>
	<div class="container">
		<h3>
			Riepilogo dell' ordine ${currentOrder.id}
			<c:if test="${empty orderCompleted}">
				<small> <a href="<c:url value="/customerProducts.jsp" />"><span
						class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
				</small>
			</c:if>
		</h3>

		<table class="table table-hover">
			<tr>
				<th>Nome</th>
				<th>Quantità</th>
				<th>Prezzo unitario</th>
				<th>Prezzo totale</th>
			</tr>
			<c:forEach var="orderLine" items="${currentOrderLines}">
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
				<td><strong>${totalPrice}</strong></td>
			</tr>
		</table>
		<c:if test="${not empty orderCompleted}">
			<p class="text-center">
				<strong>${orderCompleted}</strong><br>Puoi visualizzarlo nella
				sezione <br> <a href="<c:url value="/controller/order.list"/>"><em>I
						tuoi ordini</em></a><br>oppure torna alla<br> <a
					href="<c:url value="/customerHome.jsp" />"><em>Home</em></a>
			</p>
		</c:if>

		<c:if test="${empty orderCompleted}">
			<div class="sin">
				<a href="<c:url value="/controller/order.cancel"/>">
					<button type="submit" class="btn btn-danger">
						Annulla l'ordine <span class="glyphicon glyphicon-remove"
							aria-hidden="true"></span>
					</button>
				</a>
			</div>
			<div class="des">
				<a href="<c:url value="/controller/order.close"/>">
					<button type="submit" class="btn btn-success">
						Conferma l'ordine <span class="glyphicon glyphicon-ok"
							aria-hidden="true"></span>
					</button>
				</a>
			</div>
		</c:if>
	</div>
</body>
</html>