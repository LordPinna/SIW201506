<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Home</title>
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
		<h1>Benvenuto, ${administrator.username}</h1>
		<h2>Home</h2>
		<ul class="nav nav-pills nav-stacked">
			<li role="presentation"><a
				href="<c:url value="/controller/product.list"/>">Consulta il
					catalogo <span class="glyphicon glyphicon-th-list"
					aria-hidden="true"></span>
			</a></li>
			<li role="presentation"><a
				href="<c:url value="/controller/customer.list"/>">Visualizza i
					clienti <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
			</a></li>
			<li role="presentation"><a
				href="<c:url value="/controller/order.list"/>">Visualizza gli
					ordini <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
			</a></li>
			<li role="presentation"><a
				href="<c:url value="/controller/logout.do"/>">Logout <span
					class="glyphicon glyphicon-off" aria-hidden="true"></span>
			</a></li>
		</ul>
	</div>
</body>
</html>