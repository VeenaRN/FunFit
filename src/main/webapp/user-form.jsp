<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Participants Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #4285f4;"> <!-- Use lighter blue color -->
            <div>
                <a href="https://www.xadmin.net" class="navbar-brand"> Participant Management Application </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">PARTICIPANTS</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/batches" class="nav-link">BATCHES</a></li>
            </ul>
            
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/Login.jsp" class="nav-link">LOGOUT</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${user != null}">
                    <form action="updateuser" method="post">
                </c:if>
                <c:if test="${user == null}">
                    <form action="insertuser" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${user != null}">
                    <input type="hidden" name="participant_id" value="<c:out value='${user.participant_id}' />" />
                </c:if>

                <fieldset class="form-group">
                    <label> Name</label>
                    <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="name" required="required">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Age</label>
                    <input type="text" value="<c:out value='${user.age}' />" class="form-control" name="age" required="required">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Email</label>
                    <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Phone</label> 
                    <input type="text" value="<c:out value='${user.phone}' />" class="form-control" name="phone">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Batch Name</label> 
                    <input type="text" value="<c:out value='${user.batchname}' />" class="form-control" name="batchname">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Address</label>
                    <input type="text" value="<c:out value='${user.address}' />" class="form-control" name="address">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
