<?php declare(strict_types=1);
require_once('C:/xampp/htdocs/ICT3103Busbly/Connections/dbconnect.php');
require_once("C:/xampp/htdocs/ICT3103Busbly/Server/ServerFunction.php");
require_once ("PHPUnit/Autoload.php");
   

final class SQLInjectionTest extends PHPUnit_Framework_TestCase
{
    public function test_SQLInjection_checkUserExist(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $data = "pheeboon=";
        
        //Clean up data
        $username = mysqli_real_escape_string($mysqli, $data);
                
        //Actions
        $result = checkUserExist($username, $mysqli); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    public function test_SQLInjection_checkEmailExist(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $data = "pheeboon=";
        
        //Clean up data
        $username = mysqli_real_escape_string($mysqli, $data);
                
        //Actions
        $result = checkEmailExist($username, $mysqli); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    public function test_SQLInjection_checkValidOTP(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $otp = "12345678=";
        
        //Clean up data
        $otp= mysqli_real_escape_string($mysqli, $otp);
                
        //Actions
        $result = checkValidOTP($otp, $mysqli); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    public function test_SQLInjection_checkOTPExpired(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $otp = "12345678=";
        
        //Clean up data
        $otp= mysqli_real_escape_string($mysqli, $otp);
                
        //Actions
        $result = checkOTPExpired($otp, $mysqli); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    public function test_SQLInjection_checkUsedOTP(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $otp = "12345678=";
        
        //Clean up data
        $otp= mysqli_real_escape_string($mysqli, $otp);
                
        //Actions
        $result = checkUsedOTP($otp, $mysqli); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    public function test_SQLInjection_get_salt(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $email = "pheeboonleo96@gmail.com=";
        
        //Clean up data
        $email= mysqli_real_escape_string($mysqli, $email);
                
        //Actions
        $result = get_salt($email, $mysqli); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    public function test_SQLInjection_check_login(): void
    {
        //Setup Unfiltered Data prone for SQL Injection
        $email = "pheeboonleo96@gmail.com=";
        $password = "1234567=";
        
        //Clean up data
        $email= mysqli_real_escape_string($mysqli, $email);
        $password= mysqli_real_escape_string($mysqli, $password);
                
        //Actions
        $result = check_login($email, $password, $mysqli); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
  
}