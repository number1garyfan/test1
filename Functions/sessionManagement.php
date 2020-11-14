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

if($_SESSION["login_page"]!=true ){
    header('Location: login.php');
}else{
    if(time()-$_SESSION["login_time_stamp"] >900)   
    { 
        header("Location:https://teamname.sitict.net/testen/logout.php"); 
    } 
    else{
        $accountID = $_SESSION['AccountId']; 
        $roles = $_SESSION['Roles'];
    }
  
}
