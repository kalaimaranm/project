<%-- 
    Document   : add-product-form
    Created on : 08-Jun-2023, 4:27:58 pm
    Author     : bas200193
--%>



<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
                width: 60%;
                transform: translateX(90px);
                margin-top: 50px;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <h1>Product Details</h1>

        <!-- Create Form -->
    <form:form id = "form" action = "addproduct" method = "post"  modelAttribute = "product" >

        <div class="form-control">
            <label for="name" id="label-name">
                Product Name
            </label>

            <!-- Input Type Text -->
            <form:input type="text"
                        id="name" path = "name"
                        placeholder="Enter product name" required= "true" />
        </div>

        <div class="form-control">
            <label for="costperunit" id="label-email">
                Cost Per Unit
            </label>

            <!-- Input Type Email-->
            <form:input type="text"
                        path ="price"
                        id="costperunit"
                        placeholder="Enter the cost per unit in &#x20b9;" required= "true"/>
        </div>
        <div class="form-control">
            <label for="profitperunit" id="label-age">
                Profit Per Unit
            </label>

            <!-- Input Type Text -->
            <form:input type="text"
                        id="profitperunit"
                        path ="profitPerUnit"
                        placeholder="Enter the cost per unit in &#x20b9;" required= "true"/>
        </div>

        <div class="form-control">
            <label for="weight" id="label-role">Weight</label>
            <form:input type = "text"
                        id = "weight"
                        path = "weight"
                        placeholder="Enter the product weigth" required= "true"/>

        </div>
        <div class="form-control">
            <label for="quantity" id="label-role">Quantity</label>
            <form:input type = "text"
                   id = "quantity"
                   path = "quantity"
                   placeholder="Enter Product Quantity" />
        </div>
            <form:button id="button" value="submit">Submit</form:button>

    </form:form>

    <!--    <form id="form" method = "post" action = "addproduct">
             Details 
            <div class="form-control">
                <label for="name" id="label-name">
                    Product Name
                </label>
    
                 Input Type Text 
                <input type="text"
                       id="name" name ="name"
                       placeholder="Enter product name" />
            </div>
    
            <div class="form-control">
                <label for="costperunit" id="label-email">
                    Cost Per Unit
                </label>
    
                 Input Type Email
                <input type="text"
                       name ="costperunit"
                       id="costperunit"
                       placeholder="Enter the cost per unit in &#x20b9;" />
            </div>
    
            <div class="form-control">
                <label for="profitperunit" id="label-age">
                    Profit Per Unit
                </label>
    
                 Input Type Text 
                <input type="text"
                       id="profitperunit"
                       name ="profitperunit"
                       placeholder="Enter the cost per unit in &#x20b9;" />
            </div>
    
            <div class="form-control">
                <label for="weight" id="label-role">Weight</label>
                <input type = "text" id = "weight" name = "weight" placeholder="Enter the product weigth" />
                 Dropdown options 
    
            </div>
            <div class="form-control">
                <label for="quantity" id="label-role">Quantity</label>
                <input type = "text" id = "quantity" name = "quantity" placeholder="Enter Product Quantity" />
            </div>
    
             Multi-line Text Input Control 
            <button type="submit" value="submit">
                Submit
            </button>
        </form>-->
    <!--<a href = ""></a>-->
</body>

</html>
