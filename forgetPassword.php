<?php 
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include('/var/www/html/Server/ForgetPasswordServer.php');
?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Busbly Forget Password</title>


    <!-- Bootstrap core CSS -->
    <link href="/var/www/html/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/var/www/html/css/busbly-login.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" method="post" action="forgetPassword.php">
        <?php include('/var/www/html/Server/Errors.php'); ?>
        <img class="mb-4" src="/var/www/html/img/busbly.png" alt="" width="100" height="100">
  <h1 class="h3 mb-3 font-weight-normal">Forget Password?</h1>
  <h6>Do not worry! Just enter your email address and we will send you the one-time password</h6>
  <label for="inputEmail" class="sr-only">Email address</label>
  <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address">
  <button name="forget_password" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
</body>
</html>
