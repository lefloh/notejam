<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%
  // The entrypoint for the application sending a redirect to the notes page.
  // If the user is not authenticated the signin page will be returned.
  response.sendRedirect(request.getContextPath() + "/r/notes");
%>