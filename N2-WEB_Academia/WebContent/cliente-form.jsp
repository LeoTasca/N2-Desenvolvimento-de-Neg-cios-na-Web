<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
			crossorigin="anonymous">
		<title>Academia</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Aplicação</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link active" aria-current="page"
							href="<%=request.getContextPath()%>/list">Clientes</a>
					</div>
				</div>
			</div>
		</nav>
		<div class="container col-md-5">
			<div class="card">
				<c:if test="${ clientes != null }">
					<h5 class="card-header">Editar Cliente</h5>
					<form action="update" method="post">
				</c:if>
				<c:if test="${ clientes == null }">
					<h5 class="card-header">Adicionar Cliente</h5>
					<form action="insert" method="post">
				</c:if>
				<div class="card-body">
					<c:if test="${ clientes != null }">
						<input type="hidden" name="id"
							value="<c:out value='${ clientes.id }' />" />
					</c:if>
					<div class="mb-3">
						<label for="name" class="form-label">Cliente:</label> <input
							type="text" class="form-control" name="nome" maxlength="120"
							value="<c:out value='${ clientes.nome }' />" />
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Matrícula:</label> <input
							type="number" class="form-control" name="matricula" maxlength="5"
							value="<c:out value='${ clientes.matricula }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Bairro:</label> <input
							type="text" class="form-control" name="bairro" maxlength="120"
							value="<c:out value='${ clientes.bairro }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Cidade:</label> <input
							type="text" class="form-control" name="cidade"
							value="<c:out value='${ clientes.cidade }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">CEP:</label> <input
							type="text" class="form-control" name="cep" placeholder="00000-000" maxlength="9"
							value="<c:out value='${ clientes.cep }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Estado:</label> <input
							type="text" class="form-control" name="estado" placeholder="Ex. SC"
							value="<c:out value='${ clientes.estado }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Logradouro:</label> <input
							type="text" class="form-control" name="logradouro"
							value="<c:out value='${ clientes.logradouro }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Numero:</label> <input
							type="text" class="form-control" name="numero" maxlength="11"
							value="<c:out value='${ clientes.numero }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Modalidade:</label> <input
							type="text" class="form-control" name="modalidade"
							value="<c:out value='${ clientes.modalidade }' />" />
					</div>
					<div class="mb-3">
						<label for="country" class="form-label">Descrição:</label> <input
							type="text" class="form-control" name="descricao"  maxlength="120"
							value="<c:out value='${ clientes.descricao }' />" />
					</div>
					<button type="submit" class="btn btn-success">Salvar</button>
				</div>
	
	
			</div>
		</div>
	</body>
</html>