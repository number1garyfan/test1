<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<?php 

include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

include ('/var/www/html/Server/ServerFunction.php');
include('/var/www/html/Server/updateProfileServer.php');
require_once ('/var/www/html/Functions/sessionManagement.php');?>


<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <title>Busbly Forum</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="css/busbly-home.css" rel="stylesheet">
        <!-- Custom styles for this template -->

    </head>
    <body>
        <?php include '/var/www/html/userNavigation.php' ?>

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron bg-img">
                <div class="container">
                    <h1 class="display-3 white">Busbly Forum</h1>
                    <p class="white">This is forum is for bus lover only.</p>
                </div>
            </div>

            <div class="container">

                <h3>Update Profile</h3>

                <form method="post" action="updateProfile.php">
                <?php include('/var/www/html/Server/Errors.php'); ?>
                <?php
                    //Retrieve account details
                    $result = getAccountDetailsForUpdate($_SESSION["Email"], $mysqli);
                    if ($result->num_rows > 0) {
                            // output data of each row
                            while ($row = $result->fetch_assoc()) { ?>
                <div class="form-group">   
                <label for="InputEmail1">Email address</label>
                <input name="email" value=<?php echo $row["Email"];?> type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="form-group">   
                <label for="InputUsername">Username</label>
                <input name="username" value=<?php echo $row["Username"];?> type="text" class="form-control">
             
            </div>
            <div class="form-group">
                <input type="hidden" value=<?php echo $row["Password"];?> name="hidden" for="hiddenField" ></label>
                <label for="exampleInputPassword1">Password</label>
                <input name="password_1" value=<?php echo $row["Password"];?> type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Confirm Password</label>
                <input name="password_2" value=<?php echo $row["Password"]; }}?> type="password" class="form-control" id="exampleInputPassword1">
            </div>
                    <button name="update_profile" type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div> <!-- /container -->

        </main>


        <footer class="container">
            <p>&copy; Company 2017-2020</p>
        </footer>
    </body>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script src="js/bootstrap.bundle.js"></script>
        <script type="text/javascript">// Basic example
            $(document).ready(function () {
                $('#dtBasicExample').DataTable({
                    paging: true,
                    searching: false// false to disable pagination (or any other option)
                });
                $('.dataTables_length').addClass('bs-select');
            });
        </script>
</html>

