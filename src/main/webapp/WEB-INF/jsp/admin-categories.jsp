<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   
  </head>

  <body>

    <div class="row">
        <div class="col-lg-10">
            <h2>All Category</h2>
            <div class = "admin-posts-all-posts">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">
                        <h4>The most popular front-end framework for developing responsive, mobile first projects on the web.The most popular front-end framework for developing responsive, mobile first projects on the web.
                        </h4>
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">
                        <h4>Option one is this and that&mdash;be sure to include why it's great
                        </h4>
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">
                        <h4>Option one is this and that&mdash;be sure to include why it's great
                        </h4>
                    </label>
                </div>
            </div>
            <div class="btn-group new-post-btn-group">
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">create</button>
                <button type="button" class="btn btn-default">Read</button>
                <button type="button" class="btn btn-default">Edit</button>
                <button type="button" class="btn btn-default">Delete</button>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Create new category</h4>
                  </div>
                  <div class="modal-body">
                        <input type="text" class="form-control" placeholder="Category Name">
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->


    <!-- Placed at the end of the document so the pages load faster -->
    <!-- JavaScript -->
    <script src="/resources/js/modal.js"></script>
  </body>
</html>
