<?php
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

require_once('/var/www/html/testen/Connections/dbconnect.php');
require_once ('/var/www/html/testen/Server/ServerFunction.php');
require_once ('/var/www/html/testen/Functions/sessionManagement.php');


if (isset($_POST["TopicID"])) {
    $topicid = filter_input(INPUT_POST, 'TopicID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);

    $result = read_thread($topicid, $mysqli);
}else{
      header('Location: https://teamname.sitict.net/testen/index.php');
}

if (isset($_POST["Topic"])) {
    $topic = filter_input(INPUT_POST, 'Topic', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
}else{
      header('Location: https://teamname.sitict.net/testen/index.php');
}


require_once('/var/www/html/testen/Functions/deleteThread.php');
require_once('/var/www/html/testen/Functions/reportThread.php');
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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

                <?php
                echo "<h3>$topic</h3>"
                ?>


                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Thread</th>
                            <th class="th-sm">Posts</th>
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
                                                <form action="viewPosts.php" method="post">
                                                    <input type="hidden" name="ThreadID" value="' . $row["idThread"] . '" />
                                                    <button type="submit" name="Thread" value="' . $row["ThreadTitle"] . '" class="btn-link">' . $row["ThreadTitle"] . '</button>
                                                </form>
                                            </td>
                                            <td>' . $row["PostNo"] . '</td>';


                                if ($row['Created_By_AccountId'] == $accountID || $_SESSION['Roles'] == 1) {
                                    echo '<td>
                                                <div style="display: flex;">
                                                    <form action="editThread.php" method="post">
                                                        <button type="submit" name="ThreadID" value= ' . $row["idThread"] . ' class="btn btn-light"> <i class="material-icons">&#xE254;</i></button>
                                                    </form>
                                                    <form action="viewThreads.php" method="post">
                                                        <input type="hidden" name="Delete" value="Delete" />
                                                        <input type="hidden" name="Topic" value="' . $topic . '" />
                                                        <input type="hidden" name="TopicID" value="' . $topicid . '" />
                                                        <button type="submit" name="ThreadID" value= ' . $row["idThread"] . ' class="btn btn-light"> <i class="material-icons">&#xE872;</i></button>
                                                    </form>
                                                </div>
                                                
                                                </td>
                                            </tr>';
                                } else if ($_SESSION['Roles'] == 4) {
                                    echo '<td>
                                                    <div style="display: flex;">
                                                        <form action="editThread.php" method="post">
                                                            <button type="submit" name="ThreadID" value= ' . $row["idThread"] . ' class="btn btn-light"> <i class="material-icons">&#xE254;</i></button>
                                                        </form>
                                                        <form action="viewThreads.php" method="post">
                                                            <input type="hidden" name="Delete" value="Delete" />
                                                            <input type="hidden" name="Topic" value="' . $topic . '" />
                                                            <input type="hidden" name="TopicID" value="' . $topicid . '" />
                                                            <button type="submit" name="ThreadID" value= ' . $row["idThread"] . ' class="btn btn-light"> <i class="material-icons">&#xE872;</i></button>
                                                        </form>
                                                        <form action="viewThreads.php" method="post">
                                                            <input type="hidden" name="Report" value="Report" />
                                                            <input type="hidden" name="Topic" value="' . $topic . '" />
                                                            <input type="hidden" name="TopicID" value="' . $topicid . '" />
                                                            <button type="submit" name="AccountID" value= ' . $row["Created_By_AccountId"] . ' class="btn btn-light"> <i class="material-icons">&#xe8b2;</i></button>
                                                        </form>
                                                    </div>

                                                    </td>
                                                </tr>';
                                } else {
                                    echo '<td>
                                            <form action="viewThreads.php" method="post">
                                                <input type="hidden" name="Report" value="Report" />
                                                <input type="hidden" name="Topic" value="' . $topic . '" />
                                                <input type="hidden" name="TopicID" value="' . $topicid . '" />
                                                <button type="submit" name="AccountID" value= ' . $row["Created_By_AccountId"] . ' class="btn btn-light"> <i class="material-icons">&#xe8b2;</i></button>
                                            </form>
                                         </td> 
                                    </tr>';
                                }
                            }
                        } else {
                            echo '                       
                            <tr>
                                <td>
                                No Thread Available
                                </td>
                                <td></td>
                                <td></td>
                            </tr>';
                        }
                        ?>

                </table>
                <form action="createThread.php" method="post">
                    <button type="submit" name="TopicID" value= "<?php echo $topicid ?>" class="btn btn-primary">New Thread</button>
                </form>

            </div> <!-- /container -->

        </main>


        <footer class="container">
            <p>&copy; Company 2017-2020</p>
        </footer>
  </body>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/bootstrap.bundle.js"></script>
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

