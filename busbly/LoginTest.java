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
public class LoginTest {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/login.php";
    String email = "pheeboonleo96@gmail.com";
    String wrong_password = "1234557Aa@";
    String unverifiedEmail = "pheeboon_leo@hotmail.com";
    String password_2 = "1234567Aa@";
    String noEmail = "pheeboonledddo96@gmail.com";
    String noPassword = "1234557ddAa@";
    String lockedEmail = "pheeboonleo96@gmail.com";
    String lockedPassword = "1234567Aa@";
    String schEmail = "1800794@sit.singaporetech.edu.sg";
    String concurrentEmail = "pheeboon-leo@hotmail.com";

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
    //Expected result: if no acccount matches with database means no such account created, then
    //                 stay on same page
    public void test_negative_accountInDatabase() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(noEmail);
                driver.findElement(By.name("password_1")).sendKeys(noPassword);
		//click submit
		driver.findElement(By.name("login_user")).click();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if negative password matches with database means wrong password for associated username, then
    //                 stay on same page
    public void test_negative_passwordMatchesWithDatabase() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys("1801233@sit.singaporetech.edu.sg");
                driver.findElement(By.name("password_1")).sendKeys("dasskfjsahfkasjfhasf1d");
		//click submit
		driver.findElement(By.name("login_user")).click();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
    
    @Test
    //Expected result: if unverified account for associated username, then
    //                 stay on same page
    public void test_negative_verifiedAccount() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(unverifiedEmail);
                driver.findElement(By.name("password_1")).sendKeys(password_2);
		//click submit
		driver.findElement(By.name("login_user")).click();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}

    @Test
    //Expected result: if account is locked due to over trying of login attempts for associated username, then
    //                 stay on same page
    public void test_positive_lockedAccount() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(schEmail);
                driver.findElement(By.name("password_1")).sendKeys(password_2);
		//click submit
		driver.findElement(By.name("login_user")).click();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
   
    @Test
    //Expected result: if successful login, then go to enter otp page
    public void test_positive_login() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("password_1")).sendKeys(password_2);
		//click submit
		driver.findElement(By.name("login_user")).click();
                
                //check result 
		String expectedResult = "Busbly Enter OTP"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
    
    @Test
    //Expected result: if there is concurrent login associated to a account, then stay at same page, cannot login
    public void test_positive_concurrentLogin() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(concurrentEmail);
                driver.findElement(By.name("password_1")).sendKeys(password_2);
		//click submit
		driver.findElement(By.name("login_user")).click();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
}