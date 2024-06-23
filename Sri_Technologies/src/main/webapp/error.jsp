<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>An error occurred:</h1>
    <p><%= request.getAttribute("errorMessage") %></p>
    <a href="login.jsp">Back to Login</a>
</body>
</html>