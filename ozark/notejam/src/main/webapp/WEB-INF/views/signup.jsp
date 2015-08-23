<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainpage title="Sign Up" description="Sign Upfor Notejam">
  <jsp:body>

    <t:alerts />

    <form class="offset-by-six sign-in" action="${mvc.contextPath}/r/signup" method="POST">

      <label for="email">Email</label>
      <input type="text" id="email" name="email">
      <t:error field="email" />

      <label for="password">Password</label>
      <input type="password" id="password" name="password">
      <t:error field="password" />

      <label for="confirmPassword">Confirm password</label>
      <input type="password" id="confirmPassword" name="confirmPassword">
      <t:error field="confirmPassword" />

      <input type="submit" value="Sign Up"> or
      <a href="${mvc.contextPath}/r/signin">Sign in</a>

    </form>
  </jsp:body>
</t:mainpage>