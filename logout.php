<?php
//include_once __DIR__ .'/CSRF-Protector-PHP/libs/csrf/csrfprotector.php';
//csrfProtector::init();


session_start();

require_once('/var/www/html/testen/Connections/dbconnect.php');
        include "/var/www/html/testen/Server/ServerFunction.php";
	
        $accountID = $_SESSION['AccountId']; 
        
        logout_user($accountID,$mysqli);
                
        session_destroy(); // Destroy session
        
	header("Location: https://teamname.sitict.net/testen/login.php");
?>
