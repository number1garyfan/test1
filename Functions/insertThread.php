<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


require_once('/var/www/html/Connections/dbconnect.php');

if (!empty($_POST['ThreadName']) && isset($_POST['TopicID'])) {
    $ThreadName = filter_input(INPUT_POST, 'ThreadName',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $topicid = filter_input(INPUT_POST, 'TopicID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(insert_thread($ThreadName,$accountID,$topicid,$mysqli)){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Thread created successfully","","success");';
        echo '}, 100);</script>';
        //$msg = "Topic created successfully.";   
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Thread failed to create","","error");';
        echo '}, 100);</script>';
        //$msg = "Topic failed to create";
        }
    //$stmt->close();
    }
    
if (isset($_POST['TopicID'])) {
    $topicid = filter_input(INPUT_POST, 'TopicID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
}
    

