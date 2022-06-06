<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<form action="RegistrationServlet" method="POST">
  <label for="fname">Username:</label><br>
  <input type="text" id="uname" name="uname"><br>
  <label for="lname">Password:</label><br>
  <input type="password" id="pass" name="pass"><br>
  <label for="lname">Mail:</label><br>
  <input type="text" id="mail" name="mail"><br>
  <input type="submit" value="Send"/>
</form>
</body>
</html>