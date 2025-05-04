<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Table</title>
</head>
<body>
<h2>Product Table</h2>
<input type="text" id="searchInput" placeholder="search...">
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Category</th>
		<th>Quantity</th>
		<th>Description</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="book" items="${allBooks}">
	<tr>
		<td>${book.id}</td>
		<td>${book.name}</td>
		<td>${book.price}</td>
		<td>${book.catagory}</td>
		<td>${book.qunetity}</td>
		<td>${book.description}</td>
		
		<td>
			<a href="update.jsp?id=${book.id}&name=${book.name}&price=${book.price}&catagory=${book.catagory}&qunetity=${book.qunetity}&description=${book.description}">
				<button>Update</button>
			</a>
			
			<!-- Delete Form: Now includes hidden ID field -->
		<form action="DeleteServlet" method="post" style="display:inline;">
			<input type="hidden" name="id" value="${book.id}" />
			<button type="submit" onclick="return confirm('Are you sure you want to delete this item?');">Delete</button>
		</form>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>