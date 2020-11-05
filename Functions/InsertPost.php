<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('Connections/dbconnect.php');

if ($_POST['PostComment'] != "" && isset($_POST['ThreadID'])) {   
    $Postcomment = filter_input(INPUT_POST, 'PostComment',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("insert into Post(CommentPost, CreationDate,Created_By_AccountId,Thread_idThread) Values (?,NOW(),?,?);");
    $stmt->bind_param("sii", $Postcomment,$accountID,$threadid);
    
    if($stmt->execute()){
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
    $stmt->close();
    }
    
if (isset($_POST['ThreadID'])) {
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
}
    

