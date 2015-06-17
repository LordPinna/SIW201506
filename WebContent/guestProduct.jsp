<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Dettagli</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>
			Dettagli<small> <a
				href="<c:url value="/guestProducts.jsp" />"><span
					class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
			</small>
		</h2>

		<dl class="dl-horizontal">
			<dt>Nome</dt>
			<dd>${product.name}</dd>
			<dt>Prezzo</dt>
			<dd>${product.price}</dd>
			<dt>Descrizione</dt>
			<dd>${product.description}</dd>
			<dt>Disponibilità</dt>
			<dd>
				<c:choose>
					<c:when test="${product.stockQuantity <= 0}">Non disponibile</c:when>
					<c:otherwise>Disponibile</c:otherwise>
				</c:choose>
			</dd>
		</dl>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>