<%!
 String user = null;
 String pass = null;
%>

<%
 user = request.getParameter("txt_uid");
 pass = request.getParameter("txt_pwd");
 
 if(user.equals("admin") && pass.equals("1234"))
	 response.sendRedirect("https://www.zettamine.com");
 else
	 response.sendError(response.SC_UNAUTHORIZED, "Authentication Failed!");
%>