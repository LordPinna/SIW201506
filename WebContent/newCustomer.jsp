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
		<h2>Inserisci i tuoi dati</h2>
		<form class="form-horizontal"
			action="<c:url value ="/controller/customer.add"/>" method="post">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">Nome:</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="firstName"
						placeholder="Nome" required>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">Cognome:</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="lastName"
						placeholder="Cognome" required>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-3">
					<input type="email" class="form-control" name="email"
						placeholder="Email" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-2">
					<input type="password" class="form-control" name="password"
						placeholder="Password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="dateOfBirth" class="col-sm-2 control-label">Data
					di nascita:</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="dateOfBirth"
						placeholder="GG/MM/AA" required>
				</div>
			</div>
			<div class="form-group">
				<label for="street" class="col-sm-2 control-label">Via:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="street"
						placeholder="Via, p.zza, ecc." required>
				</div>
			</div>
			<div class="form-group">
				<label for="city" class="col-sm-2 control-label">Città:</label>
				<div class="col-sm-1">
					<input type="text" class="form-control" name="city"
						placeholder="Città" required>
				</div>
			</div>
			<div class="form-group">
				<label for="zipcode" class="col-sm-2 control-label">CAP:</label>
				<div class="col-sm-1">
					<input type="text" class="form-control" name="zipcode"
						placeholder="CAP" required>
				</div>
			</div>
			<div class="form-group">
				<label for="country" class="col-sm-2 control-label">Paese:</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="country"
						placeholder="Paese" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Conferma i
						tuoi dati</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>