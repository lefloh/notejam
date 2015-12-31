<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainpage title="Sign In" description="Sign in for Notejam">
  <jsp:body>

    <t:alerts />

    <form method="POST" action="j_security_check" class="offset-by-six sign-in">
      <label for="email">Email</label>
      <input type="text" name="j_username" id="email" />

      <label for="password">Password</label>
      <input type="password" name="j_password" id="password" />

      <input type="submit" value="Sign In"> or
      <a href="${mvc.contextPath}/r/signup">Sign up</a>

      <hr />
      <p><a href="${mvc.contextPath}/r/forgot-password" class="small-red">Forgot password?</a></p>
    </form>

  </jsp:body>
</t:mainpage>