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
			</tr>
			<%
			for (int i = 0; i < photos.size(); i += 1) {
			%>
			<tr>
				<td><a href="
					/wap22/GrabImageServlet?pic_id=<%=photos.get(i).getId()%>"> <img
						src="data:image/jpg;base64,<%=photos.get(i).getBase64Image()%>"
						width="200" height="200" /></td>
				</a>
				<td><%=photos.get(i).getId()%></td>
				<td><%=photos.get(i).getTitle()%></td>
				<td><a href="/wap22/GrabUserServlet?user_id=<%=photos.get(i).getUser_pk_user()%>"><%=dao.getUser(photos.get(i).getUser_pk_user()).getUsername()%></a></td>
				<td><%=photos.get(i).getDateofupload()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>