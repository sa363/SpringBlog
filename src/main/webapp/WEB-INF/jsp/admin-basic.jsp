<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog Home Template for Bootstrap 3</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="/resources/css/admin.css" rel="stylesheet">

    <script src="/resources/js/jquery-1.10.2.js"></script>

</head>

<body>
    <tiles:insertAttribute name="header" />
    <!-- /.container -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <tiles:insertAttribute name="menu"/>
            </div>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </div>

    <!-- JavaScript -->

    <script src="/resources/js/bootstrap.js"></script>
    <script src="/resources/js/admin.js"></script>

</body>

</html>
