<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<title>ZettaMine | user management</title>
</head>

<body>
	<div id="wrapper">
		<h1><img src="images/logo.jpg"></h1>
		<a href="usercontroller?action=insert">+ Add User</a> <br>
		<table border=1 align=center>
			<thead>
				<tr>
					<th>User Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>DOB</th>
					<th>Email</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.userid}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td></td>
						<td><c:out value="${user.email}" /></td>
						<td>
						  <a href="usercontroller?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
						<td>
						<a href="usercontroller?action=delete&userId=<c:out value="${user.userid}"/>"
							onclick="return confirm('Do you want to delete the user?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr>
		<a href="usercontroller?action=insert">+ Add User</a>
	</div>
</body>
</html>
