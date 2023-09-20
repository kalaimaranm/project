<%-- 
    Document   : viewPage
    Created on : 27-Mar-2023, 3:13:08 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List,in.web.dao.CustomerClass" isELIgnored="false" errorPage="errorPage.jsp" %>
<%--<%@include file="text.txt" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <%
//            out.print("<h1 align = 'center'>Time is : "+java.time.LocalDateTime.now()+"</h1>");
       
        %>

        <!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->
        <style>
            table.GeneratedTable {
                width: 100%;
                border-collapse: collapse;
                border-width: 2px;
                border-style: solid;
            }

            table.GeneratedTable td, table.GeneratedTable th {
                border-width: 2px;
                border-style: solid;
                padding: 3px;
            }

            table.GeneratedTable thead {
                background-color: #ffcc00;
            }
        </style>

        <!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->
        <table class="GeneratedTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>AadhaarNo</th>
                    <th>Debt_Balance</th>
                    <th>wallet_Balance</th>
                    <th>status</th>
                </tr>
            </thead>
            2+3=${2+3}
            <tbody>
                
                <% //    int i = Integer.paseInt("name");
//                    throw new NumberFormatException();
               int i = 10/0;
                     String nu = null;
//                         if (request.getAttribute("student") != null) {
//                         
//                    }
//                  if (Objects.nonNull(nu)) {
                  
//                    }
//                 else {
//                    throw new NullPointerException("null pointer exception");
//                    }
                    List<CustomerClass> customers = (List<CustomerClass>)request.getSession().getAttribute("customerList");
                    for(CustomerClass customer : customers) {
                out.println("<tr><td>"+customer.getId()+"</td><td>"+customer.getName()+"</td>"+customer.getPhone()+"<td>"+customer.getAadhaar()+"</td></tr>");
                    
                    }
                %>



            </tbody>
        </table>

    </body>
</html>
