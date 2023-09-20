<%-- 
    Document   : jstl
    Created on : 10-Apr-2023, 3:19:10 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${null} - not show null <br/> 
        ${2+2} = 4<br/>
        ${2 gt 2} = 4<br/>
        ${2 lt 2} = 4 <br/>
        ${2 eq 2} = 4 <br/>
        ${2 ne 2} = 4 <br/>
        ${2 mod 2} = 4 <br/>
        ${2 div 2} = 4 <br/>
        ${2 * 2} = 4 <br/>
        ${2 - 2} = 4 <br/>
        ${2 gt 2 || 2 lt 3} = 4 <br/>
        ${2 gt 2 or 2 lt 3} = 4 <br/>
        ${2 gt 2 && 2 lt 1} = 4 <br/>
        ${2 gt 2 and 2 lt 1} = 4 <br/>
    </body>
</html>
