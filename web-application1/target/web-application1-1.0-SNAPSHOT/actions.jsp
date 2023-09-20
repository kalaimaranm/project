<%-- 
    Document   : actions
    Created on : 31-Mar-2023, 3:38:23 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .divi{
                border:1px solid;
            }
        </style>
    </head>
    SessionID: ${cookie["JSESSIONID"]["value"]}<br/>
    SessionID: ${cookie["JSESSIONID"].value}<br/>
    Host : ${header.host}<br/>
    Host : ${header["host"]}<br/>
    ${headerValues.accept[0]}<br/>
    ${headerValues.accept[1]}<br/>
    myYear : ${param.myYear} <br/>
    Hobbies : ${paramValues.hobbie[0]} <br/>
    Hobbies :${paramValues.hobbie[1]} <br/>
   Hobbies : ${paramValues.hobbie[2]}
    <body>
        <%--<jsp:forward><jsp:forward>--%>
        <%--<jsp:>--%>
        <jsp:element name="div">
            <jsp:attribute name="style" trim="true"> 
                color:green; font-size:60px;
            </jsp:attribute>
            <jsp:attribute name="class">divi</jsp:attribute>
            <jsp:body>Hello</jsp:body>

        </jsp:element>


        <jsp:useBean id = "customer" class="in.web.dao.CustomerClass" scope="request">
            <%--<jsp:getProperty name="customer" property="name" ></jsp:getProperty>--%>
            <jsp:setProperty name="customer" property="*"></jsp:setProperty>
            <jsp:getProperty name="customer" property="id" ></jsp:getProperty>
            <jsp:setProperty name="customer" property="*" ></jsp:setProperty>
            <jsp:getProperty name="customer" property="name" ></jsp:getProperty>
            <jsp:setProperty name="customer" property="*" ></jsp:setProperty>
            <jsp:getProperty name="customer" property="phone" ></jsp:getProperty>
        </jsp:useBean>

    </body>
</html>
