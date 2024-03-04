<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
    body, html {
        height: 100%;
        background-color: #c9e0e5; 
        overflow: hidden; 
    }

    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    }
</style>
</head>
<body>

<div class="container">
    <div class="text-center">
        <h2>Welcome to</h2>
        <div class="display-4 mb-4">Zumba Studio</div>
        <h6>Where fitness meets fun!!</h6> 
        <br/><br/>
         <a href="<%=request.getContextPath()%>/list"
                class="btn btn-primary">Get Started Here--></a>
        
    </div>
</div>
</body>
</html>
