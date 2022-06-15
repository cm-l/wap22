<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="wap.Logic.*"%>
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
<title>Photoscope</title>
</head>
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
		</div>
	<%
	// Create DAO
	DatabaseCrud dao = new DatabaseCrud();
	List<Comment> comments = dao.listMatchingComments(Integer.parseInt(request.getParameter("pic_id")));
	%>


	<h1>
		<%=request.getAttribute("title")%></h1>

	<img src="data:image/jpg;base64,${base64Image}"/>

	<h2>
		Description: <br>
	</h2>
	<%=request.getAttribute("description")%>

	<h3>
		Dimensions (width by height): <br>
	</h3>
	<%=request.getAttribute("height")%>
	x
	<%=request.getAttribute("width")%>

	<h3>
		Camera used: <br>
	</h3>
	<%=request.getAttribute("cameramodel")%>

	<h3>
		Editing Software used: <br>
	</h3>
	<%=request.getAttribute("editingsoftware")%>

	<h3>
		Original file format: <br>
	</h3>
	<%=request.getAttribute("fileformat")%>

	<h3>
		Uploaded on: <br>
	</h3>
	<%=request.getAttribute("dateofupload")%>

	<h3>Comments:</h3>
	<form action="/wap22/PostComment" method="POST">
		<div>
			<textarea name="comment" id="comment"
				style="font-family: sans-serif; font-size: 1.2em;">
Post your comment here.
</textarea>
		</div>
		<input type="hidden" id="picId" name="picId"
			value="<%=request.getAttribute("pic_id")%>"> <input
			type="submit" value="Submit">
	</form>

	<h3>People have shared their comments:</h3>
	<div>
		<table border="1" cellpadding="3">
			<tr>
				<th>Posted on:</th>
				<th>Content:</th>
			</tr>
			<%
			for (int i = 0; i < comments.size(); i += 1) {
			%>
			<tr>
			<td><%=comments.get(i).getDateposted() %>
			<td><%=comments.get(i).getContent() %></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>