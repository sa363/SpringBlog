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
                <button class="btn newpost-category-btn-name">Category</button>
                <button class="btn dropdown-toggle newpost-category-btn" data-toggle="dropdown">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu newpost-category-select-menu">
                    <!-- dropdown menu links -->
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
