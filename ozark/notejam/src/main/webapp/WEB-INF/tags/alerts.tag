<%@ tag description="Error tag" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty msg.alerts}">
  <div class="alert-area">
    <c:forEach var="alert" items="${msg.alerts}">
    <div class="alert alert-${alert.type}">${alert.msg}</div>
    </c:forEach>
  </div>
</c:if>

