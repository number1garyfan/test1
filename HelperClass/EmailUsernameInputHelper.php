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
class EmailUsernameInputHelper {
    
    function validate_email_input_less_than_255($email)
    {
      try{
          if(strlen($email)>255){
              return false;
          }
          else{
              return true;
          }
        } catch (Exception $ex) {

        }
    }
    
    function validate_username_input_less_than_255($username)
    {
      try{
          if(strlen($username)>255){
              return false;
          }
          else{
              return true;
          }
        } catch (Exception $ex) {

        }
    }
}
