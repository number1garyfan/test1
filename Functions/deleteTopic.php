<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

if(isset($_POST['TopicID'])){
    $topicid = filter_input(INPUT_POST, 'TopicID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("UPDATE Topic SET Deleted = true,DeletionDate = Now(),Deleted_By_AccountId = ? Where idTopic = ? ;");
    $stmt->bind_param("ii", $accountID,$topicid);
    if($stmt->execute()){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Topic deleted successfully","","success");';
    echo '}, 100);</script>';
    //$msg = "Topic created successfully.";
    Header('Refresh:1; url=index.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Topic failed to delete","","error");';
    echo '}, 100);</script>';
    //$msg = "Topic failed to create";
    }
   
}