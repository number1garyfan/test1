<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of EmailHelper
 *
 * @author pheeb
 */
class EmailHelper {
    
    function generate_email_otp()
    {
      try{
          $otp = mt_rand(10000000,99999999);
          return $otp; 
        } catch (Exception $ex) {

        }
    }
    
    function generate_email($email, $otp)
    {
      try{
            $to = $email;
            $subject = "Account Verification for Busbly";
            $txt = "Hello world!";

            mail($to,$subject,$txt);
         
        } catch (Exception $ex) {

        }
    }
    
}
