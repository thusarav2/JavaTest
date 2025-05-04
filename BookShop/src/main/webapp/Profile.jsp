<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	
	<h1>User profile</h1>
	
	<h2>User ID: ${user.id}</h2>
	<h2>User Name: ${user.name}</h2>
	<h2>User Gmail: ${user.gmail}</h2>
	<h2>User PSW: ${user.password}</h2>
	<h2>User Phone: ${user.phone}</h2>
	
	<a href="updateProfile.jsp?id=${user.id}&name=${user.name}&gmail=${user.gmail}&password=${user.password}&phone=${user.phone}">
		<button>Update</button>
	</a>
	
	<form action="UserDeleteServlet" method="post" style="display:inline;">
			<input type="hidden" name="id" value="${user.id}" />
			<button type="submit" onclick="return confirm('Are you sure you want to delete this item?');">Delete</button>
		</form>
	
</body>
</html>