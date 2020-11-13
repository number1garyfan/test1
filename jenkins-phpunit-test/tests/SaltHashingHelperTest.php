<?php declare(strict_types=1);
use PHPUnit\Framework\TestCase;
require_once("HelperClass/SaltHashingHelper.php");

   

final class SaltHashingHelperTest extends TestCase
{
    //Expected Result: length 8 
    public function test_saltLength_validSaltLength(): void
    {
        //Setup 
        $hashHelperObj = new SaltHashingHelper();
    
        //Actions
        $result = $hashHelperObj->generate_password_salt(); 
         
        //Assertions
        $this->assertEquals(8,strlen((string)$result));
    }
    
    
    //Purpose: Test for input value bigger than SHA256
    //Expected Result: if input string more than 64 characters, SHA256 PHP Function can still take in and return a 64 char string
    public function test_saltedHashingPassword_invalidSHALength(): void
    {
        //Setup 
        $hashHelperObj = new SaltHashingHelper();
        $salt = "12345678";
        $password = "5ff8e24526dd0f9dc35db407a78b943851fcda334c95d6546bf68c8ce369c816";
    
        //Actions
        $result = $hashHelperObj->salted_hashing_password($salt, $password); 
         
        //Assertions
        $this->assertEquals("aa65a5ddba4b3dd7a5ae206a7753b5b150ec78f67a590b8bd5986b12adf6c088",$result);
    }
    
    
    //Expected Result: if salt input more than 64 characters, SHA256 PHP Function can still take in and return a 64 char string
    public function test_saltedHashingSalt_invalidSHALength(): void
    {
        //Setup 
        $hashHelperObj = new SaltHashingHelper();
        $salt = "5ff8e24526dd0f9dc35db407a78b943851fcda334c95d6546bf68c8ce369c816";
        $password = "1234567891";
    
        //Actions
        $result = $hashHelperObj->salted_hashing_password($salt, $password); 
         
        //Assertions
        $this->assertEquals("876ecd06fae435524fb1026b78dd0b7fb082c34d12efea1418d88c54af6d167e",$result);
    }
    
    //Expected Result: if password and salt input can be SHA256, result returned will not be empty. 
    //The empty() will return true if empty and false if otherwise
    public function test_saltedHashing_validSHALength(): void
    {
        //Setup 
        $hashHelperObj = new SaltHashingHelper();
        $salt = "resfihnaauljxhpgnurwhhprgtoeldpqozhsqyhnazbbqpfhlwiltloyxedsdfsd";
        $password = "1234567Aa@";
    
        //Actions
        $result = $hashHelperObj->salted_hashing_password($salt, $password); 
         
        //Assertions
        $this->assertEquals(false,empty($result));
    }
    
}