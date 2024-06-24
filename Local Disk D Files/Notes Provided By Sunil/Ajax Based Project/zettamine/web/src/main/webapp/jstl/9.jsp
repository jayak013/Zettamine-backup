
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/db_zettamine" user="root"
	password="root" />

<sql:query var="result" dataSource="${ds}"
	sql="select empno,ename,sal from emp" />

<table border=1 width=60% align=center style="font-family: verdana; font-size: 22px">
	<tr>
		<th>EMP NO</th>
		<th>EMP NAME</th>
		<th>SALARY</th>
	</tr>

	<c:forEach var="row" items="${result.rows}">
		<tr>
			<td><c:out value="${row.empno}" /></td>
			<td><c:out value="${row.ename}" /></td>
			<td><c:out value="${row.sal}" /></td>
		</tr>
	</c:forEach>

	<sql:transaction dataSource="${ds}">
		<sql:update>
   update emp set sal=? where empno=?
  <sql:param value="2222" />
			<sql:param value="101" />
		</sql:update>
	</sql:transaction>