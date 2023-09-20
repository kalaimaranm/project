

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cart</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>

        <style>
            @charset "UTF-8";
            @import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);

            body {
                font-family: 'Open Sans', sans-serif;
                font-weight: 300;
                line-height: 1.42em;
                color:#A7A1AE;
                background-color:#1F2739;
            }

            h1 {
                font-size:3em;
                font-weight: 300;
                line-height:1em;
                text-align: center;
                color: #4DC3FA;
            }

            h2 {
                font-size:1em;
                font-weight: 300;
                text-align: center;
                display: block;
                line-height:1em;
                padding-bottom: 2em;
                color: #FB667A;
            }

            h2 a {
                font-weight: 700;
                text-transform: uppercase;
                color: #FB667A;
                text-decoration: none;
            }

            .blue {
                color: #185875;
            }
            .yellow {
                color: #FFF842;
            }

            .container th h1 {
                font-weight: bold;
                font-size: 1em;
                text-align: left;
                color: #185875;
            }

            .container td {
                font-weight: normal;
                font-size: 1em;
                -webkit-box-shadow: 0 2px 2px -2px #0E1119;
                -moz-box-shadow: 0 2px 2px -2px #0E1119;
                box-shadow: 0 2px 2px -2px #0E1119;
            }

            .container {
                text-align: left;
                overflow: hidden;
                width: 80%;
                margin: 0 auto;
                display: table;
                padding: 0 0 8em 0;

            }

            .container td, .container th {
                padding-bottom: 2%;
                padding-top: 2%;
                padding-left:2%;
            }

            .container tr:nth-child(odd) {
                background-color: #323C50;
            }

            .container tr:nth-child(even) {
                background-color: #2C3446;
            }

            .container th {
                background-color: #1F2739;
            }

            .container td:first-child {
                color: #FB667A;
            }

            .container tr:hover {
                background-color: #464A52;
                -webkit-box-shadow: 0 6px 6px -6px #0E1119;
                -moz-box-shadow: 0 6px 6px -6px #0E1119;
                box-shadow: 0 6px 6px -6px #0E1119;
            }
            .buy-button {

                border: none;
                background-color: rgb(243, 243, 90);
                width: 200px;
                height: 37px;
                border-radius: 18px;
                font-size: bold;
                font-weight: bold;
                cursor: pointer;
                margin: 20px;
                transform: translateX(500px);
                font-size: 14px;

            }
            td {
                text-shadow:1px 1px 2px #FB667A;
            }
            .col-xl-10, .row ,.col-xl-2,.float-end{

                display: inline;
            }
            .bill{
                display: flex;
                justify-content: space-between;
            }


            @media (max-width: 800px) {
                .container td:nth-child(4),
                .container th:nth-child(4) {
                    display: none;
                }
            }
        </style>
    </head>
    <body>

        <h1>Cart</h1>

        <table class="container">
            <thead>
                <tr>
                    <th><h1>ID</h1></th>
                    <th><h1>Name</h1></th>
                    <th><h1>Price</h1></th>
                    <th><h1>Quantity</h1></th>
                    <th><h1>Amount</h1></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.order.lineItem}" var="lineItem" >
                    <tr>
                        <td>${lineItem.productID}</td>
                        <td>${lineItem.productName}</td>
                        <td>${lineItem.price}</td>
                        <td>${lineItem.quantity}</td>
                        <td>${lineItem.price * lineItem.quantity}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <hr>
        <div class="row" id = "bill">
            <div class="col-10">
                <p>Sub Total</p>
            </div>
            <div class="col-2">
                <p class="float-end">&#8377;${sessionScope.order.total}
                </p>
            </div>
        </div>
        <hr>
    </div>
    <div class="row" id = "bill">
        <div class="col-xl-10">
            <p class = "para">Tax</p>
        </div>
        <div class="col-xl-2">
            <p class="float-end">&#8377;00.00
            </p>
        </div>
        <hr>
    </div>
    <div class="row" id = "bill">
        <div class="col-xl-10">
            <p>Grand Total</p>
        </div>
        <div class="col-xl-2">
            <p class="float-end">&#8377;${sessionScope.order.total}
            </p>
        </div>
        <hr style="border: 2px solid black;">
    </div>

    <a href="payment-page"> <button class = "buy-button" id = "buy-button">Proceed to Buy (${sessionScope.totalProduct} item)</button></a>

</body>
</html>
