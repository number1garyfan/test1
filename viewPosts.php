<?php
require_once('Connections/dbconnect.php');
require_once ('Server/ServerFunction.php');
require_once ('Functions/sessionManagement.php');
        
if (isset($_POST["ThreadID"])) {
    $threadid = filter_input(INPUT_POST, 'ThreadID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("SELECT idPost, CommentPost, Username , p.Created_By_AccountId FROM Thread td, Post p,Account a where p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread and a.idAccount = p.Created_By_AccountId and idThread = ? ;");
    $stmt->bind_param("i", $threadid);
    $stmt->execute();
    $result = $stmt->get_result();  
}

if (isset($_POST['Thread'])) {
    $thread = filter_input(INPUT_POST, 'Thread', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
}

require_once('Functions/deletePost.php');

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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="css/busbly-home.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <!-- Custom styles for this template -->

    </head>
    <body>
        <?php include './userNavigation.php' ?>

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
                                                  '.$row["CommentPost"].'
                                            </td>
                                            <td>
                                                <form action="your_url" method="post">
                                                    <button type="submit" name="your_name" value="your_value" class="btn-link">'.$row["Username"].'</button>
                                                </form>
                                            </td>';
                                
                                            if($row['Created_By_AccountId'] == $accountID){
                                                echo   '<td>
                                                <div style="display: flex;">
                                                    <form action="editPost.php" method="post">
                                                        <button type="submit" name="PostID" value= '.$row["idPost"].' class="btn btn-light"> <i class="material-icons">&#xE254;</i></button>
                                                    </form>
                                                    <form action="viewPosts.php" method="post">
                                                        <input type="hidden" name="Thread" value="' . $thread . '" />
                                                        <input type="hidden" name="ThreadID" value="' . $threadid . '" />
                                                        <button type="submit" name="PostID" value= '.$row["idPost"].' class="btn btn-light"> <i class="material-icons">&#xE872;</i></button>
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
                                No Post Available
                                </td>
                                <td></td>
                                <td></td>
                            </tr>';
                        }
                        
                        
                        ?>
                        
                </table>
                <form action="createPost.php" method="post">
                    <button type="submit" name="ThreadID" value= "<?php echo $threadid  ?>" class="btn btn-primary">New Post</button>
                </form>
            </div>

        </main>


        <footer class="container">
            <p>&copy; Company 2017-2020</p>
        </footer>


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

