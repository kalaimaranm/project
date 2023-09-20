<%-- 
    Document   : update-customer-form
    Created on : 12-Jun-2023, 12:15:19 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
    <head>
        <title>Update product</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <style>
            html, body {
                min-height: 100%;
            }
            body, div, form, input, textarea, p {
                padding: 0;
                margin: 0;
                outline: none;
                font-family: Roboto, Arial, sans-serif;
                font-size: 14px;
                color: #666;
                line-height: 22px;
            }
            h1 {
                position: absolute;
                margin: 0;
                font-size: 32px;
                color: #fff;
                z-index: 2;
            }
            .testbox {
                display: flex;
                justify-content: center;
                align-items: center;
                height: inherit;
                padding: 20px;
            }
            form {
                width: 100%;
                padding: 20px;
                border-radius: 6px;
                background: #fff;
                box-shadow: 0 0 10px 0 #cc0052;
            }
            .banner {
                position: relative;
                height: 210px;
                background-image: url("/uploads/media/default/0001/01/f1cf9a9068f4bfbdbd9758c45db79203579a3561.jpeg");
                background-size: cover;
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center;
            }
            .banner::after {
                content: "";
                background-color: rgba(0, 0, 0, 0.4);
                position: absolute;
                width: 100%;
                height: 100%;
            }
            input, textarea {
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            input {
                width: calc(100% - 10px);
                padding: 5px;
            }
            textarea {
                width: calc(100% - 12px);
                padding: 5px;
            }
            .item:hover p, input:hover::placeholder {
                color: #cc0052;
            }
            .item input:hover, .item textarea:hover {
                border: 1px solid transparent;
                box-shadow: 0 0 6px 0 #cc0052;
                color: #cc0052;
            }
            .item {
                position: relative;
                margin: 10px 0;
            }
            .btn-block {
                margin-top: 10px;
                text-align: center;
            }
            button {
                width: 150px;
                padding: 10px;
                border: none;
                border-radius: 5px;
                background: #cc0052;
                font-size: 16px;
                color: #fff;
                cursor: pointer;
            }
            button:hover {
                background: #ff0066;
            }
            @media (min-width: 568px) {
                .name-item, .contact-item {
                    display: flex;
                    flex-wrap: wrap;
                    justify-content: space-between;
                }
                .contact-item .item {
                    width: calc(50% - 8px);
                }
                .name-item input {
                    width: calc(50% - 20px);
                }
                .contact-item input {
                    width: calc(100% - 12px);
                }
            }
        </style>
        <script>

        </script>
    </head>
    <body>
        <div class="testbox">
            <form:form  action="update-customer" name = "updatecustomer" modelAttribute="customer" method = "post">
                <div class="banner">
                    <h1>Update Customer Form</h1>
                </div>
                <div class="item">
                    <label for = "id">Id</label>
                    <div class="name-item">
                        <form:input type="text"
                                    id = "id"
                                    path ="id" 
                                    readonly="true" />
                    </div>
                </div>
                <div class="item">
                    <label for = "name">Name</label>
                    <div class="name-item">
                        <form:input type="text" 
                                    name="name" 
                                    path = "name" 
                                  
                                    placeholder="Enter the Customer name"
                                    required = "true"/>
                    </div>
                </div>
                <!--<div class="contact-item">-->
                <div class="item">
                    <label for = "phone">Phone no</label>
                    <form:input type="text"
                                name="phone" 
                                placeholder="Enter the phone no"
                                path = "phone" 
                                
                                required = "true"/>
                    <!--</div>-->
                </div>
                <div class="item">
                    <label for = "aadhaar">Aadhaar no</label>
                    <form:input type="text"
                                name="aadhaar" 
                                placeholder="Enter the Aadhaar no" 
                                path = "aadhaar" 
                                
                                required = "true" />
                </div>
                <div class="item">
                    <label for = "doorno">Door no/House no</label>
                    <form:input type ="text" 
                                name = "doorno" 
                                placeholder="Enter the Door no/House no in"
                                path = "address.houseNo" 
                                 />
                </div>
                <div class="item">
                    <label for = "distric">Distric</label>
                    <form:input type = "text"
                                name = "distric" 
                                path = "address.distric"
                                placeholder = "Enter the distric"
                                
                                required = "true"/>
                </div>
                <div class="item">
                    <label for = "state">State</label>
                    <form:input type="text" 
                                name="state" 
                                placeholder="Enter the State"
                                path = "address.state" 
                                
                                required = "true"/>
                </div>
                <!--                <div class="item">
                                    <label for = "country">Country</label>
                                    <input type = "text"
                                           name = "country" 
                                           vlaue = "India" 
                                           readonly="true"/>
                                </div>-->
                <div class="item">
                    <label for = "pincode">Pincode</label>
                    <form:input type="number"
                                name="pincode" 
                                placeholder="Enter the Pincode" 
                                path = "address.pincode" 
                                />
                </div>
                <div class="btn-block">
                    <form:button type="submit" name = "submit" id = "submit" >UPDATE</form:button>
                    </div>
            </form:form>
        </div>
    </body>
</html>
