<?php
//include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
//csrfProtector::init();


session_start();

require_once ('/var/www/html/testen/Connections/dbconnect.php');
require_once ('/var/www/html/testen/Server/ServerFunction.php');
require_once ('/var/www/html/testen/Functions/sessionManagement.php');

if ($_SESSION['Roles'] != 1) {
    header('Location: https://teamname.sitict.net/testen/logout.php');
}

require_once ('/var/www/html/testen/Functions/updateRoles.php');
require_once ('/var/www/html/testen/Functions/banUser.php');

$result = read_user($mysqli);
$result2 = read_user($mysqli);
?>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <title>Busbly Forum</title>

        <!-- Bootstrap core CSS -->
        <link href="https://teamname.sitict.net/testen/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="https://teamname.sitict.net/testen/css/Busbly-home.css" rel="stylesheet">
        <!-- Custom styles for this template -->

    </head>
    <body>
<?php include '/var/www/html/testen/userNavigation.php' ?>

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron bg-img">
                <div class="container">
                    <h1 class="display-3 white">Busbly Forum</h1>
                    <p class="white">This is forum is for bus lover only.</p>
                </div>
            </div>

            <div class="container">

                <h3>Manage Account</h3>

                <h4>Promote Account</h4>
                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Username</th>
                            <th class="th-sm">Roles</th>
                            <th class="th-sm">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        if ($result->num_rows > 0) {
                            // output data of each row
                            while ($row = $result->fetch_assoc()) {
                                echo '  <tr>
           
                                            <td>'.$row["Username"].'</td>
                                            <td>'.$row["Roles"].'</td>
                                            <td>
                                            <div style="display: flex;"> 
                                            <form action="manageAccount.php" method="post">
                                                <input type="hidden" name="promoteMod" value="promote" />
                                                <button type="submit" name="AccountID" value= '.$row["idAccount"].' class="btn btn-primary">Promote to Moderator</button>
                                            </form>
                                            
                                            <form action="manageAccount.php" method="post">
                                                <input type="hidden" name="promoteAdmin" value="promote" />
                                                <button type="submit" name="AccountID" value= '.$row["idAccount"].' class="btn btn-primary">Promote to Admin</button>
                                            </form>
                                            <form action="manageAccount.php" method="post">
                                                <input type="hidden" name="demoteUser" value="demote" />
                                                <button type="submit" name="AccountID" value= '.$row["idAccount"].' class="btn btn-danger">Demote to User</button>
                                            </form>
                                            </div>
                                            </td>
                                            </tr>';
                                            }
                            }

                        ?>
                </table>
                
                <h4>Ban Account Account</h4>
                
                <table id="dtBasicExample2" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Username</th>
                            <th class="th-sm">Reported Count</th>
                            <th class="th-sm">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        if ($result2->num_rows > 0) {
                            // output data of each row
                            while ($row = $result2->fetch_assoc()) {
                                echo '  <tr>
           
                                            <td>'.$row["Username"].'</td> <td>'.$row["ReportCounter"].'</td>';
                                              if($row['Banned'] != 1 ){
                                            echo '<td>
                                                
                                            <form action="manageAccount.php" method="post">
                                                <input type="hidden" name="banUser" value="banUser" />
                                                <button type="submit" name="AccountID" value= '.$row["idAccount"].' class="btn btn-danger">Ban</button>
                                            </form>
    
                                            </td>
                                            </tr>';
                                              }else{
                                             echo '<td>
                                                
                                            <form action="manageAccount.php" method="post">
                                                <input type="hidden" name="unbanUser" value="unbanUser" />
                                                <button type="submit" name="AccountID" value= '.$row["idAccount"].' class="btn btn-primary">UnBan</button>
                                            </form>
    
                                            </td>
                                            </tr>'; 
                                              }
                                            }
                            }

                        ?>
                </table>
                
            </div> <!-- /container -->

        </main>


        <footer class="container">
            <p>&copy; Company 2017-2020</p>
        </footer>
    </body>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript">// Basic example
        $(document).ready(function () {
            $('#dtBasicExample').DataTable({
                paging: true,
                searching: false// false to disable pagination (or any other option)
            });
            
            $('#dtBasicExample2').DataTable({
                paging: true,
                searching: false// false to disable pagination (or any other option)
            });
            
            

        });
    </script>
    <script>
        function validateForm() {
            var topic = document.forms["myForm"]["TopicName"].value;
            if (topic === "") {
                alert("Topic must not be empty");
                return false;
            }
        }
    </script>

</html>

