<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zettamine.web.Account" %>
<jsp:useBean id="acc" class="com.zettamine.web.Account" scope="session"/>

<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String mobile = request.getParameter("mobile");
	acc=new Account(20,"kitty","9389403092");
	out.println(acc.toString());
%>

<h2>account no:<c:out value="${id}"/></h2>
<h2>name:<c:out value= "${name}"/></h2>
<h2>mobile: <c:out value="${mobile}"/></h2>
