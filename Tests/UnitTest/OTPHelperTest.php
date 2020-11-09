<?php declare(strict_types=1);

require_once("HelperClass/OTPHelper.php");
require_once ("PHPUnit/Autoload.php");
   

final class OTPHelperTest extends PHPUnit_Framework_TestCase
{
    //Purpose: Test if OTP Generated has 8 digits
    public function test_generate_email_otp_8digit(): void
    {
        //Setup 
        $emailHelperObj = new OTPHelper();
    
        //Actions
        $result = $emailHelperObj->generate_email_otp(); 
         
        //Assertions
        $this->assertEquals(8,strlen((string)$result));
    }
}