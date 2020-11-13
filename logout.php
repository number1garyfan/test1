<?php
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

require_once('Connections/dbconnect.php');
        include "Server/ServerFunction.php";
	
        $accountID = $_SESSION['AccountId']; 
        
        logout_user($accountID,$mysqli);
                
        session_destroy(); // Destroy session
        
	header("Location: login.php");
?>