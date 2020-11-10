<?php 
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include('Server/LoginServer.php') ?>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <title>Busbly Login</title>

        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/busbly-login.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <form class="form-signin"  method="post" action="login.php" onsubmit="return validateRecaptcha()">
             <?php include('Server/Errors.php'); ?>
            <img class="mb-4" src="img/busbly.png" alt="" width="100" height="100">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address">
            <label for="inputPassword" class="sr-only">Password</label>
            <input name="password_1" type="password" id="inputPassword" class="form-control" placeholder="Password">
            <div class="checkbox mb-3">
                <label>
                    <a href="createAccount.php">Sign Up</a>
                </label>
                <label>
                    <a href="forgetPassword.php">Forget Password?</a>
                </label>
            </div>
            
             <div class="g-recaptcha" data-sitekey="6Lft5OAZAAAAAJKeApMUowCQoKjNS7H69YLen0KP" data-callback="enableBtn"></div>
            
            <button id="login_user" name="login_user" class="btn btn-lg btn-primary btn-block" type="submit" disabled>Sign in</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
        </form>
    </body>
    <script type="text/javascript">
    function validateRecaptcha() {
    var response = grecaptcha.getResponse();
    if (response.length === 0) {
        document.getElementById("login_user").disabled = true;
        alert("Please validate on the reCaptcha");
        return false;
    } else {
        document.getElementById("login_user").disabled = false;
        //alert("validated");
        return true;
    }
}
    </script>
    <script type="text/javascript">
     function enableBtn(){
        document.getElementById("login_user").disabled = false;
    }
    </script>
   
</html>
