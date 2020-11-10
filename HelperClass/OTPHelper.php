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
class OTPHelper {
    
    function generate_email_otp()
    {
      try{
          $otp = mt_rand(10000000,99999999);
          return $otp; 
        } catch (Exception $ex) {

        }
    }
      
}
