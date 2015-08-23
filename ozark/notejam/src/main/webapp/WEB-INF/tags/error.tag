<%@ tag description="Error tag" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="field" required="true" %>

<c:if test="${msg.errors[field] != null}">
  <ul class="errorlist">
    <c:forEach var="error" items="${msg.errors[field]}">
      <li>${error}</li>
    </c:forEach>
  </ul>
</c:if>