<p style="font-size:22px;color:blue">
<%
 //String user = request.getParameter("txt_uid");
 //String user = session.getAttribute("uname").toString();
 String user = (String)pageContext.getAttribute("uname", PageContext.SESSION_SCOPE);
 out.println("Welcome " + user);
%>
</p>