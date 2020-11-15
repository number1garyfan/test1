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
public class UpdateProfileFailTest {
    
    WebDriver driver; 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/login.php";
    String logout = "https://teamname.sitict.net/testen/logout.php";
    String email = "testemail@email.com";
    String password = "Password111!";
    
    
    
    String newTopicname = "New Topic";
    
    String failTopicname = "";
    
    
    
    String newThreadname = "New Thread";
    
    String failThreadname = "";
    

@Before
    public void setUp() { 
		driver = new HtmlUnitDriver(); 
		wait = new WebDriverWait(driver, 10); 
	} 

@After
    public void tearDown() { 
		driver.findElement(By.xpath("//*[@id=\"navbarsExampleDefault\"]/ul[2]/li[2]/a")).click();
		driver.quit(); 
	}	 
   
    
@Test
    //Expected result: check if alert exist 
    public void test_update_profile_pass() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		driver.findElement(By.name("email")).sendKeys("1801233@sit.singaporetech.edu.sg");
        driver.findElement(By.name("password_1")).sendKeys("Password111!");
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create new topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        
        driver.findElement(By.linkText("Update Profile")).click();
        System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password_1")).clear();
        driver.findElement(By.name("password_2")).clear();
               
        
        driver.findElement(By.name("email")).sendKeys("1801233@sit.singaporetech.edu.sg");
        driver.findElement(By.name("username")).sendKeys("yappy");
        driver.findElement(By.name("password_1")).sendKeys("aaaaaaa!");
        driver.findElement(By.name("password_2")).sendKeys("Password111!");
        
        //submit
        driver.findElement(By.name("update_profile")).click();
        
        System.out.println(driver.getCurrentUrl());
        
        //check result 
        String expectedResult = "https://teamname.sitict.net/testen/updateProfile.php"; 
        boolean isResultCorrect = wait.until(ExpectedConditions.urlContains(expectedResult)); 
        assertTrue(isResultCorrect == true); 
	
        
}   
}
    