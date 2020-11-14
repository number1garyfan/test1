<?php
// validating google recaptcha

// initializing variables
$errors = array();

require_once('/var/www/html/Connections/dbconnect.php');
require_once("/var/www/html/HelperClass/SaltHashingHelper.php");
require_once("/var/www/html/HelperClass/PasswordHelper.php");
require_once("/var/www/html/HelperClass/EmailHelper.php");
require_once("/var/www/html/Server/ServerFunction.php");

// connect to the database
$conn = $mysqli;


// LOGIN USER
if (isset($_POST['login_user'])) {
    
    //Create class objects
    $saltedHashingHelperObj = new SaltHashingHelper();
    $emailHelperObj = new EmailHelper();

    $email = mysqli_real_escape_string($conn, htmlentities($_POST['email']));
    $password = mysqli_real_escape_string($conn, htmlentities($_POST['password_1']));

    //Process password with salt and hash (fetch salt from DB)
    $salting = get_salt($email, $mysqli);
    $encryptedPassword = $saltedHashingHelperObj->validate_salt_password($salting, $password);

    //Form Input Validation
    if (empty($email)) {
        array_push($errors, "Email is required");
    }
    if (empty($password)) {
        array_push($errors, "Password is required");
    }

    //validating with database
    if (!check_login($email, $encryptedPassword, $mysqli)) {
        array_push($errors, "Login Failed");
    } else {
        // Finally, login user if there are no errors in the form and database
        if (count($errors) == 0) {

            //Send OTP Email
            $otp = $emailHelperObj->generate_email_otp();
            $returnMail = $emailHelperObj->generate_otp_email($email, $otp);

            //Start OTP Timer
            store_otp($otp, $email, $mysqli);

            //Send email to next page using Session
            $_SESSION["forget_password"] = 0;
            $_SESSION["email_address_otp"] = $email;
            $_SESSION["otp_page"] = true;
            
            //Enter OTP 
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
            header("Location: https://teamname.sitict.net/index.php");
         
            //Redirect to next page
            //header("Location: https://teamname.sitict.net/enterOTP.php");
        }
    }
}
else{
    $_SESSION["otp_page"] = false;
}
  
  
 


	
	
