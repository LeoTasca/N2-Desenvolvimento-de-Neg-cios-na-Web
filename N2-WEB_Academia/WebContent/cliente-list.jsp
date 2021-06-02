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
		<title>Lista de Clientes</title>
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
							href="<%=request.getContextPath()%>/list">clientes</a>
					</div>
				</div>
			</div>
		</nav>
		<div class="container">
			<h3 class="text-center">Lista de Clientes</h3>
			<hr>
			<div class="container text-left">
				<a class="btn btn-success" href="<%=request.getContextPath()%>/new">Adicionar</a>
			</div>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Matrícula</th>
						<th scope="col">Nome</th>
						<th scope="col">Bairro</th>
						<th scope="col">Cidade</th>
						<th scope="col">CEP</th>
						<th scope="col">Estado</th>
						<th scope="col">Logradouro</th>
						<th scope="col">Numero</th>
						<th scope="col">Modalidade</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="clientes" items="${ listCliente }">
						<tr>
							<td><c:out value="${ clientes.matricula }"></c:out></td>
							<td><c:out value="${ clientes.nome }"></c:out></td>
							<td><c:out value="${ clientes.bairro }"></c:out></td>
							<td><c:out value="${ clientes.cidade }"></c:out></td>
							<td><c:out value="${ clientes.cep }"></c:out></td>
							<td><c:out value="${ clientes.estado }"></c:out></td>
							<td><c:out value="${ clientes.logradouro }"></c:out></td>
							<td><c:out value="${ clientes.numero }"></c:out></td>
							<td><c:out value="${ clientes.modalidade }"></c:out></td>
							<td><c:out value="${ clientes.descricao }"></c:out></td>
							<td><a href="edit?id=<c:out value='${ clientes.id }'/>"
								class="btn btn-primary">Editar</a> <a
								href="delete?id=<c:out value='${ clientes.id }'/>"
								class="btn btn-danger">Excluir</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>