<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$errors = array();

    if(isset($_POST["g-recaptcha-response"])){
	$captcha = $_POST["g-recaptcha-response"];

	//$secretKey = "6Lft5OAZAAAAAPyuMvPvtfme46pulkZGzj4nMsNC";
        
        
        $ip = $_SERVER['REMOTE_ADDR'];
        // post request to server
        $url = 'https://www.google.com/recaptcha/api/siteverify?secret=' . urlencode($secretKey) .  '&response=' . urlencode($captcha);
        $response = file_get_contents($url);
        $responseKeys = json_decode($response,true);
        // should return JSON with success as true
        if($responseKeys["success"]) {
                //echo '<h2>Thanks for posting comment</h2>';
        } else {
            array_push($errors, "You are spammer ! Get the @$%K out");
        }
    }