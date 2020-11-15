<?php 
//include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
//csrfProtector::init();

session_start();

include('/var/www/html/testen/Server/CreateAccountServer.php'); ?>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <title>Busbly Create Account</title>


        <!-- Bootstrap core CSS -->
        <link href="https://teamname.sitict.net/testen/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="https://teamname.sitict.net/testen/css/busbly-login.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <form class="form-signin" method="post" action="createAccount.php">
            <?php include('/var/www/html/testen/Server/Errors.php'); ?>
            <img class="mb-4" src="img/busbly.png" alt="" width="100" height="100">
            <h1 class="h3 mb-3 font-weight-normal">Create New Account</h1>
            <div class="form-group">   
                <label for="InputEmail1">Email address</label>
                <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<?php echo $email; ?>">
            </div>
            <div class="form-group">   
                <label for="InputUsername">Username</label>
                <input name="username" type="text" class="form-control" value="<?php echo $username; ?>">
             
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password_1" type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Confirm Password</label>
                <input name="password_2" type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <button type="submit" class="btn btn-primary" name="reg_user">Submit</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
        </form>
    </body>
</html>
