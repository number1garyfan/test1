<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of PasswordHelper
 *
 * @author pheeb
 */
class PasswordHelper {
        
    function check_password_strength($password)
    {
      try{
            if( preg_match("/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{8,16}$/", $password) ) 
            { 
                return true; 
            } else {
                return false; 
            }
        } catch (Exception $ex) {

        }
    }
    
    
}
