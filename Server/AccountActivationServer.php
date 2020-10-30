<?php 
     require_once('C:/xampp/htdocs/ICT3103Busbly/Connections/dbconnect.php');
     require_once("C:/xampp/htdocs/ICT3103Busbly/Server/ServerFunction.php");
     // connect to the database
     $conn = $mysqli;
     //Get variables from URL
     if(!empty($_GET["id"])) {
         $activationCode = mysqli_real_escape_string($conn, $_GET["id"]);
         //Update account to activated
         account_activation($activationCode, $mysqli);
     }
     else{

     }
?>


	
	
