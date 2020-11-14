<?php 
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include('/var/www/html/testen/Server/LoginServer.php') ?>
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
        <link href="https://teamname.sitict.net/testen/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="https://teamname.sitict.net/testen/css/busbly-login.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <form class="form-signin"  method="post" action="login.php" >
             <?php include('/var/www/html/testen/Server/Errors.php'); ?>
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
            
            <button id="login_user" name="login_user" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
        </form>
    </body>

   
</html>
