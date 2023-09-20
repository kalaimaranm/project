<%-- 
    Document   : update-productDetail-form
    Created on : 09-Jun-2023, 11:09:36 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>  




<!DOCTYPE html>
<html>
    <head>
        <title>Update ProductDetail</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
    <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
    </svg>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
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
            width: 100%;
        }
        form {
            width: 100%;
            padding: 20px;
            border-radius: 6px;
            background: #fff;
            box-shadow: 0 0 10px 0 #cc0052;
            display: block;
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
            display: block;
            position: relative;
            margin: 10px 0;
        }
        .btn-block {
            margin-top: 10px;
            text-align: center;
            display: block;


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
        .bi-x-lg{

            color: red;
            cursor: pointer;
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

        <form:form action = "updateproduct" id="updateproductDetail" name = "updateproductDetail" method = "post" modelAttribute="productDetail">


            <div class="banner">
                <h1>Update Product Form</h1>
            </div>

            <div class="item">
                <label for = "id">Id</label>
                <div class="name-item">
                    <form:input type="text" 
                                path = "id" 
                                id = "id" 
                                value="${productDetail.id}" 
                                readonly="true" />

                </div>
            </div>         
            <div class="item">
                <label for = "name">Name</label>
                <div class="name-item">
                    <form:input type="text"
                                path="name" 
                                id = "name" 
                                value ="${productDetail.name}"  
                                placeholder="Enter the productDetail name" 
                                required = "true" />
                </div>
            </div>
            <div class="contact-item">
                <div class="item">
                    <label>Cost Per Unit</label>
                    <form:input type="text"
                                path="price" 
                                placeholder="Enter the amount in &#x20B9" 
                                value = "${productDetail.price}" 
                                required = "true"/>
                </div>

            </div>
            <div class="item">

                <label>profit Per Unit</label>
                <form:input type="text"
                            path="profitPerUnit"
                            placeholder="Enter the amount in &#x20B9" 
                            value = "${productDetail.profitPerUnit}"
                            required = "true"/>
            </div>

            <div class="item">
                <label>Weight</label>
                <form:input type ="text" 
                            path = "weight"
                            placeholder="Enter the weight in gm/kg"
                            value = "${productDetail.weight}" 
                            required = "true"/>
                <!--<textitemarea rows="3" required></textarea>-->
            </div>
            <div class="item">
                <label>Quantity</label>
                <form:input type = "number"
                            path = "quantity" 
                            name = "quantity"
                            id = "totalquantity"
                            value = "0"
                            />

            </div>
            <div class="btn-block">
                <form:button type="submit"
                             value = "Submit" 
                             name = "submit"
                             id = "submit" >submit</form:button>

                </div>





        </form:form><br/>
    </div>
   

    <script>
//            let quantity = document.getElementById("totalquantity").value;
//
//            function updateQuantity() {
//
//
//                console.log(`inside updateQuantity` + quantity);
//                let div = document.createElement("div");
//                div.setAttribute("id", "item");
//                div.setAttribute("class", "updatequantityinput");
//                div.insertAdjacentHTML("afterBegin", `<label>Enter the Quantity</label>
//                    <input onchange="quantityCalculation()" type = "number" placeholder= "Enter the quantity" name = "updateQuantity" id = "updateQuantity"/>
//                    <i onclick = "removeQuantity()" class="bi bi-x-lg"></i>`);
//                document.getElementById("updateproductDetail").appendChild(div);
//                document.getElementById("updatebutton").remove();
//
//            }
//
//
//            function removeQuantity() {
//                console.log(`inside remove quantity()`);
//                document.getElementById("item").remove();
//                let body = document.body;
//                body.insertAdjacentElement("afterBegin", `<button form ="updateproductDetail" onclick="updateQuantity()" type="button" id = "updatebutton">Update Quantity</button>`);
//            }
//
//            function quantityCalculation() {
//                console.log(`inside quantity calculation()`);
//                console.log(document.getElementById("totalquantity").value = Number(document.getElementById("updateQuantity").value) + Number(quantity));
//
//            }
    </script>
</body>
</html>");
