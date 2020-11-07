<?php
require_once('Connections/dbconnect.php');

$sql = "SELECT Roles FROM Roles";
$result = $mysqli->query($sql);
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

                <h3>Topics</h3>
                <h2>
                    <?php
                    if ($result->num_rows > 0) {
                        // output data of each row
                        while ($row = $result->fetch_assoc()) {
                            echo $row["Roles"];
                        }
                    } else {
                        echo "no";
                    }
                    ?>


                </h2>
                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Topic</th>
                            <th class="th-sm">Last Post</th>
                            <th class="th-sm">Threads</th>
                            <th class="th-sm">Post
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <form action="viewThreads.php" method="post">
                                    <button type="submit" name="Topic" value="Bus Lover Topic 1" class="btn-link">Bus Lover Topic 1</button>
                                </form>
                            </td>
                            <td>
                                <form action="your_url" method="post">
                                    <button type="submit" name="Post" value="Why I love Bus" class="btn-link">Why I love Bus By Yap Yong Sheng</button>
                                </form>
                            </td>
                            <td>100,000</td>
                            <td>1,000,000</td>
                        </tr>
                        <tr>
                            <td>
                                <form action="viewThreads.php" method="post">
                                    <button type="submit" name="Topic" value="Bus Lover Topic 2" class="btn-link">Bus Lover Topic 2</button>
                                </form>
                            </td>
                            <td>
                                <form action="your_url" method="post">
                                    <button type="submit" name="Post" value="Why I love Bus" class="btn-link">Why I love Bus By Yap Yong Sheng</button>
                                </form>
                            </td>
                            <td>100,000</td>
                            <td>1,000,000</td>
                        </tr>
                </table>
                <a class="btn btn-primary" href="createTopic.php" role="button">New Topic</a>
            </div> <!-- /container -->

        </main>


        <footer class="container">
            <p>&copy; Company 2017-2020</p>
        </footer>


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

