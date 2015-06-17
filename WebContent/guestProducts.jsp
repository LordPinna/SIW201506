<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Catalogo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>
			Catalogo<small> <a href="<c:url value="/index.jsp" />"><span
					class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
			</small>
		</h2>

		<table class="table table-hover">
			<tr>
				<th>Nome</th>
				<th>Prezzo</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><a
						href="<c:url value="/controller/product.get?id=${product.id}" />">${product.name}</a></td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>