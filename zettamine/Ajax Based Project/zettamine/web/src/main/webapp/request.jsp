<%@page import="java.util.Enumeration"%>
<%!
 String user = null;
 String pass = null;
%>
<h2>
<%
 user = request.getParameter("txt_uid");
 pass = request.getParameter("txt_pwd");
 
 out.println("User Name = " + user + "<br>");
 out.println("Password = " + pass);
%>
</h2>
<hr>
<h2>
server name = <%=request.getServerName()%> <br>
server port = <%=request.getServerPort() %> <br>
method = <%=request.getMethod() %> <br>
protocol = <%=request.getProtocol() %> <br>
application = <%=request.getContextPath() %> <br>
content type = <%=request.getContentType() %> <br>
content length = <%=request.getContentLength() %> <br>
headers = 
<%
Enumeration<String> headers = request.getHeaderNames();
while(headers.hasMoreElements()){
	String headerName = headers.nextElement();
	String headerValue = request.getHeader(headerName);
	out.println(headerName + " ---> " + headerValue + "<br>");
}
%>
</h2>