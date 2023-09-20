<%-- 
    Document   : delete-product-message
    Created on : 10-Jun-2023, 10:43:49 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product</title>
    </head>
    <body>
        <h1 align = "center">Product Updation</h1>

        <c:if test="${productdeletionStatus != null}">
            <div align = "center">
                <hr/>
                <!--                <h2 style="color:green;" align = 'center'>Product Updated to Inventary Successfully...</h2>     
                                <h2>Product ID : ${product.id}</h2>
                                <h2>Product Name : ${product.name}</h2>
                                <h2>Product Profit : ${product.profitPerUnit}</h2>
                                <h2>Product Weight : ${product.weight}</h2>
                                <h2>Product Quantity : ${product.quantity}</h2>
                                <h2>Total Quantity : ${totalQuantity}</h2>-->
            </div>
            <div style="color:green;"><h2 align = 'center'>Product Successfully Deleted...</h2>
            </c:if>
            <c:if test="${productdeletionStatus == null}">

                <div style="color:red;"><h2 align = 'center'> Product Failed to update</h2>
                    <h2 align = 'center'> Please try again</h2></div>
                </c:if>

    </body>
</html>
