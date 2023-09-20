<%-- 
    Document   : form
    Created on : 20-Jul-2023, 1:59:58 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Data</h1>

        <form action="submit-form">
            <label for="firstname">First name: </label>
            <input type="text" name="firstname"  required>
            <br>
            <label for="lastname">Last name: </label>
            <input type="text" name="lastname"  required>
            <br>
            <label for="email">email: </label>
            <input type="email" name="email"  required>
            <br>
            <label for="password">password: </label>
            <input type="password" name="password"  required>
            <br>
            <input type="submit" value="Login!">
        </form>
    </body>
</html>
