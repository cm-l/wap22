<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photoscope</title>
</head>
<body>
<h1>Welcom to <%=request.getAttribute("username")%>'s profile!</h1>
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