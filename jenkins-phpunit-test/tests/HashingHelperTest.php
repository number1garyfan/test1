<?php declare(strict_types=1);
require_once("HelperClass/HashingHelper.php");

   

final class HashingHelperTest extends PHPUnit_Framework_TestCase
{
    //Purpose: Test for input value bigger than SHA256
    //Expected Result: if input string more than 64 characters, which is the maximum for SHA256, an empty string will returned
    public function test_hash_email_invalidSHA(): void
    {
        //Setup 
        $hashHelperObj = new HashingHelper();
        $email = "resfihnaauljxhpgnurwhhprgtoeldpqozhsqyhnazbbqpfhlwiltloyxe@gmail.com";
    
        //Actions
        $result = $hashHelperObj->hash_email($email); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    //Purpose: Test for input value bigger than SHA256
    //Expected Result: if input string more than 64 characters, which is the maximum for SHA256, an empty string will returned
    public function test_hash_username_invalidSHA(): void
    {
        //Setup 
        $hashHelperObj = new HashingHelper();
        $username = "resfihnaauljxhpgnurwhhprgtoeldpqozhsqyhnazbbqpfhlwiltloyxedsdfsdf";
    
        //Actions
        $result = $hashHelperObj->hash_username($username); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
}
