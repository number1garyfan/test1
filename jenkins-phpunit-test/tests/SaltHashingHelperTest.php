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
    
    
    //Expected Result: if password input more than 64 characters, which is the maximum for SHA256, an empty string will returned
    public function test_saltedHashingPassword_invalidSHALength(): void
    {
        //Setup 
        $hashHelperObj = new SaltHashingHelper();
        $salt = "12345678";
        $password = "resfihnaauljxhpgnurwhhprgtoeldpqozhsqyhnazbbqpfhlwiltloyxedsdfsdf";
    
        //Actions
        $result = $hashHelperObj->salted_hashing_password($salt, $password); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    //Expected Result: if salt input more than 64 characters, which is the maximum for SHA256, an empty string will returned
    public function test_saltedHashingSalt_invalidSHALength(): void
    {
        //Setup 
        $hashHelperObj = new SaltHashingHelper();
        $salt = "resfihnaauljxhpgnurwhhprgtoeldpqozhsqyhnazbbqpfhlwiltloyxedsdfsdf";
        $password = "1234567891";
    
        //Actions
        $result = $hashHelperObj->salted_hashing_password($salt, $password); 
         
        //Assertions
        $this->assertEquals("",$result);
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