<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<c:forTokens var="i" items="One.Two.Three.Four" delims=".">
		<c:out value="${i}" />
		<br>
	</c:forTokens>
</h2>