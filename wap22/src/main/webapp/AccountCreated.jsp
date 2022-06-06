<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome aboard!</title>
</head>
<body>
<a href="login.jsp">Login</a>
||
<a href="LogoutServlet">Logout</a>
||
<a href="ProfileServlet">My Profile</a>
||
<a href="register.jsp">Register New Account</a>
<hr>
Account successfully created under the username: <b><%= request.getParameter("uname") %></b>!
The account's email adress is: <b><%= request.getParameter("mail") %></b>. </br>
You can now log in using your username and password.
</body>
</html>