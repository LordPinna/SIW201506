<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Catalogo</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>
			Catalogo<small><a href="<c:url value="/adminHome.jsp" />">
					<span class="glyphicon glyphicon-home" aria-hidden="true"
					data-toggle="tooltip" data-placement="span" title="Home"></span>
			</a></small>
		</h2>
		<table class="table table-hover">
			<tr>
				<th>Nome</th>
				<th>Codice</th>
				<th>Prezzo</th>
				<th>Quantità in magazzino</th>
				<th></th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.name}</td>
					<td>${product.code}</td>
					<td>${product.price}</td>
					<td>${product.stockQuantity}</td>
					<td><div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="actions" data-toggle="dropdown" aria-expanded="true">
								Azione <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu"
								aria-labelledby="dropdownMenu1">
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="<c:url value="/controller/product.get?id=${product.id}"/>">Dettagli</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="#">Modifica</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="#">Rimuovi</a></li>
							</ul>
						</div></td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" class="btn btn-default" data-toggle="modal"
			data-target="#myModal">Aggiungi un prodotto</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Nuovo prodotto</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal"
							action="<c:url value="/controller/product.add" />" method="post">
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">Nome:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="name"
										placeholder="Nome" required>
								</div>
							</div>
							<div class="form-group">
								<label for="code" class="col-sm-2 control-label">Codice:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="code"
										placeholder="Codice" required>
								</div>
							</div>
							<div class="form-group">
								<label for="price" class="col-sm-2 control-label">Prezzo:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="price"
										placeholder="Prezzo" required>
								</div>
							</div>
							<div class="form-group">
								<label for="stockQuantity" class="col-sm-2 control-label">Quantità:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="stockQuantity"
										placeholder="Quantità" required>
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">Descrizione:</label>
								<div class="col-sm-7">
									<textarea class="form-control" rows="3" name="description"
										placeholder="Descrizione"></textarea>
								</div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default">Conferma</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Chiudi</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>