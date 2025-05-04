<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String catagory = request.getParameter("catagory");
	String qunetity = request.getParameter("qunetity");
	String description = request.getParameter("description");
%>
<form action="UpdateServlet" method="post">
		<table>
			<tr>
				<td>id:</td>
				<td><input type="text" name="id" value="<%=id%>" readonly></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=name%>" required></td>
			</tr>
			
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" value="<%=price%>" required></td>
			</tr>
			
			<tr>
				<td>Catagory:</td>
				<td><input type="text" name="catagory" value="<%=catagory%>" required></td>
			</tr>
			
			<tr>
				<td>Qunetity:</td>
				<td><input type="text" name="qunetity" value="<%=qunetity%>" required></td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><textarea type="text" name="description" required><%=description%>"</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
			</tr> 
		</table>
	</form>
</body>
</html>