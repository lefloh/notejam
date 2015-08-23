<%@ tag description="Main Template" pageEncoding="utf-8" %>

<%@ attribute name="title" required="true" %>
<%@ attribute name="description" required="true" %>

<%@ attribute name="header" fragment="true" %>
<%@ attribute name="menu" fragment="true" %>

<!doctype html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>
  <!-- Basic Page Needs
  ================================================== -->
  <meta charset="utf-8">
  <title>${title}</title>
  <meta name="description" content="${description}">
  <meta name="author" content="Florian Hirsch">

  <!-- Mobile Specific Metas
  ================================================== -->
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  <!-- CSS
  ================================================== -->
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/skeleton/1.2/base.min.css">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/skeleton/1.2/skeleton.min.css">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/skeleton/1.2/layout.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

  <!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>
<body>
  <div class="container">
    <div class="sixteen columns">
      <div class="sign-in-out-block">
        <jsp:include page="../includes/login-header.jsp" />
      </div>
    </div>
    <div class="sixteen columns">
      <h1 class="bold-header"><a href="${mvc.contextPath}" class="header">note<span class="jam">jam:</span></a> <span> ${title}</span></h1>
    </div>
    <div class="three columns">
      <jsp:invoke fragment="menu" />
    </div>
    <div class="thirteen columns content-area">
      <jsp:doBody />
    </div>
    <hr class="footer" />
    <div class="footer">
      <div>Notejam: <strong>Ozark</strong> application</div>
      <div><a href="https://github.com/komarserjio/notejam/ozark">Github</a>, <a href="https://twitter.com/lefloh">Twitter</a>, created by <a href="https://github.com/lefloh/">Florian Hirsch</a></div>
    </div>
  </div><!-- container -->
  <a href="https://github.com/komarserjio/notejam"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://s3.amazonaws.com/github/ribbons/forkme_right_gray_6d6d6d.png" alt="Fork me on GitHub"></a>
</body>
</html>



