<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
  <body>
    <div class="row">
      <div class="col-lg-10">
        <div class="input-group">
            <div class="input-group-btn">
              <button tabindex="-1" class="btn btn-default newpost-category-btn-name" type="button">Category</button>
              <button tabindex="-1" data-toggle="dropdown" class="btn btn-default dropdown-toggle newpost-category-btn" type="button">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
              </button>
              <ul role="menu" class="dropdown-menu newpost-category-select-menu">
                <%--<li><a href="#">Java</a></li>--%>
                <%--<li><a href="#">C++</a></li>--%>
                <%--<li><a href="#">Python</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="#">Nodejs</a></li>--%>
              </ul>
            </div>
            <input type="text" class="form-control admin-new-post-title">
        </div><!-- /input-group -->
      </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <div class="row">
        <div class="col-lg-10">
            <textarea class="admin-new-post-content " >
            </textarea>
            <div class="alert admin-new-post-alert">
                <strong class="new-post-alert-msg-one">Well done!</strong>
                <span class="new-post-alert-msg-one">You successfully save this post.</span>
            </div>
            <div class="btn-group new-post-btn-group">
                <button type="button" class="btn btn-default new-post-cancel-btn">Cancel</button>
                <button type="button" class="btn btn-default new-post-save-btn">Save</button>
                <button type="button" class="btn btn-default new-post-publish-btn">Publish</button>
            </div>
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

   <script src="/resources/js/admin-newpost.js"/>
  </body>
</html>
