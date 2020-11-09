<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

if(isset($_POST['AccountID']) && isset($_POST['promoteMod'])){
    $accountid = filter_input(INPUT_POST, 'AccountID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
     if(promote_user_mod($accountid,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User promoted to moderator successfully","","success");';
    echo '}, 100);</script>';
    //$msg = "Topic created successfully.";
    Header('Refresh:1; url=manageAccount.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User failed to promote","","error");';
    echo '}, 100);</script>';
    //$msg = "Topic failed to create";
    }
}

if(isset($_POST['AccountID']) && isset($_POST['promoteAdmin'])){
    $accountid = filter_input(INPUT_POST, 'AccountID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
     if(promote_user_admin($accountid,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User promoted to admin successfully","","success");';
    echo '}, 100);</script>';
    //$msg = "Topic created successfully.";
    Header('Refresh:1; url=manageAccount.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User failed to promote","","error");';
    echo '}, 100);</script>';
    //$msg = "Topic failed to create";
    }
}

if(isset($_POST['AccountID']) && isset($_POST['demoteUser'])){
    $accountid = filter_input(INPUT_POST, 'AccountID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
     if(demote_user_user($accountid,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User demoted successfully","","success");';
    echo '}, 100);</script>';
    //$msg = "Topic created successfully.";
    Header('Refresh:1; url=manageAccount.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User failed to demote","","error");';
    echo '}, 100);</script>';
    //$msg = "Topic failed to create";
    }
}