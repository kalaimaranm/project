<%-- 
    Document   : create-account
    Created on : 07-Jun-2023, 2:02:45 pm
    Author     : bas200193
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content=
              "width=device-width, initial-scale=1.0">
        <title>
            Build a Survey Form using HTML and CSS
        </title>

        <style>

            /* Styling the Body element i.e. Color,
            Font, Alignment */
            body {
                background-color: #05c46b;
                font-family: Verdana;
                text-align: center;
            }

            /* Styling the Form (Color, Padding, Shadow) */
            form {
                background-color: #fff;
                max-width: 500px;
                margin: 50px auto;
                padding: 30px 20px;
                box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
            }

            /* Styling form-control Class */
            .form-control {
                text-align: left;
                margin-bottom: 25px;
            }

            /* Styling form-control Label */
            .form-control label {
                display: block;
                margin-bottom: 10px;
            }

            /* Styling form-control input,
            select, textarea */
            .form-control input,
            .form-control select,
            .form-control textarea {
                border: 1px solid #777;
                border-radius: 2px;
                font-family: inherit;
                padding: 10px;
                display: block;
                width: 95%;
            }

            /* Styling form-control Radio
            button and Checkbox */
            .form-control input[type="radio"],
            .form-control input[type="checkbox"] {
                display: inline-block;
                width: auto;
            }

            /* Styling Button */
            button {
                background-color: #05c46b;
                border: 1px solid #777;
                border-radius: 2px;
                font-family: inherit;
                font-size: 21px;
                display: block;
                width: 100%;
                margin-top: 50px;
                margin-bottom: 20px;
            }
            .submit {

                width: 70%;
                transform: translateX(73px);
            }
        </style>
    </head>
    <body>
        <h1>Customer Details</h1>

        <form:form id = "form" method = "post" action="addcustomer" name = "signup" modelAttribute = "customer" >
            <div class="form-control">      
                <label for = "name" id="label-name">Name</label>
                <form:input type="text" id = "name" path = "name" />
            </div>

            <div class="form-control">
                <label for="password" id="label-role">Password</label>
                <form:input path = "password" type = "password" id = "password" name = "password" placeholder="Enter Your Password"  />
                <input type = "checkbox" onclick="myFunction()" />Show Password
                <%--<form:checkbox onchange="javascript:myFunction();" path=""/>--%>
            </div>

            <!--             <div class="form-control">
                            <label for = "email" id="label-email">
                                Email
                            </label>
            <%--<form:input path = "email" type="email" id="email" placeholder="Enter your email"  />--%>
        </div>-->

            <div class="form-control">
                <label for="phone" id="label-role">Phoneno</label>
                <form:input type = "text" path = "phone" id = "phone" name = "phone" placeholder = "Enter Your Phoneno"/>
            </div>

            <div class="form-control">
                <label for="aadhaar" id="label-role">AadhaarNo</label>
                <form:input path = "aadhaar" type = "text" id = "aadhaar" name = "aadhaar" placeholder="Enter Your AadhaarNo" />
            </div>
            <div class="form-control">
                <div ><label for="doorno">
                        Address
                        <label for = "doorno">Door-no / plot-no</label>
                </div>
                <!--</label>-->  
                <form:input path = "address.houseNo" type = "text" id = "doorno" name = "doorno" /><br/>
                <label for ="street">Street</label>
                <form:input path = "address.street" type = "text" id = "street" name = "street" /><br/>
                <label for = "distric">Distric</label>
                <form:input path = "address.distric" type = "text" id = "distric" name = "distric" /><br/>
                <label for ="state">State</label>
                <form:input path = "address.state" type = "text" id = "state" name = "state" /><br/>
                <label for = "pincode">Pincode</label>
                <form:input path = "address.pincode" id = "pincode" type = "text" name = "pincode"/>
            </div>

            <div class = "submit">
                <form:button  onclick="javascript:mySubmit()" id = "submit" value="submit" type="submit" name="submit">Submit</form:button>
                    <!--<button onsubmit=""></button>-->
                </div>
        </form:form>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
        <script>
                    function myFunction() {
                        var x = document.getElementById("password");
                        if (x.type === "password") {
                            x.type = "text";
                        } else {
                            x.type = "password";
                        }
                    }

                    function mySubmit() {
                        console.log(`inside mySubmit()`);
                        let rawPassword = document.getElementById('password').value;

                        console.log(document.getElementById('password').value = CryptoJS.MD5(rawPassword));

                    }
        </script>
    </body>
</html>
