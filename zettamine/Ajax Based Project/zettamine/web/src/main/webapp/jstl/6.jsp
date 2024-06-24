<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	First 10 Natural Numbers are:<br>

	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}" />
		<br>
	</c:forEach>
</h2>