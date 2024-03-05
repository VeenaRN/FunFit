<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="com.funfit.connection.DBConnection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>

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

header {
	background-color: #4285f4;
}

.card {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-top: 20px;
	max-height: 80vh;
	overflow-y: auto;
}

.form-group {
	margin-bottom: 15px;
}

.btn-success {
	background-color: #28a745;
	border-color: #28a745;
}

.btn-success:hover {
	background-color: #218838;
	border-color: #1e7e34;
}

table {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-top: 20px;
}

th, td {
	padding: 10px;
	text-align: center;
}

thead {
	background-color: #007bff;
	color: #fff;
}

input[type="text"] {
	width: calc(100% - 20px);
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #4285f4;">
			<!-- Use lighter blue color -->
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> <b>
						Participant Management Application </b></a>
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
				<c:if test="${part != null}">
					<form action="updateuser" method="post">
				</c:if>
				<c:if test="${part== null}">
					<form action="insertuser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${part != null}">
                            Edit Participant
                        </c:if>
						<c:if test="${part == null}">
                            Add New Participant
                        </c:if>
					</h2>
				</caption>

				<c:if test="${part != null}">
					<input type="hidden" name="id" value="<c:out value='${part.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${part.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<!--  
                <fieldset class="form-group">
                    <label>Gender</label>
                    <input type="text" value="<c:out value='${part.gender}' />" class="form-control" name="gender" required="required">
                </fieldset>
                
                -->
				<fieldset class="form-group">
					<label>Gender</label>

					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="male" value="Male"
							<c:if test="${part.gender == 'male'}">checked</c:if>> <label
							class="form-check-label" for="male"> Male </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="female" value="Female"
							<c:if test="${part.gender == 'female'}">checked</c:if>> <label
							class="form-check-label" for="female"> Female </label>
					</div>


				</fieldset>


				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${part.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${part.address}' />" class="form-control"
						name="address">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${part.phone}' />" class="form-control"
						name="phone" pattern="\d{10}"
						title="Please enter a 10-digit phone number" required> <small
						class="form-text text-muted">Enter a 10-digit phone
						number.</small>
				</fieldset>

				<!--  
                <fieldset class="form-group">
                    <label>Batch Id</label> 
                    <input type="text" value="<c:out value='${part.batch_id}' />" class="form-control" name="batch_id">
                </fieldset>
               -->

				<div class="form-group">
					<label for="batch_id" class="form-label">Batch ID</label> <select
						class="form-select" id="batch_id" name="batch_id" required>
						<option value="">Select Batch</option>

						<%
						try {
							Connection conn = DBConnection.getConnection();
							Statement stmt = conn.createStatement();
							ResultSet rs = stmt.executeQuery("select id,name from batches");
							while (rs.next()) {
								int batch_id = rs.getInt("id");
								String batchName = rs.getString("name");
						%>
						<option value="<%=batch_id%>"><%=batchName%></option>

						<%
						}
						conn.close();
						} catch (Exception e) {
						e.printStackTrace();
						}
						%>
					</select>
				</div>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
