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
              <button tabindex="-1" class="btn btn-default" type="button">Category</button>
              <button tabindex="-1" data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
              </button>
              <ul role="menu" class="dropdown-menu">
                <li><a href="#">Java</a></li>
                <li><a href="#">C++</a></li>
                <li><a href="#">Python</a></li>
                <li class="divider"></li>
                <li><a href="#">Nodejs</a></li>
              </ul>
            </div>
            <input type="text" class="form-control">
        </div><!-- /input-group -->
      </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <div class="row">
        <div class="col-lg-10">
            <textarea class="new-post-content " >
            </textarea>
            <div class="btn-group new-post-btn-group">
                <button type="button" class="btn btn-default">Cancel</button>
                <button type="button" class="btn btn-default">Save</button>
                <button type="button" class="btn btn-default">Publish</button>
            </div>
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

  </body>
</html>
