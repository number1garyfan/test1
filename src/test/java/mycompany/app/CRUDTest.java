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
public class CRUDTest {
    
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
       // System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
        
    }  

    
    
    
    
    
    @Test
    //Expected result: check if alert exist 
    public void test_create_new_thread_pass() 
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
        driver.findElement(By.name("Topic")).click();
        
        //get to new thread page
		driver.findElement(By.id("submitNewThread")).click();
		
		//enter input
		driver.findElement(By.id("ThreadName")).sendKeys(newThreadname);
		
		//click submit
		driver.findElement(By.name("submitCreateThread")).click();
          	
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
        //System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
        
    }      
    
    
    @Test
    //Expected result: check if alert exist 
    public void test_create_new_thread_fail() 
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
        driver.findElement(By.name("Topic")).click();
        
        //get to new thread page
		driver.findElement(By.id("submitNewThread")).click();
		
		//enter input
		driver.findElement(By.id("ThreadName")).sendKeys(failThreadname);
		
		//click submit
		driver.findElement(By.name("submitCreateThread")).click();
          	
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
        //System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
        
    }      
    
    
    @Test
    //Expected result: check if alert exist 
    public void test_create_new_post_pass() 
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
        driver.findElement(By.name("Topic")).click();
        
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        
        //get to new post page
		driver.findElement(By.id("submitNewPost")).click();
		
		//enter input
		driver.findElement(By.id("PostContent")).sendKeys("This is a post");
		
		//click submit
		driver.findElement(By.name("submitCreatePost")).click();
          	
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
    
    @Test
    //Expected result: check if alert exist 
    public void test_create_new_post_fail() 
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
        driver.findElement(By.name("Topic")).click();
        
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        
        //get to new post page
		driver.findElement(By.id("submitNewPost")).click();
		
		//enter input
		driver.findElement(By.id("PostContent")).sendKeys("");
		
		//click submit
		driver.findElement(By.name("submitCreatePost")).click();
          	
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
    
   
    @Test
    //Expected result: check if alert exist 
    public void test_edit_post_pass() 
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
        driver.findElement(By.name("Topic")).click();
        
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
      
        
		//enter input
		driver.findElement(By.id("PostContent")).sendKeys(" Edited Post!");
		
		//click submit
		driver.findElement(By.name("submitEditPost")).click();
          	
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
    
    @Test
    //Expected result: check if alert exist 
    public void test_edit_post_fail() 
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
        driver.findElement(By.name("Topic")).click();
        
        
        //select thread 
        driver.findElement(By.name("Thread")).click();
        System.out.println(driver.getCurrentUrl());
        //select edit post
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
		
      
        
		//enter input
		driver.findElement(By.id("PostContent")).sendKeys("<><>");
		
		//click submit
		driver.findElement(By.name("submitEditPost")).click();
          	
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
    
    

    
    @Test
    //Expected result: check if alert exist 
    public void test_edit_thread_pass() 
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
        driver.findElement(By.name("Topic")).click();
        
        
        //select edit thread 
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
       
        System.out.println(driver.getCurrentUrl());
        
		
      
        
		//enter input
		driver.findElement(By.id("ThreadName")).sendKeys(" edited");
		
		//click submit
		driver.findElement(By.name("submitEditThread")).click();
          	
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
    
    
    @Test
    //Expected result: check if alert exist 
    public void test_edit_thread_fail() 
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
        driver.findElement(By.name("Topic")).click();
        
        
        //select edit thread 
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[1]/button")).submit();
       
        System.out.println(driver.getCurrentUrl());
        
		
      
        
		//enter input
		driver.findElement(By.id("ThreadName")).sendKeys("<><><><>");
		
		//click submit
		driver.findElement(By.name("submitEditThread")).click();
          	
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
    
    
    @Test
    //Expected result: check if alert exist 
    public void test_edit_topic_success() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create edit topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[4]/div/form[1]/button")).submit();
        
        System.out.println("URL of the page is -> " + driver.getCurrentUrl());
		//enter input
        
		driver.findElement(By.name("TopicName")).sendKeys(" edited");
		
		//click submit
		driver.findElement(By.name("submitEditTopic")).click();
        
          	
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
        
    }    
    
    
    @Test
    //Expected result: check if alert exist 
    public void test_edit_topic_failure() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Login")); 
		driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password_1")).sendKeys(password);
        //click submit
        driver.findElement(By.name("login_user")).submit();
 
        
        //get to create edit topic page
        wait.until(ExpectedConditions.titleContains("Busbly Forum")); 
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[4]/div/form[1]/button")).submit();
        
        System.out.println("URL of the page is -> " + driver.getCurrentUrl());
		//enter input
        
        //invalid to make fail
		driver.findElement(By.name("TopicName")).sendKeys("<><><>>");
		
		//click submit
		driver.findElement(By.name("submitEditTopic")).click();
        
          	
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
        
    }    
    
  
    @Test
    //Expected result: check if alert exist 
    public void test_delete_post_pass() 
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
        driver.findElement(By.id("submitNewTopic")).click();
        //add topic
        
        System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.name("TopicName")).sendKeys("To be delete");
        driver.findElement(By.name("submitCreateTopic")).click();
        //go back home
        
        driver.findElement(By.xpath("//*[@id=\"navbarsExampleDefault\"]/ul[1]/li[1]/a")).click();
        System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.xpath("//button[text()='To be delete']")).submit();
        
        //select new  thread 
        driver.findElement(By.id("submitNewThread")).click();
        System.out.println(driver.getCurrentUrl());
       
        //add create thread name 
        driver.findElement(By.id("ThreadName")).sendKeys("To be delete");
        driver.findElement(By.name("submitCreateThread")).submit();
        
        //go back home
        driver.findElement(By.xpath("//*[@id=\"navbarsExampleDefault\"]/ul[1]/li[1]/a")).click();
        System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.xpath("//button[text()='To be delete']")).submit();
        
        //go first thread
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[1]/form/button")).submit();
        
        
        System.out.println(driver.getCurrentUrl());
        
        //create new post
        driver.findElement(By.id("submitNewPost")).submit();
        System.out.println(driver.getCurrentUrl());
       
        
        driver.findElement(By.name("PostComment")).sendKeys("To be delete");
        driver.findElement(By.name("submitCreatePost")).submit();
        //here 
        
        
        //go back home
        
//        driver.findElement(By.xpath("//*[@id=\"navbarsExampleDefault\"]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarsExampleDefault\"]/ul[1]/li[1]/a")).click();
        System.out.println(driver.getCurrentUrl());
        
        
        //go to viewpost
        driver.findElement(By.xpath("//button[text()='To be delete']")).submit();
      //first thread
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[1]/form/button")).click();
        System.out.println(driver.getCurrentUrl());
        
        driver.findElement(By.xpath("//*[@id=\"dtBasicExample\"]/tbody/tr/td[3]/div/form[2]/button")).submit();
           
       
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
        //driver.get(logout);
        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
        
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
