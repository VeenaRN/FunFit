<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Participants Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body {
	background-color: #e7cece;
}

.card {
	margin-top: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.card-body {
	padding: 20px;
}

.form-group {
	margin-bottom: 20px;
}

button[type="submit"] {
	background-color: #28a745;
	color: #fff;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #007bff;">
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${batch != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${batch == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${batch != null}">
                        Edit Batch
                    </c:if>
						<c:if test="${batch == null}">
                        Add New Batch
                    </c:if>
					</h2>
				</caption>

				<c:if test="${batch != null}">
					<input type="hidden" name="id"
						value="<c:out value='${batch.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Batch Name</label> <input type="text"
						value="<c:out value='${batch.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Timings</label> <input type="text"
						value="<c:out value="${batch.time}" />" class="form-control"
						name="time" placeholder="HH:MM AM/PM"
						pattern="(0[1-9]|1[0-2]):[0-5][0-9] [APap][mM]"
						title="Enter time in HH:MM AM/PM format">


				</fieldset>



				<fieldset class="form-group">
					<label>Instructor</label> <input type="text"
						value="<c:out value='${batch.instructor}' />" class="form-control"
						name="instructor">
				</fieldset>

				<fieldset class="form-group">
					<label>Location</label> <input type="text"
						value="<c:out value='${batch.location}' />" class="form-control"
						name="location">
				</fieldset>
				<!-- 
				<fieldset class="form-group">
					<label>Session Type</label> <input type="text"
						value="<c:out value='${batch.session_type}' />"
						class="form-control" name="session_type">
				</fieldset>
 -->
				<fieldset class="form-group">
					<label>Session Type</label> <select class="form-control"
						name="session_type">
						<option value="Morning">Morning</option>
						<option value="Afternoon">Afternoon</option>
						<option value="Evening">Evening</option>
					</select>
				</fieldset>



				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
