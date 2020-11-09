<?php
	require_once('Connections/dbconnect.php');
        include "Server/ServerFunction.php";
	
	sec_session_start();
	
//	$_SESSION = array(); // Unset all the session values
//	$params = session_get_cookie_params(); // Get session parameters
//	
//	setcookie(session_name(), "", time() - 42000, $params["path"], $params["domain"], $params["secure"], $params["httponly"]); // Delete the actual cookie
	
        $accountID = $_SESSION['AccountId']; 
        
        logout_user($accountID,$mysqli);
                
        session_destroy(); // Destroy session
	
        
        
        
	header("Location: login.php");
?>