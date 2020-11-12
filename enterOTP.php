<?php 
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include('Server/OTPServer.php');

//if(!isset($_SESSION['AccountId']) && !isset($_SESSION['OTPVerified'])){
//    header('Location: login.php');
//}else{
//   $accountID = $_SESSION['AccountId']; 
//}
?>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Busbly Enter OTP</title>


    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/busbly-login.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" method="post" action="enterOTP.php">
        <?php include('Server/Errors.php'); ?>
        <img class="mb-4" src="img/busbly.png" alt="" width="100" height="100">
  <h1 class="h3 mb-3 font-weight-normal">Enter OTP</h1>
  <h6>An OTP email has been sent to your email</h6>
  <input name="otp" type="password" class="form-control" id="exampleInputPassword1">
  <button name="enter_otp" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
</body>
</html>
