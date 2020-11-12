<?php declare(strict_types=1);
use PHPUnit\Framework\TestCase;
require_once("HelperClass/PasswordHelper.php");

   

final class PasswordHelperTest extends TestCase
{
    //Purpose: Test for password length (9) less than requirements (10)
    //Expected Result: false 
    public function test_passwordStrengthLessThan9_invalidStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "123456Aa@";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Purpose: Test for password length (129) less than requirements (128)
    //Expected Result: false 
    public function test_passwordStrengthMoreThan128_invalidStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "12345612345678911234567891123456789112345678911234567891111111Aa@1234561234567891123456789112345678911234567891123456789111111166";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Expected Result: false 
    public function test_passwordContainNoLowerCaseAlphabet_invalidStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "12345678@A";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Expected Result: false 
    public function test_passwordContainNoUpperCaseAlphabet_invalidStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "12345678@a";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Expected Result: false 
    public function test_passwordContainNoNumber_invalidStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "aaaaaaaA@a";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Expected Result: false 
    public function test_passwordContainNoSpecialCharacter_invalidStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "aaaaaaaA1a";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Expected Result: true 
    public function test_password_validStrength(): void
    {
        //Setup 
        $pwHelperObj = new PasswordHelper();
        $password = "1234567Aa@";
    
        //Actions
        $result = $pwHelperObj->check_password_strength($password); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
}