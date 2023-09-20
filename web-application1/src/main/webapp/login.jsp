<%-- 
    Document   : login
    Created on : 15-Mar-2023, 10:11:56 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title></head>
    <body>
        <div align = "center">
            <h1>Welcome Enter Your Credential</h1>
            <form action = "j_security_check" method = "post">
                username   <input type ="text" name = "j_username" /><br/>
                password   <input type = "password" name = "j_password" /><br/>
                <input type = "submit" value = "login" />
            </form>
            <div>
                </body>
                </html>
