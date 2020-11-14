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
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author pheeb
 */
public class OTPTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "http://localhost:8012/Team-01/login.php";
    String url2 = "http://localhost:8012/Team-01/enterOTP.php";
    String email = "1801233@sit.singaporetech.edu.sg";
    String password = "Password123!";
    String invalidOTP = "12345678";

@Before
    public void setUp() { 
		driver = new HtmlUnitDriver(); 
		wait = new WebDriverWait(driver, 10); 
	} 

@After
    public void tearDown() { 
		driver.quit(); 
	}	 
   
    @Test
    //Expected result: if invalid OTP, stay on same page
    public void test_invalid_OTP() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
                
                //enter input
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("password_1")).sendKeys(password);
             
                
		wait.until(ExpectedConditions.titleContains("Busbly Enter OTP")); 

		//enter input
		driver.findElement(By.name("otp")).sendKeys(invalidOTP);
		//click submit
		driver.findElement(By.name("enter_otp")).submit();
                
                //check result 
		String expectedResult = "Busbly Enter OTP"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
   
}
