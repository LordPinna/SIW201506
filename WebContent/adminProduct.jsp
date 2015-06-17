<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Log in</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>
			Dettagli <small>${product.name} <a
				href="<c:url value="/controller/product.list" />"><span
					class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
			</small>
		</h2>
		<div align="right">
			<a href="<c:url value="/adminProducts.jsp" />">Torna al catalogo</a>
		</div>
		<dl class="dl-horizontal">
			<dt>Nome:</dt>
			<dd>${product.name}</dd>
			<dt>Codice:</dt>
			<dd>${product.code}</dd>
			<dt>Prezzo:</dt>
			<dd>Euro ${product.price}</dd>
			<dt>Quantità in magazzino:</dt>
			<dd>${product.stockQuantity}</dd>
			<dt>Descrizione:</dt>
			<dd>${product.description}</dd>
		</dl>
	</div>
</body>
</html>
