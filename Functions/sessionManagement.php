<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

sec_session_start();

if(!isset($_SESSION['Username'])){
    header('Location: login.php');
}else{
   $accountID = $_SESSION['AccountId']; 
}
