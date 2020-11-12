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
    
    //Purpose: Test if OTP input is out of range (Upper Range)
    public function test_otp_upperOutOfRange(): void
    {
        //Setup 
        $OTPHelperObj = new OTPHelper();
    
        //Actions
        $result = $OTPHelperObj->invalid_otp_range(123456789); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    //Purpose: Test if OTP input is out of range (Lower Range)
    public function test_otp_lowerOutOfRange(): void
    {
        //Setup 
        $OTPHelperObj = new OTPHelper();
    
        //Actions
        $result = $OTPHelperObj->invalid_otp_range(1); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    //Purpose: Test if OTP input is integer datatype
    public function test_otp_validDatatype(): void
    {
        //Setup 
        $OTPHelperObj = new OTPHelper();
        $otp = 1234567891; 
    
        //Actions
        $result = $OTPHelperObj->valid_otp_datatype($otp); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    //Purpose: Test if OTP input is integer datatype
    public function test_otp_invalidDatatype(): void
    {
        //Setup 
        $OTPHelperObj = new OTPHelper();
        $otp = "1234567891"; //string 
    
        //Actions
        $result = $OTPHelperObj->valid_otp_datatype($otp); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
}