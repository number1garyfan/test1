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

if(!isset($_SESSION['AccountId']) && !isset($_SESSION['OTPVerified'])){
    header('Location: login.php');
}else{
   $accountID = $_SESSION['AccountId']; 
}
