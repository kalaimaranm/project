<%-- 
    Document   : Welcome
    Created on : 10-Dec-2022, 11:29:47 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body><%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.           
        HttpSession session2 = request.getSession();
        //String userName = request.getParameter("userIds");
        String userNameD = (String) session2.getAttribute("userIds");   // problem if I use .toString() it throw exception
        if (userNameD == null) {
            response.sendRedirect("index.html");
        }
        out.println("Welcome " + userNameD);%>
        <form action="Logout.jsp" method="post" >
            <input type="submit" value="logout">
        </form>
    </body>
</html>
