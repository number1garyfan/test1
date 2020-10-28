<?php
require_once('C:/xampp/htdocs/ICT3103Busbly/Connections/dbconnect.php');
require_once("C:/xampp/htdocs/ICT3103Busbly/Server/ServerFunction.php");
require_once("C:/xampp/htdocs/ICT3103Busbly/HelperClass/EmailHelper.php");


sec_session_start();

// initializing variables
$errors = array(); 

// connect to the database
$conn = $mysqli;


// LOGIN USER
if (isset($_POST['forget_password'])) {
    
  //Create class objects
  $emailHelperObj = new EmailHelper();
  
  $email = mysqli_real_escape_string($conn, $_POST['email']); 
  
  //Form Input Validation
  if (empty($email)) {
  	array_push($errors, "Email is required");
  }

  //validating with database
  if(!checkEmailExist($email, $mysqli)) {
      array_push($errors, "Invalid Email");
  }
  else{      
    // Finally, login user if there are no errors in the form and database
    if (count($errors) == 0) {
        
        //Generate OTP for Email
        $emailOTP = $emailHelperObj->generate_email_otp(); 
        //Send Email
        $emailHelperObj->generate_email($email, $emailOTP);
        
        //Redirect to Home Page
        header("Location: index.php");
    }
  } 
}