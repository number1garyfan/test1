<?php
require_once('C:/xampp/htdocs/ICT3103Busbly/Connections/dbconnect.php');
require_once("C:/xampp/htdocs/ICT3103Busbly/HelperClass/SaltHashingHelper.php");
require_once("C:/xampp/htdocs/ICT3103Busbly/HelperClass/PasswordHelper.php");
require_once("C:/xampp/htdocs/ICT3103Busbly/Server/ServerFunction.php");


sec_session_start();

// initializing variables
$errors = array(); 

// connect to the database
$conn = $mysqli;


// LOGIN USER
if (isset($_POST['activate_account'])) {
    
  //Create class objects
  //$saltedHashingHelperObj = new SaltHashingHelper();
  
    
  //Get variables from URL
  if(!empty($_GET["id"])) {
      $activationCode = mysqli_real_escape_string($conn, $_GET["id"]);
      //Update account to activated
      account_activation($activationCode, $mysqli);
      //Prompt Box
      echo '<script type="text/javascript">
      window.onload = function () { alert("Account has been activated!"); }
      </script>';
  }
  else{
      
  }
}

  
  
 


	
	
