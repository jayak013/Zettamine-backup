<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" />

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<title>ZETTAMINE | USER MANAGEMENT</title>

<script>
 $(function() {
   $('input[name=dob]').datepicker();
 });
</script>
</head>
<body>
<div id="wrapper">
<h1>Zettamine | User Management | <c:out value="${hlabel}"/></h1>
<br><br>
<form method="POST" action='usercontroller' name="frmAddUser">
<table style="width:500px">
<tr>
 <td>User ID : </td>
 <td><input type="text" readonly="readonly" name="userid" value="<c:out value="${user.userid}" />" /> </td>
</tr>

<tr> 
 <td>First Name : </td>
 <td><input type="text" name="firstName" required="required" value="<c:out value="${user.firstName}"/>"> <span style=color:red>*</span></td>
</tr>

<tr>  
 <td>Last Name : </td>
 <td><input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /> </td>
</tr>

<tr>
 <td>DOB : </td>
 <td><input type="text" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> </td>
</tr>

<tr>
 <td>Email : </td>
 <td> <input type="text" name="email" value="<c:out value="${user.email}" />" /> </td>
</tr>

<tr> 
 <td colspan="2" align="center"><input type="submit" value="${label}" }" ></td>
</tr>
</table> 
</form>
</div>
</body>
</html>