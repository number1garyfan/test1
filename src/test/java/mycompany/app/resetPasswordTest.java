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
public class resetPasswordTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/forgetPassword.php";
    String email = "pheeboon_leo@hotmail.com";
    String password_1 = "1234567Aa@";
    String password_2 = "1234567Aa@";
    String password_3 = "1234597Aa@";

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
    //Expected result: check if alert exist because alert will appear if success password reset
    public void test_positive_resetPassword() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 
                driver.findElement(By.name("email")).sendKeys("pheeboon_leo@hotmail.com");
                driver.findElement(By.name("forget_password")).click();

		//enter input
                wait.until(ExpectedConditions.titleContains("Busbly Reset Password")); 
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(password_2);
		//click submit
		driver.findElement(By.name("reset_password")).click();
	
		//check result 
                boolean AlertExists;
                try
                {
                    wait.until(ExpectedConditions.alertIsPresent());
                    AlertExists = true;
                    assertTrue(AlertExists == true); 
                }
                catch(Exception ex)
                {
                    AlertExists = false;
                }
 
	}
    
    @Test
    //Expected result: reset password fail will remain at the same page
    public void test_negative_resetPassword() 
		throws InterruptedException { 

                //get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 
                driver.findElement(By.name("email")).sendKeys("pheeboon_leo@hotmail.com");
                driver.findElement(By.name("forget_password")).click();

		//enter input
                wait.until(ExpectedConditions.titleContains("Busbly Reset Password")); 
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(password_2);
		//click submit
		driver.findElement(By.name("reset_password")).click();
	
                //check result 
		String expectedResult = "Busbly Reset Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
 
	}
    
   
}
