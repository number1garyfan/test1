<?php
require_once('/var/www/html/Connections/dbconnect.php');
require_once("/var/www/html/Server/ServerFunction.php");
require_once("/var/www/html/HelperClass/EmailHelper.php");
require_once("/var/www/html/HelperClass/EmailUsernameInputHelper.php");

//sec_session_start();

// initializing variables
$errors = array(); 

// connect to the database
$conn = $mysqli;


// LOGIN USER
if (isset($_POST['forget_password'])) {
    
  //Create class objects
  $emailHelperObj = new EmailHelper();
  $emailUsernameHelperObj = new EmailUsernameInputHelper();
  
  $email = mysqli_real_escape_string($conn, htmlentities($_POST['email'])); 
  
  //Form Input Validation
  if (empty($email)) {
  	array_push($errors, "Email is required");
  }else if (!$emailUsernameHelperObj->validate_email_input_less_than_255($email)) { array_push($errors, "Invalid Email"); }

  //validating with database
  else if(!checkEmailExist($email, $mysqli)) {
      array_push($errors, "Invalid Email");
  }
  else{      
    // Finally, login user if there are no errors in the form and database
    if (count($errors) == 0) {
        
        //Generate OTP for Email
        $otp = $emailHelperObj->generate_email_otp(); 
        //Send OTP Email
        $emailHelperObj->generate_forget_password_email($email, $otp);
        
        //Start OTP Timer
        store_otp($otp, $email, $mysqli);
        
        //Send email to next page using Session
        $_SESSION["email_address_otp"] = $email;
        
        //Send forget password to next page using Session
        $_SESSION["forget_password"] = 1;
        
        $_SESSION["otp_page"] = true;
        
        //Redirect to OTP Page
        header("Location: https://teamname.sitict.net/enterOTP.php");
    }
  } 
}
else{
     $_SESSION["otp_page"] = false;
}
