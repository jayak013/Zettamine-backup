<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<c:set var="var1" value="Zettamine" />
	
	<c:if test="${empty var1}">
		<c:out value="No value for variable - 1" />
	</c:if>
</h2>