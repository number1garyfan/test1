<?php
require_once('Connections/dbconnect.php');
require_once("HelperClass/SaltHashingHelper.php");
require_once("HelperClass/PasswordHelper.php");
require_once("Server/ServerFunction.php");

sec_session_start();

// initializing variables
$username = "";
$email    = "";
$errors = array(); 

// connect to the database
$conn = $mysqli;

// REGISTER NEW PASSWORD
if (isset($_POST['reset_password'])) {
  //Create class objects
  $passwordHelperObj = new PasswordHelper();
  $saltedHashingHelperObj = new SaltHashingHelper();

  // receive all input values from the form
  $password_1 = mysqli_real_escape_string($conn, htmlentities($_POST['password_1']));
  $password_2 = mysqli_real_escape_string($conn, htmlentities($_POST['password_2']));

  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($password_1)) { array_push($errors, "Password is required"); }
  else if ($password_1 != $password_2) {array_push($errors, "The two passwords do not match");}
  else if (!$passwordHelperObj->check_password_strength($password_1))  {array_push($errors, "Password must consist of 8-16 characters, at least 1 lower and upper case alphabet, 1 number and 1 special character");}
  else{      
    // Finally, register user if there are no errors in the form
    if (count($errors) == 0) {
        //Assign Variables
        $salt = $saltedHashingHelperObj->generate_password_salt();
        $saltedHashedPw = $saltedHashingHelperObj->salted_hashing_password($salt, $password_1);
        
        //Send email to next page using Session
        $email = $_SESSION["email_address_otp"];
        
        //Reset Password 
        reset_password($saltedHashedPw, $salt, $email, $mysqli);
        
        echo '<script type="text/javascript">
            window.onload = function () { alert("Password Reset!"); }
            </script>';
    }
  } 
}

  
  
 


	
	
