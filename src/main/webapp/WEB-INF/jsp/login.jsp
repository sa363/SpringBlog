<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">

    <script type="text/javascript" src="/resources/js/jquery-1.4.min.js"></script>
    <script type="text/javascript" src="/resources/js/json.min.js"></script>

  </head>

  <body>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control form-signin-name" placeholder="User name" required autofocus>
        <input type="password" class="form-control form-signin-password" placeholder="Password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <a class="btn btn-lg btn-primary btn-block btn-login">Sign in</a>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>

  <script>
      $(document).ready(function(){

          $('.btn-login').click(function(){
              var name = $('.form-signin-name').val();
              var password = $('.form-signin-password').val();

              var data = {
                  name : name,
                  password : password
              }
              var url = 'login';
              console.log(data);
              $.postJSON(url,data,function(data){

                  console.log(data);

              })
          });

      });
  </script>
</html>
