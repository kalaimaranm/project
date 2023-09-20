<%-- 
    Document   : convert2
    Created on : 27-Mar-2023, 5:10:27 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pending Orders</title>

        <style>

            @import url('https://fonts.googleapis.com/css?family=Assistant');
            body {
                background: #eee;
                font-family: Assistant, sans-serif;
            }

            .cell-1 {
                border-collapse: separate;
                border-spacing: 0 4em;
                background: #fff;
                border-bottom: 5px solid transparent;
                /*background-color: gold;*/
                background-clip: padding-box;
            }

            thead {
                background: #dddcdc;
            }
            
           
        </style>
    </head>
    <body><br/><div align = "center"><h1>Pending Orders</h1></div>
        <br/><br/>
        <div align = "center" >
            <div class="container mt-5">
                <div class="d-flex justify-content-center row">
                    <div class="col-md-10">
                        <div class="rounded">
                            <div class="table-responsive table-borderless">
                                <table class="table" cellpadding='12'>
                                    <thead>
                                        <tr>
                                            <!--                                        <th class="text-center">
                                                                                        <div class="toggle-btn">
                                                                                            <div class="inner-circle"></div>
                                                                                        </div>
                                                                                    </th>-->
                                            <th>Order Id</th>
                                            <th>Customer Id</th>
                                            <th>status</th>
                                            <th>Total</th>
                                            <th>Order Placed</th>
                                            <th>Invoice</th>
                                            <th>Approve</th>
                                        </tr>
                                    </thead>
                                    <tbody class="table-body">


                                        <tr class="cell-1">

                                            <td>#SO-13498</td>
                                            <td>Trashes Habard</td>
                                            <td><span class="badge badge-danger">Partially shipped</span></td>
                                            <td>$6274.00</td>
                                            <td>May 12,2020</td>
                                            <td><button><a href = "#">view</a></button></td>
                                                        <!--<td><i class="fa fa-ellipsis-h text-black-50"></i></td>-->
                                                        <td><button><a href = "#">Accept</a></button></td>


<!--                                                            <label class="switch">
                                                                <input type="checkbox">
                                                                <span class="slider round"></span>
                                                            </label>-->
                                                        </tr>

                                                        </tbody>
                                                        </table>
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>    </div>
                                                        <br/><br/><br/> <div align = "center">
                                                            <button><a href = "placeorder?option=approveorder">Submit</a></button>
                                                            <button><a href = "shopkeeperhome.html">Home</a></button>
                                                        </div>                      
                                                        </body>
                                                        </html>
