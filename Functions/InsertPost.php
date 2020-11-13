<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('/var/www/html/Connections/dbconnect.php');

if (!empty($_POST['PostComment']) && isset($_POST['ThreadID'])) {   
    $Postcomment = filter_input(INPUT_POST, 'PostComment',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(insert_post($Postcomment,$accountID,$threadid,$mysqli)){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Post created successfully","","success");';
        echo '}, 100);</script>';
        //$msg = "Topic created successfully.";   
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Post failed to create","","error");';
        echo '}, 100);</script>';
        //$msg = "Topic failed to create";
        }
    //$stmt->close();
    }
    
if (isset($_POST['ThreadID'])) {
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
}
    

