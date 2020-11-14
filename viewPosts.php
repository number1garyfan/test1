<?php
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

require_once('/var/www/html/testen/Connections/dbconnect.php');
require_once ('/var/www/html/testen/Server/ServerFunction.php');
require_once ('/var/www/html/testen/Functions/sessionManagement.php');

if (isset($_POST["ThreadID"])) {
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);

    $result = read_post($threadid, $mysqli);
}else{
      header('Location: https://teamname.sitict.net/testen/index.php');
}

if (isset($_POST['Thread'])) {
    $thread = filter_input(INPUT_POST, 'Thread', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
}else{
      header('Location: https://teamname.sitict.net/testen/index.php');
}

require_once('/var/www/html/testen/Functions/deletePost.php');
require_once('/var/www/html/testen/Functions/reportPost.php');
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
                echo "<h3>$thread</h3>"
                ?>

                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Post</th>
                            <th class="th-sm">By</th>
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
                                                  ' . $row["CommentPost"] . '
                                            </td>
                                            <td>
                                                <form action="viewProfile.php" method="post">
                                                    <button type="submit" name="accountID" value='.$row["Created_By_AccountId"].' class="btn-link">' . $row["Username"] . '</button>
                                                </form>
                                            </td>';

                                if ($row['Created_By_AccountId'] == $accountID || $_SESSION['Roles'] == 1) {
                                    echo '<td>
                                                <div style="display: flex;">
                                                    <form action="editPost.php" method="post">
                                                        <button type="submit" name="PostID" value= ' . $row["idPost"] . ' class="btn btn-light"> <i class="material-icons">&#xE254;</i></button>
                                                    </form>
                                                    <form action="viewPosts.php" method="post">
                                                        <input type="hidden" name="Delete" value="Delete" />
                                                        <input type="hidden" name="Thread" value="' . $thread . '" />
                                                        <input type="hidden" name="ThreadID" value="' . $threadid . '" />
                                                        <button type="submit" name="PostID" value= ' . $row["idPost"] . ' class="btn btn-light"> <i class="material-icons">&#xE872;</i></button>
                                                    </form>
                                                </div>
                                                
                                                </td>
                                            </tr>';
                                } else if ($_SESSION['Roles'] == 4) {
                                    echo '<td>
                                                <div style="display: flex;">
                                                    <form action="editPost.php" method="post">
                                                        <button type="submit" name="PostID" value= ' . $row["idPost"] . ' class="btn btn-light"> <i class="material-icons">&#xE254;</i></button>
                                                    </form>
                                                    <form action="viewPosts.php" method="post">
                                                        <input type="hidden" name="Delete" value="Delete" />
                                                        <input type="hidden" name="Thread" value="' . $thread . '" />
                                                        <input type="hidden" name="ThreadID" value="' . $threadid . '" />
                                                        <button type="submit" name="PostID" value= ' . $row["idPost"] . ' class="btn btn-light"> <i class="material-icons">&#xE872;</i></button>
                                                    </form>
                                                    <form action="viewPosts.php" method="post">
                                                        <input type="hidden" name="Report" value="Report" />
                                                        <input type="hidden" name="Thread" value="' . $thread . '" />
                                                        <input type="hidden" name="ThreadID" value="' . $threadid . '" />
                                                        <button type="submit" name="AccountID" value= ' . $row["Created_By_AccountId"] . ' class="btn btn-light"> <i class="material-icons">&#xe8b2;</i></button>
                                                    </form>
                                                </div>
                                                
                                                </td>
                                            </tr>';
                                } else {
                                    echo '<td>
                                                        <form action="viewPosts.php" method="post">
                                                            <input type="hidden" name="Report" value="Report" />
                                                            <input type="hidden" name="Thread" value="' . $thread . '" />
                                                            <input type="hidden" name="ThreadID" value="' . $threadid . '" />
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
                                No Post Available
                                </td>
                                <td></td>
                                <td></td>
                            </tr>';
                        }
                        ?>

                </table>
                <form action="createPost.php" method="post">
                    <button type="submit" name="ThreadID" value= "<?php echo $threadid ?>" class="btn btn-primary">New Post</button>
                </form>
            </div>

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
                    searching: false// false to disable pagination (or any other option)
                });
                $('.dataTables_length').addClass('bs-select');
            });
        </script>
</html>

