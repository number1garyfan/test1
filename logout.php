<?php
include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
csrfProtector::init();

require_once('/var/www/html/Connections/dbconnect.php');
        include "/var/www/html/Server/ServerFunction.php";
	
        $accountID = $_SESSION['AccountId']; 
        
        logout_user($accountID,$mysqli);
                
        session_destroy(); // Destroy session
        
	header("Location: https://teamname.sitict.net/login.php");
?>