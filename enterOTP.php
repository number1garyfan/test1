<?php 
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include('/var/www/html/Server/OTPServer.php');
//|| $_SESSION["forget_otp_page"] != true
if($_SESSION["otp_page"] == true || $_SESSION["forget_otp_page"] == true){
   
}else{
    header('Location: https://teamname.sitict.net/login.php'); 
}


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

    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
    <!-- Bootstrap core CSS -->
    <link href="https://teamname.sitict.net/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://teamname.sitict.net/css/busbly-login.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" method="post" action="enterOTP.php">
        <?php include('/var/www/html/Server/Errors.php'); ?>
        <img class="mb-4" src="img/busbly.png" alt="" width="100" height="100">
  <h1 class="h3 mb-3 font-weight-normal">Enter OTP</h1>
  <h6>An OTP email has been sent to your email</h6>
  <input name="otp" type="password" class="form-control" id="exampleInputPassword1">

  <button name="enter_otp" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
</body>
 <script type="text/javascript">
    function validateRecaptcha() {
    var response = grecaptcha.getResponse();
    if (response.length === 0) {
        document.getElementById("enter_otp").disabled = true;
        alert("Please validate on the reCaptcha");
        return false;
    } else {
        document.getElementById("enter_otp").disabled = false;
        //alert("validated");
        return true;
    }
}
    </script>
    <script type="text/javascript">
     function enableBtn(){
        document.getElementById("enter_otp").disabled = false;
    }
    </script>
</html>
