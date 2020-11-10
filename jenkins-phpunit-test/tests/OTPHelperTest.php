<?php declare(strict_types=1);
use PHPUnit\Framework\TestCase;
require_once("HelperClass/OTPHelper.php");

   

final class OTPHelperTest extends TestCase
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