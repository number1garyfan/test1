package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

public class HelloTest
{
	WebDriver driver;
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/forgetPassword.php";
	
	
    String xss1 = "<script>alert(1)</script>";
	
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
    public void forget_pass_xss1() 
		throws InterruptedException { 

    		//get web page
    	driver.get(url);
    		//wait until page is loaded or timeout error
    	wait.until(ExpectedConditions.titleContains("Busbly Forget ")); 

    		//enter input
    		//use each and every possible xss statement and inject on email field and submit
    	driver.findElement(By.name("email")).sendKeys(xss1);
    		//click submit
    	driver.findElement(By.name("forget_password")).submit();
                    
                    //check result 
    	String expectedResult = "Busbly Forget "; 
    	boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
    	assertTrue(isResultCorrect == true); 
       }
    
}