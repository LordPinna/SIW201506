<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.form-inline input[type="number"] {
	width: 50px;
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

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
<title>Catalogo</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script type="text/javascript">
	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})
</script>
</head>
<body>
	<div class="container">
		<h2>
			Catalogo <small><a href="<c:url value="/customerHome.jsp" />">
					<span class="glyphicon glyphicon-home" aria-hidden="true"
					data-toggle="tooltip" data-placement="span" title="Home"></span>
			</a>&nbsp<c:if test="${empty currentOrder}">
					<a href="<c:url value="/controller/order.create" />"><span
						class="glyphicon glyphicon-list-alt" aria-hidden="true"
						data-toggle="tooltip" data-placement="span" title="Crea un'ordine"></span></a>
				</c:if></small>
		</h2>
		<br>
		<table class="table table-hover">
			<tr>
				<th>Nome</th>
				<th>Codice</th>
				<th>Prezzo</th>
				<th>Descrizione</th>
				<c:if test="${not empty currentOrder}">
					<th>Quantità</th>
				</c:if>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.name}</td>
					<td>${product.code}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
					<c:if test="${not empty currentOrder}">
						<td><form class="form-inline"
								action="<c:url value="/controller/orderline.add"/>" method="get">
								<div class="form-group">
									<label class="sr-only" for="quantity">Quantità</label> <input
										type="number" name="quantity" required> <input
										type="hidden" value="${product.price}" class="form-control"
										name="unitPrice"> <input type="hidden"
										value="${product.name}" name="item">
								</div>
								<button type="submit" class="btn btn-default">Aggiungi
									all'ordine</button> ${quantityError}
							</form></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<h3>${yourOrder}</h3>
		<c:if test="${not empty currentOrder}">
			<table class="table table-hover">
				<tr>
					<th>Nome</th>
					<th>Prezzo</th>
					<th>Quantità</th>
					<th></th>
				</tr>
				<c:forEach var="orderLine" items="${currentOrderLines}">
					<tr>
						<td>${orderLine.item}</td>
						<td>${orderLine.unitPrice}</td>
						<td>${orderLine.quantity}</td>
						<td><form class="form-inline"
								action="<c:url value="/controller/orderline.remove"/>"
								method="get">
								<input type="hidden" value="${orderLine.item}" name="item">
								<button type="submit" class="btn btn-default">Rimuovi
									dall'ordine</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
			<div class="sin">
				<a href="<c:url value="/controller/order.cancel"/>">
					<button type="submit" class="btn btn-danger">
						Annulla l'ordine <span class="glyphicon glyphicon-remove"
							aria-hidden="true"></span>
					</button>
				</a>
			</div>
			<div class="des">
				<a href="<c:url value="/newOrder.jsp"/>">
					<button type="submit" class="btn btn-default">
						Vai al riepilogo <span
							class="glyphicon glyphicon-circle-arrow-right" aria-hidden="true"></span>
					</button>
				</a> <br> <br>
			</div>
		</c:if>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>