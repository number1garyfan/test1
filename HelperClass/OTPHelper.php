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
    
    function invalid_otp_range($otp)
    {
      try{
          $checklength = strlen((string)$otp);
          if($checklength!=8){
              return true;
          }
          else{
              return false;
          }
        } catch (Exception $ex) {

        }
    }
    
    function valid_otp_datatype($otp)
    {
      try{
        # Check if your variable is an integer
        if (strval($otp) !== strval(intval($otp))) {
            //not integer
            return false;
        }
        else{
            return true;
        }
     } catch (Exception $ex) {}
    }   
}
