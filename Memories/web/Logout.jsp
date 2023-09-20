<%-- 
    Document   : Logout
    Created on : 11-Dec-2022, 10:12:42 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        <h1>Logout Page</h1>
        <!--        <form action="Logout.jsp" >
                    <input type="submit" value="logout">
                </form>-->
        <%
            String userId = (String) session.getAttribute("userIds");  // problem facing when I use .toString() nullPointerException so use (String)
            if (!(userId == null)) {
                session.removeAttribute("userIds");
                session.invalidate();     // Destroys the session for this user.
                out.println("<h2>Logout Successfully....!</h2>");
            } else {
                response.sendRedirect("index.html");
            }%>

    </body>
</html>
