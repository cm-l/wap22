<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photoscope</title>
</head>
<body>
	<%

	%>


	<h1>
		<%=request.getAttribute("title")%></h1>

	<img src="data:image/jpg;base64,${base64Image}" width="500"
		height="500" />

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


</body>
</html>