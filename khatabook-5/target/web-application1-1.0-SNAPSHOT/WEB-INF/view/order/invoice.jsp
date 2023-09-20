<%-- 
    Document   : invoice
    Created on : 16-Jun-2023, 8:18:59 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Invoice</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>#invoice-POS{
                box-shadow: 0 0 1in -0.25in rgba(0, 0, 0, 0.5);
                padding:2mm;
                margin: 0 auto;
                width: 94mm;
                /*width: 44mm;*/
                background: #FFF;


                ::selection {
                    background: #f31544;
                    color: #FFF;
                }
                ::moz-selection {
                    background: #f31544;
                    color: #FFF;
                }
                h1{
                    font-size: 1.5em;
                    color: #222;
                }
                h2{
                    font-size: .9em;
                }
                h3{
                    font-size: 1.2em;
                    font-weight: 300;
                    line-height: 2em;
                }
                p{
                    font-size: .7em;
                    color: #666;
                    line-height: 1.2em;
                }

                #top, #mid,#bot{ /* Targets all id with 'col-' */
                    border-bottom: 1px solid #EEE;
                }

                #top{
                    min-height: 100px;
                }
                #mid{
                    min-height: 80px;
                }
                #bot{
                    min-height: 50px;
                }

                #top .logo{
                    /*//float: left;*/
                    height: 60px;
                    width: 60px;
                    background: url(http://michaeltruong.ca/images/logo1.png) no-repeat;
                    background-size: 60px 60px;
                }
                .clientlogo{
                    float: left;
                    height: 60px;
                    width: 60px;
                    background: url(http://michaeltruong.ca/images/client.jpg) no-repeat;
                    background-size: 60px 60px;
                    border-radius: 50px;
                }
                .info{
                    display: block;
                    /*//float:left;*/
                    margin-left: 0;
                }
                .title{
                    float: right;
                }
                .title p{
                    text-align: right;
                }
                table{
                    width: 100%;
                    border-collapse: collapse;
                }
                td{
                    /*                    //padding: 5px 0 5px 15px;
                                        //border: 1px solid #EEE*/
                }
                .tabletitle{
                    /*//padding: 5px;*/
                    font-size: .5em;
                    background: #EEE;
                }
                .service{
                    border-bottom: 1px solid #EEE;
                }
                .item{
                    width: 24mm;
                }
                .itemtext{
                    font-size: .5em;
                }

                #legalcopy{
                    margin-top: 5mm;
                }



            }</style>
    </head>
    <body>

        <div id="invoice-POS">

            <center id="top">
                <div class="logo"></div>
                <div class="info"> 
                    <h2>Insta-Mart</h2>
                </div>
            </center>

            <div id="mid">
                <div class="info">
                    <h2>Contact Info</h2>
                    <p> 
                        Date&Time      : ${sessionScope.order.dateTime}<br/>
                        <!--Time      :LocalTime.now()<br/>-->
                        Address        : Electronic city, Bangalore - 60</br>
                        Email          : DMart@gmail.com</br>
                        Phone          : +91-95673-90876</br>
                    </p>
                </div>
            </div><!--End Invoice Mid-->

            <div id="bot">
                <hr/>
                <div id="table">

                    <table>  
                        <tr class="tabletitle">
                            <td class="item"><h2>Item</h2></td>
                            <td class="Hours"><h2>Qty</h2></td>
                            <td class="Rate"><h2>Sub Total</h2></td>

                        </tr>
                        <c:forEach items="${sessionScope.order.lineItem}" var="lineItem">
                            <tr class="service">
                                <td class="tableitem"><p class="itemtext"> &nbsp;  &nbsp;  &nbsp;  &nbsp; ${lineItem.productName}</p></td>
                                <td class="tableitem"><p class="itemtext"> &nbsp;  &nbsp;  &nbsp; ${lineItem.quantity}</p></td>
                                <td class="tableitem"><p class="itemtext"> &nbsp;  &nbsp;  &nbsp; ${lineItem.quantity * lineItem.price}</td>
                            </tr>
                            <!--}-->
                            <!--}-->
                        </c:forEach>
                        <tr class="tabletitle">
                            <td></td>
                            <td class="Rate"> &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; <h2>tax</h2></td><br/>
                        <td class="payment"><h2>&#x20B9;0.00</h2></td>
                        </tr>

                        <tr class="tabletitle">
                            <td></td>
                            <td class="Rate"> &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; <h2>Total</h2></td><br/>
                        <td class="payment"><h2>&#x20B9;${sessionScope.order.total}</h2></td>
                        </tr>

                    </table>
                </div><!--End Table-->
                <hr/>

                <div id="legalcopy">
                    <p class="legal" align = 'center'><strong>Thank you for your shopping!<br/>****Visit Again!**** </strong>  
                    </p>
                </div>

            </div>
        </div>

    </body>
</html>
