<%-- 
    Document   : sqlTags
    Created on : 11-Apr-2023, 4:34:30 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="jakarta.tags.core"%>
<%@taglib prefix = "sql" uri="jakarta.tags.sql" %>%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC</title>
    </head>
    <body>
        <h1>JDBC Connectivity</h1>
        <sql:setDataSource var="connectio" url="jdbc:mysql://bassure.in:3306/kalaimaran_db" user="Kalai" password="Kalai@4321" />
        <sql:query dataSource="${connectio}" var="result" sql= "select * from customer" />
        <c:forEach items="result.rows" var= "customer">
            ${customer[0]}
            ${customer[1]}
            ${customer[2]}
            ${customer[3]}
            ${customer[4]}
        </c:forEach>
        
    </body>
</html>
