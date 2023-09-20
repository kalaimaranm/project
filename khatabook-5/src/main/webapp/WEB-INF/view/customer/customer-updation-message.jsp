<%-- 
    Document   : customer-updation-message
    Created on : 12-Jun-2023, 2:53:21 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updation Message</title>
    </head>
    <body>
        <h1 align = "center">Customer Updation Status</h1><hr/>
        <c:if test="${updateCustomerStatus != null}">

            <h2 align = "center" style = "color:green">updation successfull</h2>
            <h2 align = "center" style = "color:green">To check updation profile click button</h2>
            <button><a href="viewcustomerprofile?phone=${phone}">view profile</a></button>
        </c:if>
        <c:if test="${updateCustomerStatus == null}">
            <h2 align = "center" style = "color:red">updation failed</h2>
            <h2 align = "center" style = "color:red">please try again</h2>


        </c:if>

    </body>
</html>
