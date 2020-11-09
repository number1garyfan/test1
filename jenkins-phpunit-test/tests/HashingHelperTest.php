<?php declare(strict_types=1);
use PHPUnit\Framework\TestCase;
require_once("HelperClass/HashingHelper.php");

   

final class HashingHelperTest extends TestCase
{
    //Purpose: Test for input value bigger than SHA256
    //Expected Result: if input string more than 64 characters, SHA256 PHP Function can still take in and return a 64 char string
    public function test_hash_email_invalidSHA(): void
    {
        //Setup 
        $hashHelperObj = new HashingHelper();
        $email = "bba540cb98f195c586c9336ba701a00ef88acdb53c2f55bb388a7047f4606c4cd@gmail.com";
    
        //Actions
        $result = $hashHelperObj->hash_email($email); 
         
        //Assertions
        $this->assertEquals("9978a64b5df82d30520085684b6b95babeeb7fa45c15df56145136c6be1bdbfb",$result);
    }
    
    //Purpose: Test for input value bigger than SHA256
    //Expected Result: if input string more than 64 characters, SHA256 PHP Function can still take in and return a 64 char string
    public function test_hash_username_invalidSHA(): void
    {
        //Setup 
        $hashHelperObj = new HashingHelper();
        $username = "bba540cb98f195c586c9336ba701a00ef88acdb53c2f55bb388a7047f4606c4cds";
    
        //Actions
        $result = $hashHelperObj->hash_username($username); 
         
        //Assertions
        $this->assertEquals("982b6fd29c2d3f376d90f6fcf5c6d7451479f02d55bd5827217154ab9080d999",$result);
    }
}