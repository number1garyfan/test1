<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<?php
if (null !== (filter_input(INPUT_POST, 'Thread'))) {
    $thread = filter_input(INPUT_POST, 'Thread');
}
?>
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

                <?php
                echo "<h3>$thread</h3>"
                ?>

                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Post</th>
                            <th class="th-sm">By</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                  I have  joined other enthusiasts at Woodlands Interchange at about 11am to wait for a Mercedes-Benz O405 bus to arrive. The group then went up the bus and rode the service from Woodlands to its terminal stop at HarbourFront — a journey that took 50 minutes
                            </td>
                            <td>
                                <form action="your_url" method="post">
                                    <button type="submit" name="your_name" value="your_value" class="btn-link">Yap Yong Sheng</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                would hop on a bus and then hop off after travelling for a distance, before getting onto another service and getting off again
                            </td>
                            <td>
                                <form action="your_url" method="post">
                                    <button type="submit" name="your_name" value="your_value" class="btn-link">Yap Yong Sheng</button>
                                </form>
                            </td>
                        </tr>
                </table>
                <a class="btn btn-primary" href="createPost.php" role="button">New Post</a>
            </div>

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

