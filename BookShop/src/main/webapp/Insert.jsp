<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Entry Form</title>
</head>
<body>
<h2>Enter Book Details</h2>
	<form action="InsertServlet" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" required></td>
			</tr>
			
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" required></td>
			</tr>
			
			<tr>
				<td>Catagory:</td>
				<td><input type="text" name="catagory" required></td>
			</tr>
			
			<tr>
				<td>Qunetity:</td>
				<td><input type="text" name="qunetity" required></td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><textarea type="text" name="description" required></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>