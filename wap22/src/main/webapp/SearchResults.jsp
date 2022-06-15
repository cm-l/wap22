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
<style>

.thumbnail {
	position: relative;
	z-index: 0;
}

.thumbnail:hover {
	background-color: transparent;
	z-index: 50;
}

.thumbnail span {
	/*CSS for enlarged image*/
	position: absolute;
	background-color: lightyellow;
	padding: 5px;
	left: -1000px;
	border: 1px dashed gray;
	visibility: hidden;
	color: black;
	text-decoration: none;
}

.thumbnail span img {
	/*CSS for enlarged image*/
	border-width: 0;
	padding: 2px;
}

.thumbnail:hover span {
	/*CSS for enlarged image on hover*/
	visibility: visible;
	top: 0;
	left: 60px;
	/*position where enlarged image should offset horizontally */
}
</style>
<body>
	<div class="w3-top">
		<div class="w3-bar w3-red w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="index.jsp"
				class="w3-bar-item w3-button w3-padding-large w3-white">Home</a> <a
				href="register.jsp"
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
	List<Photo> photos = (List<Photo>) request.getAttribute("listPhotos");
	DatabaseCrud dao = new DatabaseCrud();
	%>
	<div>
		<table border="1" cellpadding="5">
			<caption>
				<h1>Found Photos</h1>
			</caption>
			<tr>
				<th>Preview</th>
				<th>Image ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Date of upload</th>
				<th>Camera model</th>
				<th>Editing sofware</th>
			</tr>
			<%
			for (int i = 0; i < photos.size(); i += 1) {
			%>
			<tr>
				<!--  
				<td><a href="
					/wap22/GrabImageServlet?pic_id=<%=photos.get(i).getId()%>"> <img
						src="data:image/jpg;base64,<%=photos.get(i).getBase64Image()%>"
						width="200" height="200" /></td>
						-->
				<td><a class="thumbnail"
					href="/wap22/GrabImageServlet?pic_id=<%=photos.get(i).getId()%>"><img
						src="data:image/jpg;base64,<%=photos.get(i).getBase64Image()%>"
						width="220px" height="220px" border="0" /><span><img
							src="data:image/jpg;base64,<%=photos.get(i).getBase64Image()%>" /><br /><%=photos.get(i).getDescription()%></span></a>
				<td><%=photos.get(i).getId()%></td>
				<td><%=photos.get(i).getTitle()%></td>
				<td><a
					href="/wap22/GrabUserServlet?user_id=<%=photos.get(i).getUser_pk_user()%>"><%=dao.getUser(photos.get(i).getUser_pk_user()).getUsername()%></a></td>
				<td><%=photos.get(i).getDateofupload()%></td>
				<td><%=photos.get(i).getCameramodel()%>
				<td><%=photos.get(i).getEditingsoftware()%>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>