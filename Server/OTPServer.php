<?php
require_once('C:/xampp/htdocs/ICT3103Busbly/Connections/dbconnect.php');
require_once("C:/xampp/htdocs/ICT3103Busbly/HelperClass/SaltHashingHelper.php");
require_once("C:/xampp/htdocs/ICT3103Busbly/HelperClass/PasswordHelper.php");
require_once("C:/xampp/htdocs/ICT3103Busbly/HelperClass/EmailHelper.php");
require_once("C:/xampp/htdocs/ICT3103Busbly/Server/ServerFunction.php");

sec_session_start();

// initializing variables
$username = "";
$email    = "";
$errors = array(); 

// connect to the database
$conn = $mysqli;

// REGISTER USER
if (isset($_POST['enter_otp'])) {
  //Create class objects
  $passwordHelperObj = new PasswordHelper();
  $saltedHashingHelperObj = new SaltHashingHelper();
  $emailHelperObj = new EmailHelper();

  // receive all input values from the form
  $inputted_otp = mysqli_real_escape_string($conn, $_POST['otp']);

  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($inputted_otp)) { array_push($errors, "OTP is required"); }
  
  //validating with database
  else if(!checkValidOTP($inputted_otp, $mysqli)) {
      array_push($errors, "Invalid OTP");
  }
  else if(checkOTPExpired($inputted_otp, $mysqli)){
      array_push($errors, "Expired OTP");
  }
  else if(checkUsedOTP($inputted_otp, $mysqli)){
      array_push($errors, "Invalid OTP");
  }
  else{      
    // Finally, register user if there are no errors in the form
    if (count($errors) == 0) {
        
        //Send email to next page using Session
        $email = $_SESSION["email_address_otp"];
        
        //Call Login Function
        login($email, $mysqli);

        //update OTP to used
        update_otp(intval($inputted_otp), $mysqli);
       
        if($_SESSION["forget_password"]==1){
            //Redirect to reset passwrod Page
            header("Location: resetPassword.php");
        }else{     
            //Redirect to OTP Page
            header("Location: enterOTP.php");
        }
  } 
 }
}

