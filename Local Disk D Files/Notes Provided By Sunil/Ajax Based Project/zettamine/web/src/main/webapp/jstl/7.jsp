<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
<c:forEach var="i" items="One,Two,Three,Four,Five" >
	<c:out value="${i}" /><br>
</c:forEach>
</h2>