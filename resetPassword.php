<?php include('Server/ResetPasswordServer.php') ?>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <title>Busbly Reset Password</title>


        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/busbly-login.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <form class="form-signin" method="post" action="resetPassword.php">
            <?php include('Server/Errors.php'); ?>
            <img class="mb-4" src="img/busbly.png" alt="" width="100" height="100">
            <h1 class="h3 mb-3 font-weight-normal">Reset Password</h1>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password_1" type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Confirm Password</label>
                <input name="password_2" type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <button type="submit" class="btn btn-primary" name="reset_password">Submit</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
        </form>
    </body>
</html>
