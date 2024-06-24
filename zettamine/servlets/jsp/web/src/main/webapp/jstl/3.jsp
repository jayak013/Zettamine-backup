<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<c:set var="a" value="10" />
	<c:set var="b" value="20" />
	
	<c:out value="Product = ${a*b}" />
	<br>
	
	<c:set var="c" value="30" />
	<c:out value="${(a<b) && (a<c)}" />
</h2>