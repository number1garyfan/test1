<?php
// validating google recaptcha

// initializing variables
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

require_once('Connections/dbconnect.php');
require_once("HelperClass/SaltHashingHelper.php");
require_once("HelperClass/PasswordHelper.php");
require_once("HelperClass/EmailHelper.php");
require_once("Server/ServerFunction.php");


//sec_session_start();


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

            //Redirect to next page
            header("Location: enterOTP.php");
        }
    }
}

  
  
 


	
	
