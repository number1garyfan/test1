<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('/var/www/html/Connections/dbconnect.php');


if (!empty($_POST['TopicName'])) {
    $TopicName = filter_input(INPUT_POST, 'TopicName',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
         
    if(insert_topic($TopicName,$accountID,$mysqli)){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Topic created successfully","","success");';
        echo '}, 100);</script>';
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Topic failed to create","","error");';
        echo '}, 100);</script>';
        }
    //$stmt->close();
    }

