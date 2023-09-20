<%-- 
    Document   : JSP
    Created on : 27-Nov-2022, 1:10:08 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>TODO write content</div>
        <h1 style="color:#f00">Addition</h1>

        <form action="addition" method="post">
            <label>Enter Number1</label>
            <input type="text" name="num1"><br/>
            <label>Enter Number2</label>
            <input type="text" name="num2"><br/>
            <input type="submit">
        </form>
        <%
            int i1 = Integer.parseInt(request.getParameter("num1"));
            int i2 = Integer.parseInt(request.getParameter("num2"));
            int total = i1 + i2;
            out.println(total);

        %>
    </body>
</html>
