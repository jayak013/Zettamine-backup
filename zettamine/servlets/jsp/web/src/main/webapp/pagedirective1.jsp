<%@page import="java.time.*" info="this page introduces page directive" language="java"  %>
<%!
 LocalDate date;
%>
<p style="font-size:22px;color:red;text-align:center">
<%
 date = LocalDate.now();
 out.println(date);
%>
</p>
<h3>
<%=getServletInfo() %>
</h3>