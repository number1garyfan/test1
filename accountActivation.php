<?php 
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include('Server/AccountActivationServer.php') ?>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Busbly Account Activation</title>


    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/busbly-login.css" rel="stylesheet">
  </head>
  <body class="text-center">
      <form class="form-signin">
        <img class="mb-4" src="img/busbly.png" alt="" width="100" height="100">
  <h2>Account Has Been Activated !</h2>
  <?php include('Server/AccountActivationServer.php'); ?>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
</body>
</html>
