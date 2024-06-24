<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/images/logo.png">
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Zaiba Lib</title>
</head>
<body>
	<h1 class="w-50 mx-auto">Zaiba Khan Pervez Library</h1>
	<table
		class="table w-50 mx-auto table-light table-stripped table-bordered table-hover">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Price</th>
			</tr>
		</thead>
		<tr>
			<td>${testBook.bookId}</td>
			<td>${testBook.bookName}</td>
			<td>${testBook.bookPrice}</td>
		</tr>
	</table>
</body>
</html>