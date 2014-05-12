<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-lg-10">

        <h1><c:out value="${post.postTitle}"/></h1>

        <p class="lead">by <span><c:out value="${author}"/></span>
        </p>
        <hr>
        <p>
            <span class="glyphicon glyphicon-time"></span>Posted on <c:out value="${postDate}"/>
        </p>
        <hr>

        <p class="post-content">${post.postContent}</p>

        <hr>
    </div>
</div>