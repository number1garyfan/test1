<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

if(isset($_POST['ThreadID'])){
    $threadid = filter_input(INPUT_POST, 'ThreadID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("UPDATE Thread SET Deleted = true,DeletionDate = Now(),Deleted_By_AccountId = ? Where idThread = ? ;");
    $stmt->bind_param("ii", $accountID,$threadid);
    if($stmt->execute()){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Thread deleted successfully","","success");';
    echo '}, 100);</script>';
    //$msg = "Topic created successfully.";
    Header('Refresh:1; url=index.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Thread failed to delete","","error");';
    echo '}, 100);</script>';
    //$msg = "Topic failed to create";
    }
   
}