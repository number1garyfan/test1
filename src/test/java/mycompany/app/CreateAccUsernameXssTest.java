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
public class CreateAccUsernameXssTest {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/createAccount.php";
    
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
    String password = "Password123!";
    String password2 = "Password123!";
    
    
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
    public void test__create_user_xss_script1() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss1);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script2() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss2);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script3() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss3);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script4() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss4);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script5() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss5);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script6() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss6);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script7() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss7);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
  
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script8() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss8);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script9() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss9);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script10() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss10);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script11() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss11);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script12() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss12);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script13() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss13);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script14() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss14);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script15() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss15);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script16() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss16);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script17() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss17);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script18() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss18);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script19() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss19);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script20() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss20);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test__create_user_xss_script21() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible xss statement and inject 
		//other field regardless correct/wrong does not matter as we are testing XSS attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(xss21);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = ""; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    
    
    
    
    
}
