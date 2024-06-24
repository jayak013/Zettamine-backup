<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/images/logo.png">
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="w-50 mx-auto text-secondary">Library Data</h1>
	<table
		class="table table-striped table-light table-hover table-bordered w-50 mx-auto">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.bookId}</td>
				<td>${list.bookName}</td>
				<td>${list.bookPrice}</td>
				<td>Update Delete</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>