<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Report Post
if(isset($_POST['AccountID']) && isset($_POST['Report'])){
    $accountid = filter_input(INPUT_POST, 'AccountID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(report_post($accountid,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Post reported successfully","","success");';
    echo '}, 100);</script>';


}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("Post failed to report","","error");';
    echo '}, 100);</script>';

    }
   
}