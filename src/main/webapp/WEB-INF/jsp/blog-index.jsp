<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 14-5-12
  Time: 上午9:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SpringBlog</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/blog.css" rel="stylesheet">
    <script src="/resources/js/jquery-1.10.2.js"></script>
</head>

<body>

  <tiles:insertAttribute name="header" />
  <div class="container blog-container-wrap">


    <div class="row">
      <div class="col-lg-8 blog-container-wrap-content">
          <!-- blog-->

      </div>
      <div class="col-lg-4">
        <tiles:insertAttribute name="menu"/>
      </div>
    </div>


  </div>
  <tiles:insertAttribute name="footer"/>


  <!-- JavaScript -->

  <script src="/resources/js/bootstrap.js"></script>
  <script src="/resources/js/json.min.js"></script>
  <script src="/resources/js/blog.js"></script>


</body>
</html>