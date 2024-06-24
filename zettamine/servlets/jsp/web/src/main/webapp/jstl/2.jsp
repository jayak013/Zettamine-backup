<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
<c:set var="s" value="Zettamine" />
<c:out value="${s}" />
<c:remove var="s" />
<br>
<c:out value="Value is ${s}" />
</h2>