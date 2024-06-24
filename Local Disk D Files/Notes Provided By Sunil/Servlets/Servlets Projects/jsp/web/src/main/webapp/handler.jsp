<%@page isErrorPage="true" %>
<body style="background-color:light-green;color:red">
<h2>
<%
 if(exception instanceof ArithmeticException){
	 out.println(exception.toString());
 }else if(exception instanceof ArrayIndexOutOfBoundsException){
	 out.println(exception.getMessage());
 }else{
	 out.println("Internal Server error");
 }
%>
</h2>
</body>