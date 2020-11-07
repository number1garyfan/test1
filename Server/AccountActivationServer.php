<?php 
     require_once('C:/xampp/htdocs/ICT3103Busbly/Connections/dbconnect.php');
     require_once("C:/xampp/htdocs/ICT3103Busbly/Server/ServerFunction.php");
     
     sec_session_start();
     
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


	
	
