<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- We are borrowing a fre and open access template for the visuals of our site -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	<!--  
	<h1>Welcome to Photoscope!</h1>
	<h2>To suit all Your photography-related needs.</h2>
	<a href="login.jsp">Login</a>||
	<a href="LogoutServlet">Logout</a>||
	<a href="ProfileServlet">My Profile</a>||
	<a href="register.jsp">Create New Account</a> -->
<body>

	<!-- Navbar -->
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

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
		</div>
	</div>

	<!-- Header -->
	<header class="w3-container w3-red w3-center"
		style="padding: 128px 16px">
		<h1 class="w3-margin w3-jumbo">Welcome to Photoscope!</h1>
		<p class="w3-xlarge">For all your photography browsing and hosting
			needs.</p>
			<a href="ImageUpload.jsp">
		<button
			class="w3-button w3-black w3-padding-large w3-large w3-margin-top">Upload
			a Photo</button> </a>
	</header>

	<!-- First Grid -->
	<div class="w3-row-padding w3-padding-24 w3-container">
		<div class="w3-content">
			<div class="w3-onefourth">
				<h1>About our Service</h1>
				<p class="w3-text-grey">We provide an easy, secure and
					user-friendly way to store your photos online as well as browse
					other users' work. Go ahead! Try to make an account and upload some
					of your own, or browse to your heart's content. Feel free to also
					leave comments for all users to see - no account required!</p>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="w3-container w3-padding-24 w3-center w3-opacity">
		<div class="w3-large w3-padding-28"></div>
		<p>
			Created for Web Application Project Course in PSUEB by Cyryl
			Leszczyński and Julia Głowaczewska </br> The free and open-source visual
			design provided by <a
				href="https://www.w3schools.com/w3css/default.asp" target="_blank">World
				Wide Web Consortium</a>
		</p>
	</footer>

</body>
</html>