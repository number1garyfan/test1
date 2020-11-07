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
if (isset($_POST['reg_user'])) {
  //Create class objects
  $passwordHelperObj = new PasswordHelper();
  $saltedHashingHelperObj = new SaltHashingHelper();
  $emailHelperObj = new EmailHelper();

  // receive all input values from the form
  $username = mysqli_real_escape_string($conn, htmlentities($_POST['username']));
  $email = mysqli_real_escape_string($conn, htmlentities($_POST['email']));
  $password_1 = mysqli_real_escape_string($conn, htmlentities($_POST['password_1']));
  $password_2 = mysqli_real_escape_string($conn, htmlentities($_POST['password_2']));

  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($username)) { array_push($errors, "Username is required"); }
  else if (empty($email)) { array_push($errors, "Email is required"); }
  else if (!filter_var($email, FILTER_VALIDATE_EMAIL)){array_push($errors, "Invalid Email");}
  else if (empty($password_1)) { array_push($errors, "Password is required"); }
  else if ($password_1 != $password_2) {array_push($errors, "The two passwords do not match");}
  else if (!$passwordHelperObj->check_password_strength($password_1))  {array_push($errors, "Password must consist of 8-16 characters, at least 1 lower and upper case alphabet, 1 number and 1 special character");}
  
  
  //validating with database
  if(checkUserExist($username, $mysqli)) {
      array_push($errors, "Username already exists");
  }
  else if(checkEmailExist($email, $mysqli)){
      array_push($errors, "Email already exists");
  }
  else{      
    // Finally, register user if there are no errors in the form
    if (count($errors) == 0) {
        //Assign Variables
        $activationID = substr(md5(mt_rand()), 0, 7);
        $salt = $saltedHashingHelperObj->generate_password_salt();
        $saltedHashedPw = $saltedHashingHelperObj->salted_hashing_password($salt, $password_1);
        $roleID = 2;
        
        //Register user into database
        insertUser($username, $saltedHashedPw, $salt, $email, $roleID, $activationID, $mysqli);
        
        //Send activation email
        $returnMail = $emailHelperObj->generate_activation_email($email, $activationID);
       
        //Store mail log
        if ($emailHelperObj->save_mail($returnMail)){

        }
    }
  } 
}

  
  
 


	
	
