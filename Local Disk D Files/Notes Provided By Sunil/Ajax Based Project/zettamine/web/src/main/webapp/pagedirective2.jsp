<%@page errorPage="handler.jsp"%>
<%!
 int x = 10;
 int y = 2;
 //int y = 0;
 int[] marks = new int[10];
%>
<p style="font-size:22px;color:red;text-align:center">
<%
 int z = x / y;
 out.println(x + " / " + y + " = " + z + "<br>");
 out.println(marks[10]);
%>
</p>
