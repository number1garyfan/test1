<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of SaltHashingHelper
 *
 * @author pheeb
 */
class SaltHashingHelper {
    
    function validate_salt_password($salting, $password)
    {
      try{
          //Concatenate salt with password
          $concatenateString = $salting.$password;
          //Hash with SHA256
          $securePassword = hash('sha256', $concatenateString);
          return $securePassword; 
        } catch (Exception $ex) {

        }
    }
        
    function salted_hashing_password($salt, $password)
    {
      try{
          //Concatenate salt with password
          $concatenateString = $salt.$password;
          //Hash with SHA256
          $securePassword = hash('sha256', $concatenateString);
          return $securePassword; 
        } catch (Exception $ex) {

        }
    }
    
    
    function generate_password_salt()
    {
        try{
            $characters = "`~!@#$%^&*()-=_+')0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            $charactersLength = strlen($characters);
            $randomString = '';
            for ($i = 0; $i < $length = 8; $i++) {
                $randomString .= $characters[rand(0, $charactersLength - 1)];
            }
            return $randomString;
            
        } catch (Exception $ex) {

        }
    }
}
