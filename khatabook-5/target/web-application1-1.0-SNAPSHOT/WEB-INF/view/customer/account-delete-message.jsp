<%-- 
    Document   : account-delete-message
    Created on : 12-Jun-2023, 1:14:08 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Deletion</title>
    </head>
    <body>
        <h1 align = "center">Account Deletion</h1><hr/>

        <c:if test="${accountDeletionStatus != null}">
            <h2 align = "center" style = "color:green">Your Account deleted successfully</h2>
        </c:if>

        <c:if test="${accountDeletionStatus == null}">
            <h2 align= "center" style = "color:red" >Sorry, Account Deletion failed</h2>
        </c:if>
    </body>
</html>
