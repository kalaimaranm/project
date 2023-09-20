<%-- 
    Document   : jstl
    Created on : 10-Apr-2023, 4:48:01 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL</title>
    </head>

    <body>
        <c:out value="asjdkf" />
        <c:forTokens delims = "-" items="apple-fruit pineapple-fruit jack-fruit custardapple-fruit" var="word" step="2">
            ${word}<br/>

        </c:forTokens>
        <c:set var="name" value="Java sundaresan" scope="request"></c:set>
        In normal scope Name : ${name} <br/>    In requestScope Name :  ${requestScope.name}

        <br/> In c:out with expression tag <c:out value="${name}"></c:out>
        <br/> In c:out with non-expression tag <c:out value="name" ></c:out>   
        
        <c:catch>
            <% int divisible = 10/0;%>
        </c:catch>
        

    </body>
</html>
