<%@page import="com.zettamine.web.dto.Employee"%>
<%@page import="com.zettamine.web.service.EmpService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="empSevice" class="com.zettamine.web.service.EmpService" scope="session"/>
<jsp:useBean id="emp" class="com.zettamine.web.dto.Employee" scope="session"/>
<%
	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String sal = request.getParameter("sal");
	out.println(ename);
	emp = new Employee(Integer.parseInt(empno),ename,Double.parseDouble(sal));
	int rows = empSevice.addEmp(emp);
%>


<h1>Mr. <c:out value="<%=request.getParameter(\"ename\")%>"/> is successfully added into the database</h1>
