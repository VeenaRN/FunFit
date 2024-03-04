<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #c9e0e5; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #773232;
        }
        .login-container label {
            display: block;
            margin-bottom: 10px;
            color:#773232;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        .login-container input[type="submit"] {
            width: 20%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: #fff;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .login-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            margin-top: 10px;
            text-align: center;
        }
       
        .login-icon {
            text-align: center;
            margin-bottom: 20px;
            font-size: 40px;
            color: #acd5de;
        }
    </style>
</head>
<body>
    <div class="login-container">
       
        <div class="login-icon"><i class="fas fa-user-lock"></i></div>
        <h2>Login Here</h2>
        <form action="userlogin" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
        <% String error = (String) request.getAttribute("error");
        if (error != null) { %>
            <p class="error-message"><%= error %></p>
        <% } %>
    </div>
</body>
</html>
