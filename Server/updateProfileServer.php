<?php
require_once('Connections/dbconnect.php');
require_once("HelperClass/SaltHashingHelper.php");
require_once("HelperClass/PasswordHelper.php");
require_once("HelperClass/EmailHelper.php");
require_once("Server/ServerFunction.php");

//session_start();

// initializing variables
$username = "";
$email    = "";
$errors = array(); 

// connect to the database
$conn = $mysqli;

// REGISTER USER
if (isset($_POST['update_profile'])) {
   
    
  //Create class objects
  $passwordHelperObj = new PasswordHelper();
  $saltedHashingHelperObj = new SaltHashingHelper();
  $emailHelperObj = new EmailHelper();

  // receive all input values from the form
  $username = mysqli_real_escape_string($conn, htmlentities($_POST['username']));
  $email = mysqli_real_escape_string($conn, htmlentities($_POST['email']));
  $password_1 = mysqli_real_escape_string($conn, htmlentities($_POST['password_1']));
  $password_2 = mysqli_real_escape_string($conn, htmlentities($_POST['password_2']));
  $hidden = mysqli_real_escape_string($conn, htmlentities($_POST['hidden']));
  
  
  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($username)) { array_push($errors, "Username is required"); }
  else if (empty($email)) { array_push($errors, "Email is required"); }
  else if (!filter_var($email, FILTER_VALIDATE_EMAIL)){array_push($errors, "Invalid Email");}
  else if (empty($password_1)) { array_push($errors, "Password is required"); }
  else if ($password_1 != $password_2) {array_push($errors, "The two passwords do not match");}
  else if ($password_1 == $hidden || $password_2 == $hidden){$password_1 = $hidden; $password_2 = $hidden;}
  else if (!$passwordHelperObj->check_password_strength($password_1))  {array_push($errors, "Password must consist of 8-16 characters, at least 1 lower and upper case alphabet, 1 number and 1 special character");}
  
  
  //validating with database
  if($username != $_SESSION["Username"] && checkUserExist($username, $mysqli)) {
      array_push($errors, "Username already exists");
  }
  else if($email != $_SESSION["Email"] && checkEmailExist($email, $mysqli)){
      array_push($errors, "Email already exists");
  }
  else{      
    // Finally, register user if there are no errors in the form
  if ((count($errors) == 0) && ($password_1 != $hidden)) {
        //Assign Variables
        $salt = $saltedHashingHelperObj->generate_password_salt();
        $saltedHashedPw = $saltedHashingHelperObj->salted_hashing_password($salt, $password_1);
        
        //Update Account 
        updateProfile($email, $username, $saltedHashedPw, $salt, $mysqli);
        
        $_SESSION["Username"] = $username;
        $_SESSION["Email"]  = $email;
                
        echo '<script type="text/javascript">
        window.onload = function () { alert("Account Updated!"); }
        </script>';
        
        
        //Redirect to next page
        header("Location: viewProfile.php");
    }
    else if ((count($errors) == 0) && ($password_1 == $hidden)){
         //Update Account 
         updateProfileWithoutSalt($email, $username, $hidden, $mysqli);
         
        $_SESSION["Username"] = $username;
        $_SESSION["Email"]  = $email;
         
        echo '<script type="text/javascript">
        window.onload = function () { alert("Account Updated!"); }
        </script>';
         
         //Redirect to next page
        header("Location: viewProfile.php");
       
    }
  } 
}
else{
    //Retrieve account details
   $result = getAccountDetailsForUpdate($_SESSION["Email"], $mysqli);
}


  
  
 


	
	
