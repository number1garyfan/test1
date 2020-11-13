<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

if(isset($_POST['AccountID']) && isset($_POST['banUser'])){
    $accountid = filter_input(INPUT_POST, 'AccountID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
    if(ban_user($accountid,$roles,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User banned successfully","","success");';
    echo '}, 100);</script>';

    Header('Refresh:1; url=https://teamname.sitict.net/manageAccount.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User failed to ban","","error");';
    echo '}, 100);</script>';
    
    }
}

if(isset($_POST['AccountID']) && isset($_POST['unbanUser'])){
    $accountid = filter_input(INPUT_POST, 'AccountID',FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    
     if(unban_user($accountid,$roles,$mysqli)){
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User unbanned successfully","","success");';
    echo '}, 100);</script>';

    Header('Refresh:1; url=https://teamname.sitict.net/manageAccount.php');

}else{
    echo '<script type="text/javascript">';
    echo 'setTimeout(function () { swal("User failed to unban","","error");';
    echo '}, 100);</script>';
    
    }
}
