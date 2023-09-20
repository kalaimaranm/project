<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cafe</title>
<style>
div {
	background-image:
		url("${pageContext.request.contextPath}/css/teashop.jpg");
	background-repeat: no-repeat;
	height: 100vh;
	background-size: cover;
	opacity: 1;
}
</style>

</head>
<body>

	<hr />
<div>
	<h1 align="center">Welcome to T-Kadai</h1>
	
		<a href = "WEB-INF/view/order.jsp">place order</a>
		<a href = "">pick-up order</a>
		<a href = "">about us</a>
	<hr />
	</div>
	<div class="bg"></div>
</body>
</html>