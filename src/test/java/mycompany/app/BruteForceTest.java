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
public class BruteForceTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/login.php";
    String BruteForceEmail = "pheeboonleo96@gmail.com";
    String BruteForcePassword = "1234567Aa@";
    String noBruteForceEmail = "1800794@sit.singaporetech.edu.sg";
    String noBruteForcePassword = "1234567Aa@";

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
    //Expected result: return true for positive bruteforce after checking number of attempts from database
    //Based on our requirement: number of attempts > 3 == brute force
    public void test_positive_bruteforce() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(BruteForceEmail);
                driver.findElement(By.name("password_1")).sendKeys(BruteForceEmail);
		//click submit
		driver.findElement(By.name("login_user")).click();
	
		//check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
    
    @Test
    //Expected result: return false for negative bruteforce after checking number of attempts from database
    //Based on our requirement: number of attempts <= 3 == brute force
    public void test_negative_bruteforce() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(noBruteForceEmail);
                driver.findElement(By.name("password_1")).sendKeys(noBruteForcePassword);
		//click submit
		driver.findElement(By.name("login_user")).click();
	
		//check result 
		String expectedResult = "Busbly Enter OTP"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}

}
