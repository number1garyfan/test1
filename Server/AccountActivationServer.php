<?php 
     require_once('/var/www/html/Connections/dbconnect.php');
     require_once("/var/www/html/Server/ServerFunction.php");
     // connect to the database
     $conn = $mysqli;
     //Get variables from URL
     if(!empty($_GET["id"])) {
         $getID = htmlentities($_GET["id"]);
         $activationCode = mysqli_real_escape_string($conn, $getID);
         //Update account to activated
         account_activation($activationCode, $mysqli);
     }
     else{

     }
?>


	
	
