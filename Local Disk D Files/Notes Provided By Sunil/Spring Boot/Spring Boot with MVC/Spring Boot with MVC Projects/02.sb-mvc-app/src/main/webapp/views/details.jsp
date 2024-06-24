<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="http://localhost:9090/zetta/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
<title>admin details</title>
</head>
<body>
<div class="container mt-5">
 <table class="table table-striped table-dark w-75 table-hover h4 mx-auto">
  <tr>
    <th>Name</th> 
    <td>${admin_name}</td>
  </tr> 
  
  <tr>
    <th>Age</th> 
    <th>${admin_age}</th>
  </tr>
  
  <tr>
    <th>Address</th> 
    <td>${admin_addr}</td>
  </tr>  
 </table>
</div>
<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>