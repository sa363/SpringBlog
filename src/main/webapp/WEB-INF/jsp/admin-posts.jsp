<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>

  <body>

    <div class="row">
        <div class="col-lg-10">

            <h2>All Posts</h2>

            <table class="table table-hover admin-posts-table">
                <tbody>
                    <c:if test="${posts != null}">

                        <c:forEach items="${posts}" var="item">
                            <tr data-key="${item.postId}">
                                <td>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">
                                            <h4>${item.postTitle}</h4>
                                        </label>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>

            <div class="btn-group new-post-btn-group">
                <button type="button" class="btn btn-default admin-posts-read">Read</button>
                <button type="button" class="btn btn-default admin-posts-edit">Edit</button>
                <button type="button" class="btn btn-default admin-posts-delete">Delete</button>
                <button type="button" class="btn btn-default admin-posts-close-comments">Close comments</button>
                <button type="button" class="btn btn-default admin-posts-open-comments">Open comments</button>
            </div>
        </div><!-- /.col-lg-10 -->
    </div><!-- /.row -->
    <script src="/resources/js/admin-posts.js"></script>
  </body>
</html>
