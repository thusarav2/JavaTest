<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="gmail" required></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr> 
		</table>
	</form>
</body>
</html>