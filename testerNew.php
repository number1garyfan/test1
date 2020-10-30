<?php
ini_set('session.use_cookies', 1);
session_start();
?>

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern.Bird Industires</title>
	<!--PHPxMySql connector-->

  
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css/landing-page.min.css" rel="stylesheet">
  <link rel="icon" type="image/png" href="img/favicon.png">
</head>

<body>
<?php include 'connector.php'; 
	if(isset($_POST["upload"])) {
        
    		$e = '';
    
	    try {

		    // Undefined | Multiple Files | $_FILES Corruption Attack
		    // If this request falls under any of them, treat it invalid.
		    if (
		        !isset($_FILES['upfile']['error']) ||
		        is_array($_FILES['upfile']['error'])
		    ) {
		        throw new RuntimeException('Invalid parameters.');
		    }

		    // Check $_FILES['upfile']['error'] value.
		    switch ($_FILES['upfile']['error']) {
		        case UPLOAD_ERR_OK:
		            break;
		        case UPLOAD_ERR_NO_FILE:
		            throw new RuntimeException('No file sent.');
		        case UPLOAD_ERR_INI_SIZE:
		        case UPLOAD_ERR_FORM_SIZE:
		            throw new RuntimeException('Exceeded filesize limit.');
		        default:
		            throw new RuntimeException('Unknown errors.');
		    }

		    // TEMPORARY. RMB TO CHANGE FILE SIZE IN PRODUCTION
		    if ($_FILES['upfile']['size'] > 50000) {
		        throw new RuntimeException('Exceeded filesize limit.');
		    }
		    
		}
		catch (RuntimeException $e) {
		                
		    echo $e->getMessage();
		}
		
		if ($e == ''){
            		$filename = $_FILES["upfile"]["name"];
            		$dest = "/var/www/html/modernbird.com/".$filename;
            		move_uploaded_file($_FILES["upfile"]["tmp_name"], $dest);
    
        	}
		
}
	
?>

<!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      
	  <a class="navbar-brand" href="index.php">
	  <img src="img/title.jpg">
	  </a>
      <table>
	  <?php 
			if($_SESSION['username'] == ""){
				echo "<td><a class='btn btn-primary' href='login.php'>Sign In</a></td>";
				echo "<td><a class='btn btn-primary' href='signup.php'>Sign Up</a></td>";
			} else{
				echo "<td>Welcome ".$_SESSION['username']."</td>";
				echo "</br>";
				echo "<tr><td><a class='btn btn-primary' href='logout.php'> Log Out </a></td></tr>";
			}
			
			
			
			
		?>
	  </table>
    </div>
  </nav>


  
  <!--Upload + Logic-->
	<?php 
	
		if($_SESSION['username'] != ''){
		
		
			echo "<section class='call-to-action text-white text-center'>";
			echo "<div class='overlay'></div>";
			echo "<div class='container'>";
			echo "<div class='row'>";
			echo "<div class='col-xl-9 mx-auto'>";
			echo "<h1 class='mb-4'>Welcome Admin</h1>";
			echo "</div>";
			echo "</div>";
			echo "</div>";
			echo "</section>";
			
			$ran = rand(0000,9999);
			echo "<section>";
			echo "<div class='container'>";
			echo "<div class='row no-gutters'>";
			echo "<div class='col-lg-12' style='text-align:center; margin-top:20px;'>";
			echo "<h2>Produced Today</h2>";
			echo "<h3>$ran</h3>";
			echo "<p>tons of chemicals</p>";
			echo "</div>";
			echo "</div>";
			echo "</div>";
			echo "</section>";
			
			
			echo "<section class='features-icons bg-light text-center'>";
			echo "<div class='container'>";
			echo "<div class='row no-gutters'>";
			echo "<div class='col-lg-12' style='text-align:center; margin-top:20px;'>";
			echo "<h2>Upload New Files</h2>";
			echo "<p>For Admins Only</p>";
			echo "<form method='POST' action='admin.php' enctype='multipart/form-data'>";
			echo "<input type='file' name='upfile' id='upfile'/>";
			echo "<input type='submit' name='upload' value='Upload File'/>";
			echo "</form>";
			echo "</div>";
			echo "</div>";
			echo "</div>";
			echo "</section>";
		} else {
			echo "<section class='call-to-action text-white text-center'>";
	    		echo "<div class='overlay'></div>";
	    		echo "<div class='container'>";
	      		echo "<div class='row'>";
			echo "<div class='col-xl-9 mx-auto'>";
		  	echo "<h1 class='mb-4'>403 Forbidden</h1>";
			echo "</div>";
	      		echo "</div>";
	    		echo "</div>";
	  		echo "</section>";
  		}
	
  ?>
  
	
	
	
  <!-- Footer -->
  <footer class="footer bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
          <ul class="list-inline mb-2">
            <li class="list-inline-item">
              <a href="aboutus.php">About</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <li class="list-inline-item">
              <a href="#">Contact</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <li class="list-inline-item">
              <a href="#">Terms of Use</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <li class="list-inline-item">
              <a href="#">Privacy Policy</a>
            </li>
          </ul>
          <p class="text-muted small mb-4 mb-lg-0">&copy; Modern.Bird Industrials. All Rights Reserved.</p>
        </div>
        <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
          <ul class="list-inline mb-0">
            <li class="list-inline-item mr-3">
              <a href="#">
                <i class="fab fa-facebook fa-2x fa-fw"></i>
              </a>
            </li>
            <li class="list-inline-item mr-3">
              <a href="#">
                <i class="fab fa-twitter-square fa-2x fa-fw"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-instagram fa-2x fa-fw"></i>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>