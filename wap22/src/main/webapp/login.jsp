<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Login Page</title>
</head>
<body>
	<form action="LoginServlet" method="POST">
		Username:<input type="text" name="name"><br> Password:<input
			type="password" name="password"><br> <input
			type="submit" value="Login">
	</form>
</body>