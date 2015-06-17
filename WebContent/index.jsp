<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Log in</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//localhost:8080/SIW201506_Pinna/css/signin.css">
<style>
h4 {
	color: #A0CE00;
}
</style>
</head>
<body>
	<div class="container">
		<h2 class="form-signin-heading" align="center">Benvenuto in
			SIW201506</h2>
		<h4 align="center">${success}</h4>
		<form class="form-signin"
			action="<c:url value="/controller/login.do"/>" method="post">
			<input type="text" name="username" class="form-control"
				placeholder="Indirizzo e-mail" required autofocus> <input
				type="password" name="password" class="form-control"
				placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>${loginErr}
		</form>
		<div align="center">
			<strong>oppure</strong> <br> <a
				href="<c:url value="/newCustomer.jsp" />"><button
					class="btn btn-lg btn-primary btn-block" type="button">Registrati</button></a>
			<a href="<c:url value="/controller/product.list" />">Visualizza
				il catalogo</a>
		</div>
	</div>
</body>
</html>