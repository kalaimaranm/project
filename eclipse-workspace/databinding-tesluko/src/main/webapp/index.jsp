<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1 align="center">Welcome</h1>
	<br />
	<hr />
	<div align="center">
		<form action="signin" method="post">
			<label for="email">Email ID</label> <input type="email" name="email"
				id="email" required /><br /> <label for="password">Password</label>
			<input type="password" name="password" id="password" required /><br />&nbsp;&nbsp;&nbsp;
			<input type="submit" value="sign in">&nbsp;&nbsp;&nbsp;&nbsp;
			<button>
				<a href="signupform">sign up</a>
			</button>
		</form>
	</div>
</body>
</html>
