<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of HashingHelper
 *
 * @author pheeb
 */
class HashingHelper {
    
    function hash_email($email)
    {
      try{
            //Hash with SHA256
            $hashEmail = hash('sha256', $email);
            return $hashEmail; 
          }
      catch (Exception $ex) {

        }
    }
    
    function hash_username($username)
    {
        try{
           //Hash with SHA256
           $hashUserName = hash('sha256', $username);
           return $hashUserName;  
       } catch (Exception $ex) {

       }
    }
}
