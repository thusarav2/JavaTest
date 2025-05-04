<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User Profile</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String gmail = request.getParameter("gmail");
    String password = request.getParameter("password");
    String phone = request.getParameter("phone");
%>

<h1>Update User Profile</h1>
<form action="UpdateProfileServlet" method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id" value="<%=id%>" readonly></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=name%>" required></td>
        </tr>
        <tr>
            <td>Gmail:</td>
            <td><input type="email" name="gmail" value="<%=gmail%>" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="<%=password%>" required></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="<%=phone%>" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update"></td>
        </tr> 
    </table>
</form>
</body>
</html>
