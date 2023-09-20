<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1 align="center" bgcolor="green">Welcome to spring-MVC</h1>
	<h1 align="center">Welcome to ${name} hotel</h1>
	<hr />
	<div align="center">
		<form name="order" action="order" method="post">
			<label name="item" for="item">Enter food Item </label> <input
				type="text" name="item" id="item" placeholder="Enter Your Drink...." />
			<br />
			<label for="quantity">Quantity</label> <input type="number"
				id="quantity" placeholder="minimum quantity 0" name="quantity" /><br />
			<input type="submit" value="order" />
		</form>
	</div>
</body>
</html>