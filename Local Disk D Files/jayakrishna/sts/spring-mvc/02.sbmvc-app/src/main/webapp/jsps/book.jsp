<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/imgs/logo.png">
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Zettamine::Logo</title>
</head>
<body>
	<h1 class="w-50 mx-auto text-secondary">Library Data</h1>
	<table class="table table-striped  table-light table-hover table-bordered w-50 mx-auto" >
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tr>
			<th>${book.bookId}</th>
			<th>${book.bookName}</th>
			<th>${book.bookPrice}</th>
			<th>Update Delete</th>
		</tr>
	</table>
</body>
</html>