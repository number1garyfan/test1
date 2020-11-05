<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('Connections/dbconnect.php');


if ($_POST['TopicName'] != "") {
    $TopicName = filter_input(INPUT_POST, 'TopicName',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("insert into Topic (TopicTitle,CreationDate,Created_By_AccountId) Values (?,NOW(),?);");
    $stmt->bind_param("si", $TopicName,$accountID);
    
    if($stmt->execute()){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Topic created successfully","","success");';
        echo '}, 100);</script>';
        //$msg = "Topic created successfully.";   
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Topic failed to create","","error");';
        echo '}, 100);</script>';
        //$msg = "Topic failed to create";
        }
    $stmt->close();
    }

