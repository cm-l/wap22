<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photoscope</title>
</head>
<!-- We are borrowing a fre and open access template for the visuals of our site -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<div class="w3-top">
		<div class="w3-bar w3-red w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
			<a href="register.jsp"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">
				Register</a> <a href="login.jsp"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Login
			</a> <a href="searcher.jsp"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Search
			</a> <a href="ImageUpload.jsp"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Upload
			</a>
		</div>
<h1>Welcome to <%=request.getAttribute("username")%>'s profile!</h1>
<h2>This user joined us on <%=request.getAttribute("registrationdate") %></h2>
<h2>Contact information: <%=request.getAttribute("email") %></h2>

<h2>
 <%
        int ismod = (int) request.getAttribute("ismod");
 		int isadmin = (int) request.getAttribute("isadmin");
        if(ismod * isadmin == 0)  {
    %>            
        This user is an ordinary user.
    <%
        } else {
    %>
        if (ismod == 1) {
        This user is a moderator.
        }
        if (isadmin == 1) {
        This user is an administrator.
        }
    <%
        }
    %>
</h2>
</body>
</html>