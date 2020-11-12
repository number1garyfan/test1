<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once('Connections/dbconnect.php');

if ($_POST['PostComment'] != "" && isset($_POST['PostID'])) {
    $PostComment = filter_input(INPUT_POST, 'PostComment',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    $postid = filter_input(INPUT_POST, 'PostID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(update_post($PostComment,$postid,$accountID,$roles,$mysqli)){
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Post updated successfully","","success");';
        echo '}, 100);</script>';
 
        
    }else{
        echo '<script type="text/javascript">';
        echo 'setTimeout(function () { swal("Post failed to update","","error");';
        echo '}, 100);</script>';

        }

    }
    
    if(isset($_POST['PostID'])){
    $postid = filter_input(INPUT_POST, 'PostID', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    $stmt = $mysqli->prepare("SELECT CommentPost FROM Post WHERE idPost = ? ;");
    $stmt->bind_param("i", $postid);
    $stmt->execute();
    $result = $stmt->get_result();
    
    if ($result->num_rows > 0) {
        // output data of each row
        while ($row = $result->fetch_assoc()) { 
        $CommentPost = $row['CommentPost'] ;}
    }
    $stmt->close();
}
