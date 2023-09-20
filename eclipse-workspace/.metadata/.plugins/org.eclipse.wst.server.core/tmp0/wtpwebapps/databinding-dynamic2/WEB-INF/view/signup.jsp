<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>
<style>

.error{
color:red;
position: fixed;
text-align: left;
margin-left: 30px; 
}
</style>
</head>
<body>
<div align = "center">
<h1 align = "center">Enter the Detail's</h1><br/><br/><hr/><br/>
<form:form action = "signup" name = "signup" modelAttribute="userRecord" onsubmit = "return validation()">
<label for = "name">Name</label>
<form:input id = "name" path="name" /> 
<form:errors path = "name" cssClass="error" /><br/>
<label for = "email">Email</label>
<form:input id = "email"  path="email" />
<form:errors path = "email" cssClass = "error"/><br/>
<label for = "password">Password</label>
<input type = "password" id = "password" name = "password" cssClass="error"/><br/>
<label for = "age">Age</label>
<form:input id = "age" path = "age" />
<form:errors path = "age" cssClass = "error"/>                                          <br/>
<label for = "gender">Gender</label>
<input type = "radio" id = "gender" name = "gender" value = "MALE" />
Male
<input type = "radio" id = "gender" name = "gender" value = "FEMALE">
Female
<input type = "radio" id = "gender" name = "gender" value = "OTHER">
Other<br/>
<label for = "address">Address</label>
<input type = "text" id = "address" name = "address" ><br/>
<label for = "phone">Phone</label>
<input type = "text" id = "phone" name = "phone" ><br/>
<form:checkbox path = "agreeCondition" /> * I Agree terms and condition will repay debt within a grace period<br />
<form:errors path = "agreeCondition" cssClass = "error" />
<input type = "submit" value ="register">
<h1 align = "center">Contact us</h1>
<label>email id : </label>
<form:input path = "contactUs.email" />
</form:form>
</div>

<script>
function validation() {
	
	var name = document.getElementById("name").value
	
	if(name.length == 0 || name.length < 2 || name.length > 25) {
		window.alert("name should be within the range [3-25] character");
		return false;
	} else {
		return true;
	}
	
}
</script>
</body>
</html>