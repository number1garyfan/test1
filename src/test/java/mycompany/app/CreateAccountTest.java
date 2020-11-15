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
import org.openqa.selenium.Alert;

/**
 *
 * @author pheeb
 */
public class CreateAccountTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/createAccount.php";
    String email = "pheeboon_leo@hotmail.com";
    String username = "pbtantan";
    String password_1 = "1234567Aa@";
    String password_2 = "1234567Aa@";
    String email2 = "pheeboon-leo@hotmail.com";
    String username2 = "pbtantantan";
    String password_12 = "1234567Aa@";
    String password_22 = "1234567Aa@";


@Before
    public void setUp() { 
		driver = new HtmlUnitDriver(); 
		wait = new WebDriverWait(driver, 20); 
	} 

@After
    public void tearDown() { 
		driver.quit(); 
	}	 
   
    
    @Test
    //Expected result: check if alert exist because alert will appear if success account creation
    public void test_positive_createAccount() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys("pheeboonlddeoffffffffff9f6sfdf@gmail.com");
                driver.findElement(By.name("username")).sendKeys("pbboobddsdfffffffffffffsdfoo");
                driver.findElement(By.name("password_1")).sendKeys("1234567Aa@");
                driver.findElement(By.name("password_2")).sendKeys("1234567Aa@");
		//click submit
		driver.findElement(By.name("reg_user")).click();
	
                // Switching to Alert        
                Alert alert = driver.switchTo().alert();		

                // Capturing alert message.    
                String alertMessage= driver.switchTo().alert().getText();		

                // Displaying alert message		
                System.out.println(alertMessage);	
                Thread.sleep(5000);

                // Accepting alert		
                alert.accept();	
 
	}
    
     @Test
    //Expected result: if user exist, will stay on the same page
    public void test_positive_userExist() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(email2);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_12);
                driver.findElement(By.name("password_2")).sendKeys(password_22);
		//click submit
		driver.findElement(By.name("reg_user")).submit();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
 
	}
    
     @Test
    //Expected result: if email exist, will stay on the same page
    public void test_positive_emailExist() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username2);
                driver.findElement(By.name("password_1")).sendKeys(password_12);
                driver.findElement(By.name("password_2")).sendKeys(password_22);
		//click submit
		driver.findElement(By.name("reg_user")).submit();
                
                //check result 
		String expectedResult = "Busbly Login"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
 
	}
    
   
}
