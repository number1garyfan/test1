<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('Connections/dbconnect.php');

if ($_POST['ThreadName'] != "" && isset($_POST['ThreadID'])) {
    $ThreadName = filter_input(INPUT_POST, 'ThreadName',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(update_thread($ThreadName,$threadid,$accountID,$roles,$mysqli)){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Thread updated successfully","","success");';
        echo '}, 100);</script>';
        //$msg = "Topic created successfully.";   
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Thread failed to update","","error");';
        echo '}, 100);</script>';
        //$msg = "Topic failed to create";
        }

    }
    
    if(isset($_POST['ThreadID'])){
    $threadid = filter_input(INPUT_POST, 'ThreadID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("SELECT ThreadTitle FROM Thread WHERE idThread = ? ;");
    $stmt->bind_param("i", $threadid);
    $stmt->execute();
    $result = $stmt->get_result();
    
    if ($result->num_rows > 0) {
        // output data of each row
        while ($row = $result->fetch_assoc()) { 
        $ThreadTitle = $row['ThreadTitle'] ;}
    }
    $stmt->close();
}
