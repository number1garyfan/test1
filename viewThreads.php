<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<?php
if (null !== (filter_input(INPUT_POST, 'Topic'))) {
    $topic = filter_input(INPUT_POST, 'Topic');
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
echo "<h3>$topic</h3>"
?>


                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th class="th-sm">Thread</th>
                            <th class="th-sm">Last Post </th>
                            <th class="th-sm">Posts</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <form action="viewPosts.php" method="post">
                                    <button type="submit" name="Thread" value="Best place to camp for bus." class="btn-link">Best place to camp for bus.</button>
                                </form>
                            </td>
                            <td>
                                <form action="your_url" method="post">
                                    <button type="submit" name="User" value="your_value" class="btn-link">By Yap Yong Sheng</button>
                                </form>
                            </td>
                            <td>30</td>
                        </tr>
                        <tr>
                            <td>
                                <form action="viewPosts.php" method="post">
                                    <button type="submit" name="Thread" value="Bus Lover Community." class="btn-link">Bus Lover Community.</button>
                                </form>
                            </td>
                            <td>
                                <form action="your_url" method="post">
                                    <button type="submit" name="User" value="your_value" class="btn-link">By Yap Yong Sheng</button>
                                </form>
                            </td>
                            <td>20</td>
                        </tr>
                </table>
                  <a class="btn btn-primary" href="createThread.php" role="button">New Thread</a>
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

