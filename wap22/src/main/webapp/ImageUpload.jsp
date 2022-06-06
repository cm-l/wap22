<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit your photo</title>
</head>
<body>
	<%
	if (request.getSession(false).getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>Upload your photo below</h1>
	<form action="UploadPhotoServlet" method="POST" accept="image/*"
		enctype="multipart/form-data">
		<input type="file" name="photo" required /> <br> <br> Title:
		<input type="text" name="title" required /> <br> Height, Width: <input
			type="text" name="height" required /> <input type="text" name="width"
			required /> <br> Description: <input type="text"
			name="description" /> <br> <br> <input type="submit"
			value="Upload photo" />
	</form>


</body>
</html>