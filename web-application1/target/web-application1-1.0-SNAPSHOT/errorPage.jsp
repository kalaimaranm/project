<%-- 
    Document   : errorPage
    Created on : 31-Mar-2023, 3:09:02 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error Page</title>
    </head>
    <body><br/><br/><br/>
        <%
        if (exception != null) {
                out.print(exception);
//        out.println("<h1 align = "center">Sorry, Exception occured<br/> Please revisit again....</h1>"+exception.getMessage());
            }
        %>
    </body>
</html>
