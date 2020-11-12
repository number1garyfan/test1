<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//include_once ('CSRF-Protector-PHP/libs/csrf/csrfprotector.php');
//
////Initialise CSRFGuard library
//csrfProtector::init();

//sec_session_start();

if(!isset($_SESSION['AccountId']) || ($_SESSION['OTPVerified']==null)){
    header('Location: login.php');
}else{
    if(time()-$_SESSION["login_time_stamp"] >60)   
    { 
        header("Location:logout.php"); 
    } 
    else{
         $accountID = $_SESSION['AccountId']; 
    }
  
}
