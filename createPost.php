<?php
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

require_once ('/var/www/html/Server/ServerFunction.php');
require_once ('/var/www/html/Functions/sessionManagement.php');
require_once ('/var/www/html/Functions/insertPost.php');

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
        <link href="https://teamname.sitict.net/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="https://teamname.sitict.net/css/Busbly-home.css" rel="stylesheet">
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

                <h3>Create Post</h3>

                <form name="myForm" action="createPost.php" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                  <label for="PostContent">Post</label>
                  <textarea class="form-control" id="PostContent" name="PostComment" rows="3" required></textarea>
                </div>
                    <input type="hidden" name="ThreadID" value="<?php echo $threadid ?>" />
                    <button type="submit" class="btn btn-primary">Submit</button>
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript">// Basic example
            $(document).ready(function () {
                $('#dtBasicExample').DataTable({
                    paging: true,
                    searching: false// false to disable pagination (or any other option)
                });
                $('.dataTables_length').addClass('bs-select');
            });
        </script>
                <script>
function validateForm() {
  var format = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
      
  var post = document.forms["myForm"]["PostComment"].value;
  if (post === "") {
    alert("Post must not be empty");
    return false;
  }else if (format.test(post)){
    alert("Post must not contain special characters");  
    return false;
  }else if (post.length >= 255){
    alert("Post exceeded max length");   
    return false;
  }
}
        </script>
        
</html>

