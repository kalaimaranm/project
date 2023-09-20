<%-- 
    Document   : add-product-message
    Created on : 08-Jun-2023, 10:47:19 pm
    Author     : bas200193
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>

        <h1>Product addition status</h1>

        <c:if test="${producAdditionStatus != null}">

            <hr/>
            <h2 style="color:green;" align = 'center'>Product Added to Inventary Successfully...</h2>            <h2>Product ID : ${product.id}</h2>
            <h2>Product Name : ${product.name}</h2>
            <h2>Product Profit : ${product.profitPerUnit}</h2>
            <h2>Product Weight : ${product.weight}</h2>
            <h2>Product Quantity : ${product.quantity}</h2>
            <h2>Date-Time : ${product.dateTime}</h2>

        </c:if>
        <c:if test="${producAdditionStatus == null}">

            <div style="color:red;"><h2 align = 'center'> Product Failed to add</h2>
                <h2 align = 'center'> Please try again</h2></div>
            </c:if>
    </body>
</html>
