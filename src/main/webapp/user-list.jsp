<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Participant Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
	background-color: #e7cece;
}

header {
	background-color: #007bff;
}

.container {
	background-color: #f8f9fa;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-top: 20px;
}

.table-bordered {
	border-radius: 10px;
}

.table-bordered th, .table-bordered td {
	padding: 10px;
}

.btn-success {
	background-color: #28a745;
	border-color: #28a745;
}

.btn-success:hover {
	background-color: #218838;
	border-color: #1e7e34;
}

.btn-edit, .btn-delete {
	background-color: #cdd9e3;
	border-color: #6c757d;
	color: #fff;
}

.btn-edit {
	background-color: #8cb7ef;
	border-color: #495057;
}

.btn-delete {
	background-color: #dc968e;
	border-color: #495057;
}
</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="#" class="navbar-brand"><b>Participant Management
						Application</b></a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">PARTICIPANTS</a></li>
			</ul>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/batches"
					class="nav-link">BATCHES</a></li>
			</ul>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/Login.jsp"
					class="nav-link">LOGOUT</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Participants</h3>
			<hr>
			<div class=" text-left">
				<a href="<%=request.getContextPath()%>/newuser"
					class="btn btn-success">Add Participant</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>GENDER</th>
						<th>EMAIL ID</th>
						<th>ADDRESS</th>
						<th>PHONE NO</th>
						<th>BATCH ID</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="part" items="${listUser}">
						<tr>
							<td><c:out value="${part.id}" /></td>
							<td><c:out value="${part.name}" /></td>
							<td><c:out value="${part.gender}" /></td>
							<td><c:out value="${part.email}" /></td>
							<td><c:out value="${part.address}" /></td>
							<td><c:out value="${part.phone}" /></td>
							<td><c:out value="${part.batch_id}" /></td>
							<td><a href="edituser?id=<c:out value='${part.id}'/>"
								class="btn btn-edit">Edit</a> <a href="deleteuser?id=${part.id}"
								class="btn btn-delete"
								onclick="return confirm('Are you sure you want to delete this participant?')">Delete</a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
