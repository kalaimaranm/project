<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>

<style>
  .image1{
    height:100vh;
    width:100%;
	background-image:url("${pageContext.request.contextPath}/css/order.jpg");
	background-size: cover;
	background-repeat: norepeat;
    }
    .menu{
        border:1px solid;
        
    }
    
</style>
</head>
<body>
<h1>Order Please...</h1><hr/>
<div>
<h1 align = "center">T-Kadai Menu</h1>
</div>
<div class="image1">
    <div class="menu">
    <form action = "placeOrder" >
<label for = "bevarage">Items</label>
<select name = "bevarage" id = "bevarageID">
<option value = "Strong Tea">Strong Tea</option>
<option value = "Masala Tea">Masala Tea</option>
<option value = "Coffee">Coffee</option>
<option value = "Cold Coffee">Cold Coffee</option>

</select><br/>   <br/>
<label for = "quantity">Quantity</label>
<select name = "quantity">
<option value = "1" >1</option>
<option value = "2" >2</option>
<option value = "3" >3</option>
<option value = "4" >4</option>
</select>
</form>    
    </div>
</div>
</body>
</html>