<?php declare(strict_types=1);
use PHPUnit\Framework\TestCase;
require_once("HelperClass/EmailUsernameInputHelper.php");   

final class InputValidationTest extends TestCase
{
    //Purpose: Test if html entities php function 
	//(Input field validation helps to convert special characters to HTML entities. 
	//This can prevent any form of XSS.) 
    //Expected Result: 
    public function test_valid_htmlentities(): void
    {
        //Setup 
        $scriptStr = "<script>alert(1)<script>";
    
        //Actions
        $result = htmlentities($scriptStr); 
         
        //Assertions
        $this->assertEquals("&lt;script&gt;alert(1)&lt;script&gt;",$result);
    }
    
    //Purpose: Test if email input is more 255 characters (database only can take in max 255 characters)
    //Expected Result: false
    public function test_invalid_emailInputLength(): void
    {
        //Setup 
        $valHelperObj = new EmailUsernameInputHelper();
        $emailInput = "UJK7zawcc4UocnDri68qtKVgUemEyIiqx3vKx6LDAXUYPPhIMqKup3gQqVsOuB3EbbMoLHWs5qvKZ3VW8ucNi3d3HyRLfQLutX4CruYm6Q5woD8uugAMocIBXH1DirRo0AIqrjuwlrc1OTSCFrZHCGW9KKIET9Rx0O2Zyf5cn7fqFWUNDoVGyj6Ql30j8MWh24RheOXDgYtJQm16KCw7xPCOjg7s7Givrvg7yRKw4DzHaS9rsYU5ZRA2QBPYDY4b";
    
        //Actions
        $result = $valHelperObj->validate_email_input_less_than_255($emailInput); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Purpose: Test if username input is more 255 characters (database only can take in max 255 characters)
    //Expected Result: false
    public function test_invalid_usernameInputLength(): void
    {
        //Setup 
        $valHelperObj = new EmailUsernameInputHelper();
        $usernameInput = "UJK7zawcc4UocnDri68qtKVgUemEyIiqx3vKx6LDAXUYPPhIMqKup3gQqVsOuB3EbbMoLHWs5qvKZ3VW8ucNi3d3HyRLfQLutX4CruYm6Q5woD8uugAMocIBXH1DirRo0AIqrjuwlrc1OTSCFrZHCGW9KKIET9Rx0O2Zyf5cn7fqFWUNDoVGyj6Ql30j8MWh24RheOXDgYtJQm16KCw7xPCOjg7s7Givrvg7yRKw4DzHaS9rsYU5ZRA2QBPYDY4b";
    
        //Actions
        $result = $valHelperObj->validate_username_input_less_than_255($usernameInput); 
         
        //Assertions
        $this->assertEquals(false,$result);
    }
    
    //Purpose: Test if email input is 255 characters (database only can take in max 255 characters)
    //Expected Result: true
    public function test_valid_emailInputLength(): void
    {
        //Setup 
        $valHelperObj = new EmailUsernameInputHelper();
        $emailInput = "UJK7zawcc4UocnDri68qtKVgemEyIiqx3vKx6LDAXUYPPhIMqKup3gQqVsOuB3EbbMoLHWs5qvKZ3VW8ucNi3d3HyRLfQLutX4CruYm6Q5woD8uugAMocIBXH1DirRo0AIqrjuwlrc1OTSCFrZHCGW9KKIET9Rx0O2Zyf5cn7fqFWUNDoVGyj6Ql30j8MWh24RheOXDgYtJQm16KCw7xPCOjg7s7Givrvg7yRKw4DzHaS9rsYU5ZRA2QBPYDY4b";
    
        //Actions
        $result = $valHelperObj->validate_email_input_less_than_255($emailInput); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    //Purpose: Test input is 255 characters (database only can take in max 255 characters)
    //Expected Result: true
    public function test_valid_usernameInputLength(): void
    {
        //Setup 
        $valHelperObj = new EmailUsernameInputHelper();
        $usernameInput = "UJK7zawcc4UocnDri68tKVgUemEyIiqx3vKx6LDAXUYPPhIMqKup3gQqVsOuB3EbbMoLHWs5qvKZ3VW8ucNi3d3HyRLfQLutX4CruYm6Q5woD8uugAMocIBXH1DirRo0AIqrjuwlrc1OTSCFrZHCGW9KKIET9Rx0O2Zyf5cn7fqFWUNDoVGyj6Ql30j8MWh24RheOXDgYtJQm16KCw7xPCOjg7s7Givrvg7yRKw4DzHaS9rsYU5ZRA2QBPYDY4b";
    
        //Actions
        $result = $valHelperObj->validate_username_input_less_than_255($usernameInput); 
         
        //Assertions
        $this->assertEquals(true,$result);
    }
    
    //Purpose: Test if FILTER_VALIDATE_EMAIL function filful "The email address contains two parts, separated with an @ symbol." guideline
    //Expected Result: false
    public function test_FILTER_VALIDATE_EMAIL_containsTwoParts(): void
    {
        //Setup 
        $email = "pheeboonleo96gmail.com";
        //Actions
        $result = filter_var($email, FILTER_VALIDATE_EMAIL); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    //Purpose: Test if FILTER_VALIDATE_EMAIL function filful "The email address does not contain dangerous characters" guideline
    //Expected Result: false
    public function test_FILTER_VALIDATE_EMAIL_dangerousChar(): void
    {
        //Setup 
        $email = "\"pheeboonleo96@gmail.com";
        //Actions
        $result = filter_var($email, FILTER_VALIDATE_EMAIL); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    //Purpose: Test if FILTER_VALIDATE_EMAIL function filful "The domain part contains only letters, numbers, hyphens (-) and periods (.)." guideline
    //Expected Result: false
    public function test_FILTER_VALIDATE_EMAIL_domainChars(): void
    {
        //Setup 
        $email = "pheeboonleo96@g'mail.com";
        //Actions
        $result = filter_var($email, FILTER_VALIDATE_EMAIL); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    //Purpose: Test if FILTER_VALIDATE_EMAIL function filful "The local part (before the @) should be no more than 65 characters." guideline
    //Expected Result: empty string
    public function test_FILTER_VALIDATE_EMAIL_65charsBeforeAt(): void
    {
        //Setup 
        $email = "sKzaj3nD6Mu9UOv3xZEDIiNOTUOL8ANWPF6c2UZfpEreHzF6htCYNDk903i5yFack@gmail.com"; //66chars
        //Actions
        $result = filter_var($email, FILTER_VALIDATE_EMAIL); 
         
        //Assertions
        $this->assertEquals("",$result);
    }
    
    //Purpose: Test if FILTER_VALIDATE_EMAIL function take in normal email address format
    //Expected Result: false
    public function test_FILTER_VALIDATE_EMAIL_validEmailAddress(): void
    {
        //Setup 
        $email = "pheeboonleo96@gmail.com";
        //Actions
        $result = filter_var($email, FILTER_VALIDATE_EMAIL); 
         
        //Assertions
        $this->assertEquals("pheeboonleo96@gmail.com",$result);
    }
}
