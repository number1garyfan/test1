<?php  
declare(strict_types=1);
use PHPUnit\Framework\TestCase;


require_once("HelperClass/EmailHelper.php");
require_once ("PHPUnit/Autoload.php");
   

final class EmailHelperTest extends PHPUnit_Framework_TestCase
{
    //Purpose: Test if OTP Generated has 8 digits
    public function test_generate_email_otp_8digit(): void
    {
        //Setup 
        $emailHelperObj = new EmailHelper();
    
        //Actions
        $result = $emailHelperObj->generate_email_otp(); 
         
        //Assertions
        $this->assertEquals(8,strlen((string)$result));
    }
}
