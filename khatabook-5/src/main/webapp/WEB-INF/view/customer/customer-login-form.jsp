<%-- 
    Document   : view-customer-form
    Created on : 11-Jun-2023, 12:12:38 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>view customer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <form name = "viewcustomer" action="${action}" method = "post">
            <div class="viewcustomer">
                <div class="container1">
                    <h1 id="control-7823122" align = "center">View Customer</h1></div>
                <div class="container2">
                    <label for="phone" class="formbuilder-text-label">phone no<span class="formbuilder-required">*</span></label>
                    <input type="text" placeholder="Enter Your Registered phone no" class="form-control" name="phone" id="phone" required="required" aria-required="true">
                </div>
                <div class="formbuilder-button form-group field-submit">
                    <button type="submit" class="btn-success btn" name="submit" style="success" id="submit">Login</button>
                </div>
            </div>
        </form>
    </body>
</html>
