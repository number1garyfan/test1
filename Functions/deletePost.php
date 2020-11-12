<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

if(isset($_POST['PostID']) && isset($_POST['Delete'])){
    $postid = filter_input(INPUT_POST, 'PostID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(delete_post($accountID,$postid,$roles,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Post deleted successfully","","success");';
    echo '}, 100);</script>';
    //$msg = "Topic created successfully.";
    Header('Refresh:1; url=index.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Post failed to delete","","error");';
    echo '}, 100);</script>';
    //$msg = "Topic failed to create";
    }
   
}