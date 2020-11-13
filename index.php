<?php
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

require_once ('/var/www/html/Connections/dbconnect.php');
require_once ('/var/www/html/Server/ServerFunction.php');
require_once ('/var/www/html/Functions/sessionManagement.php');


$result = read_topic($mysqli);


require_once('/var/www/html/Functions/deleteTopic.php')
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
        <link href="/var/www/html/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="/var/www/html/css/busbly-home.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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

                <h3>Topics</h3>

                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Topic</th>
                            <th class="th-sm">Threads</th>
                            <th class="th-sm">Post</th>
                            <th class="th-sm">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        if ($result->num_rows > 0) {
                            // output data of each row
                            while ($row = $result->fetch_assoc()) {
                                echo '  <tr>
                                            <td>
                                                <form action="viewThreads.php" method="post">
                                                    <input type="hidden" name="TopicID" value="'.$row["idTopic"].'" />
                                                    <button type="submit" name="Topic" value="'.$row["TopicTitle"].'" class="btn-link">'.$row["TopicTitle"].'</button>
                                                </form>
                                            </td>
                                            <td>'.$row["ThreadNo"].'</td>
                                            <td>'.$row["PostNo"].'</td>';
                                            //user that created and admin (able to delete and edit all topic,thread,post)
                                            if($row['Created_By_AccountId'] == $accountID || $_SESSION['Roles'] == 1){
                                                echo   '<td>
                                                <div style="display: flex;">
                                                    <form action="editTopic.php" method="post">
                                                        <button type="submit" name="TopicID" value= '.$row["idTopic"].' class="btn btn-light"> <i class="material-icons">&#xE254;</i></button>
                                                    </form>
                                                    <form action="index.php" method="post">
                                                        <button type="submit" name="TopicID" value= '.$row["idTopic"].' class="btn btn-light"> <i class="material-icons">&#xE872;</i></button>
                                                    </form>
                                                </div>
                                                
                                                </td>
                                            </tr>';
                                            }else{
                                                echo '<td></td> 
                                                    </tr>';
                                            }
                            }
                        } else {
                            echo '                       
                            <tr>
                                <td>
                                No Topic Available
                                </td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>';
                        }
                        ?>
                </table>
                <?php 
                if($_SESSION['Roles'] == 1){
                echo '<a class="btn btn-primary" href="createTopic.php" role="button">New Topic</a>';
                }?>
            </div> <!-- /container -->

        </main>


        <footer class="container">
            <p>&copy; Company 2017-2020</p>
        </footer>
  </body>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="/var/www/html/js/bootstrap.bundle.js"></script>
        <script type="text/javascript">// Basic example
            $(document).ready(function () {
                $('#dtBasicExample').DataTable({
                    paging: true,
                    searching: true// false to disable pagination (or any other option)
                });
                $('.dataTables_length').addClass('bs-select');
            });
        </script>
</html>

