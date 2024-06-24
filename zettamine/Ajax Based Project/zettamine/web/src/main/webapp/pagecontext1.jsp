<p style="font-size:22px;color:blue">
<%
 String user = request.getParameter("txt_uid");
 //session.setAttribute("uname", user);
 pageContext.setAttribute("uname", user, PageContext.SESSION_SCOPE);
 out.println("Welcome " + user);
%>
</p>
<a href="pagecontext2.jsp">Next Page</a>