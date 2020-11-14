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
public class PasswordRecoveryAuthenticationTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "http://localhost/ICT3103Busbly/forgetPassword.php";
    String validEmail = "pheeboonleo96@gmail.com";
    //String validPassword = "1234567Aa@";
    String invalidEmail = "none@example.com";
    //String invalidPassword = "1234567Aa@@";

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
    //Expected result: return true if email exist in database
    //Based on our requirement: if email in database == can retrieve password
    public void test_positive_passwordRecoveryAuthTest() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(validEmail);
		//click submit
		driver.findElement(By.name("forget_password")).click();
	
		//check result 
		String expectedResult = "Busbly Enter OTP"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
    
    @Test
    //Expected result: return false if email does exist in database
    //Based on our requirement: if email not in database == cannot retrieve password
    public void test_negative_passwordRecoveryAuthTest() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(invalidEmail);
		//click submit
		driver.findElement(By.name("forget_password")).click();
	
		//check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}

}
