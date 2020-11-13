<?php
require_once('Connections/dbconnect.php');
require_once("HelperClass/SaltHashingHelper.php");
require_once("HelperClass/PasswordHelper.php");
require_once("HelperClass/EmailHelper.php");
require_once("HelperClass/OTPHelper.php");
require_once("Server/ServerFunction.php");

//sec_session_start();

// initializing variables
$username = "";
$email    = "";
$errors = array(); 

    if(isset($_POST["g-recaptcha-response"])){
	$captcha = $_POST["g-recaptcha-response"];

	$secretKey = "6Lft5OAZAAAAAPyuMvPvtfme46pulkZGzj4nMsNC";
        $ip = $_SERVER['REMOTE_ADDR'];
        // post request to server
        $url = 'https://www.google.com/recaptcha/api/siteverify?secret=' . urlencode($secretKey) .  '&response=' . urlencode($captcha);
        $response = file_get_contents($url);
        $responseKeys = json_decode($response,true);
        // should return JSON with success as true
        if($responseKeys["success"]) {
                //echo '<h2>Thanks for posting comment</h2>';
        } else {
            array_push($errors, "You are spammer ! Get the @$%K out");
        }
    }


// connect to the database
$conn = $mysqli;

// REGISTER USER
if (isset($_POST['enter_otp'])) {
  //Create class objects
  $passwordHelperObj = new PasswordHelper();
  $saltedHashingHelperObj = new SaltHashingHelper();
  $emailHelperObj = new EmailHelper();
  $OTPHelperObj = new OTPHelper();

  // receive all input values from the form
  $inputted_otp = mysqli_real_escape_string($conn, htmlentities($_POST['otp']));

  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($inputted_otp)) { array_push($errors, "OTP is required"); }
  //validate input is integer datatype
  else if(!$OTPHelperObj->valid_otp_datatype($inputted_otp)){array_push($errors, "Invalid OTP");}
  //validate range of input
  else if($OTPHelperObj->invalid_otp_range($inputted_otp)){array_push($errors, "Invalid OTP");}
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
            
        if($_SESSION["forget_password"]==1){
            $_SESSION["forget_password"] = 0;
            $_SESSION["reset_password_page"] = true;
            //Redirect to reset passwrod Page
            header("Location: resetPassword.php");
        }else{     
            //Call Login Function
            login($email, $mysqli);
            $_SESSION["OTPVerified"] = "verified";
            // Login time is stored in a session variable 
            $_SESSION["login_time_stamp"] = time(); 
            //session
            $_SESSION["login_page"] = true;
            //Populate Session Variables 
            populate_session_variables($email, $mysqli);
            //Redirect to index Page
            header("Location: index.php");
        }
        //update OTP to used
        update_otp(intval($inputted_otp), $mysqli);
  } 
 }
}
else{
    $_SESSION["reset_password_page"] = false;
}



