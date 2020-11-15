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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class CreateTopicTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/login.php";
    String logout = "https://teamname.sitict.net/testen/logout.php";
    String email = "testemail@email.com";
    String password = "Password111!";
    
    
    
    String newTopicname = "New Topic";
    
    
    String failTopicname = "";

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
    //Expected result: check if alert exist 
    public void test_create_new_topic_success() 
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
        driver.findElement(By.id("submitNewTopic")).click();
//        System.out.println("URL of the page is -> " + driver.getCurrentUrl());
		//enter input
		driver.findElement(By.name("TopicName")).sendKeys(newTopicname);
		
		//click submit
		driver.findElement(By.name("submitCreateTopic")).click();
        
          	
		//check result 
                boolean AlertExists;
                try
                {
                    wait.until(ExpectedConditions.alertIsPresent());
                    AlertExists = true;
                    assertTrue(AlertExists == true); 
                    System.out.println("success");
                }
                catch(Exception ex)
                {
                    AlertExists = false;
                }
 
	
        
        //logout of page to prevent multiple logon
        driver.get(logout);
//        System.out.println(driver.getTitle());
        
    }    
    
    @Test
    //Expected result: check if alert exist 
    public void test_create_new_topic_fail() 
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
        driver.findElement(By.id("submitNewTopic")).click();
//        System.out.println("URL of the page is -> " + driver.getCurrentUrl());
		//enter input
		driver.findElement(By.name("TopicName")).sendKeys(failTopicname);
		
		//click submit
		driver.findElement(By.name("submitCreateTopic")).click();
        
          	
		//check result 
                boolean AlertExists;
                try
                {
                    wait.until(ExpectedConditions.alertIsPresent());
                    AlertExists = true;
                    assertTrue(AlertExists == true); 
                    System.out.println("success");
                }
                catch(Exception ex)
                {
                    AlertExists = false;
                }
 
	
        
        //logout of page to prevent multiple logon
        driver.get(logout);
        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
        
    }  

    
    


}
