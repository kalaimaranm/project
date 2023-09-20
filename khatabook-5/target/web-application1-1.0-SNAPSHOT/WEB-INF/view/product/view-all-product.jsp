<%-- 
    Document   : view-all-product
    Created on : 09-Jun-2023, 2:11:05 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>CodePen - Responsive Tables using LI</title>
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="./style.css">
        <style>
            body {
                font-family: 'lato', sans-serif;
            }

            .container {
                max-width: 1200px;
                margin-left: auto;
                margin-right: auto;
                padding-left: 10px;
                padding-right: 10px;
            }
            #update{
                text-decoration: none;
            }

            h2 {
                font-size: 26px;
                margin: 20px 0;
                text-align: center;
            }
            h2 small {
                font-size: 0.5em;
            }

            .responsive-table li {
                border-radius: 3px;
                padding: 25px 30px;
                display: flex;
                justify-content: space-between;
                margin-bottom: 25px;
            }
            .responsive-table {

                /*width:100px;*/

            }
            .responsive-table .table-header {
                background-color: #95A5A6;
                font-size: 14px;
                text-transform: uppercase;
                letter-spacing: 0.03em;
            }
            .responsive-table .table-row {
                background-color: #ffffff;
                box-shadow: 0px 0px 9px 0px rgba(0, 0, 0, 0.1);
            }
            .responsive-table .col-1 {
                flex-basis: 10%;
            }
            .responsive-table .col-2 {
                flex-basis: 40%;
            }
            .responsive-table .col-3 {
                flex-basis: 25%;
            }
            .responsive-table .col-4 {
                flex-basis: 25%;
            }
            @media all and (max-width: 767px) {
                .responsive-table .table-header {
                    display: none;
                }
                .responsive-table li {
                    display: block;
                }
                .responsive-table .col {
                    flex-basis: 100%;
                }
                .responsive-table .col {
                    display: flex;
                    padding: 10px 0;
                }
                .responsive-table .col:before {
                    color: #6C7A89;
                    padding-right: 10px;
                    content: attr(data-label);
                    flex-basis: 50%;
                    text-align: right;
                }
            }
        </style>
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="container">
            <h2>Products</h2>
            <ul class="responsive-table">
                <li class="table-header">
                    <div class="col col-1">Id</div>
                    <div class="col col-2">Name</div>
                    <div class="col col-3">Cost Per Unit</div>
                    <div class="col col-4">Profit Per Unit Price</div>
                    <div class="col col-4">Weight(gm/kg)</div>
                    <div class="col col-4">Quantity</div>
                    <div class="col col-4">Update Qty</div>
                </li>

                <c:forEach items="${products}" var="product" >
                    <c:if test="${product.status == true}">
                        <li class="table-row">
                            <div class="col col-1" data-label="Job Id">${product.id}</div>
                            <div class="col col-2" data-label="Customer Name">${product.name}</div>
                            <div class="col col-3" data-label="Amount">&#8377;${product.price}</div>
                            <div class="col col-4" data-label="Payment Status">${product.profitPerUnit}</div>
                            <div class="col col-4" data-label="Payment Status">${product.weight}</div>
                            <div class="col col-4" data-label="Payment Status">${product.quantity}</div>
                            <div class="col col-4" data-label="Payment Status"><button><a id ="update" href = "updateproductform?productId=${product.id}">update</a></button></div>
                            <div class="col col-4" data-label="Payment Status" onclick="ConfirmDelete()"><button><a id ="delete" href = "deleteproduct?productId=${product.id}">delete</a></button></div>
                        </li>
                    </c:if>
                    <!-- -->
                </c:forEach>

            </ul>
        </div>
        <script>
            function ConfirmDelete() {

                return confirm(`Are you sure you want to delete?`);
            }


        </script>

    </body>
</html>

