<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="wap.Logic.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photoscope</title>
</head>
<body>
	<%
	// Create DAO
	DatabaseCrud dao = new DatabaseCrud();
	List<Comment> comments = dao.listMatchingComments(Integer.parseInt(request.getParameter("pic_id")));
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
		<table border="1" cellpadding="5">
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