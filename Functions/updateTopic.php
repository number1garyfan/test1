<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('Connections/dbconnect.php');


if ($_POST['TopicName'] != "" && isset($_POST['TopicID'])) {
    $TopicName = filter_input(INPUT_POST, 'TopicName',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $Topicid = filter_input(INPUT_POST, 'TopicID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(update_topic($TopicName,$Topicid,$accountID,$roles,$mysqli)){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Topic updated successfully","","success");';
        echo '}, 100);</script>';
        //$msg = "Topic created successfully.";   
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Topic failed to update","","error");';
        echo '}, 100);</script>';
        //$msg = "Topic failed to create";
        }

    }
    
    if(isset($_POST['TopicID'])){
    $topicid = filter_input(INPUT_POST, 'TopicID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("SELECT TopicTitle FROM Topic WHERE idTopic = ? ;");
    $stmt->bind_param("i", $topicid);
    $stmt->execute();
    $result = $stmt->get_result();
    
    if ($result->num_rows > 0) {
        // output data of each row
        while ($row = $result->fetch_assoc()) { 
        $TopicTitle = $row['TopicTitle'] ;}
    }
    $stmt->close();
}


