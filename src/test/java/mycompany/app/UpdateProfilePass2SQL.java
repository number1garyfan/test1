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
public class UpdateProfilePass2SQL {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/updateProfile.php";
    
    String sql1 = "'";
    String sql2 = "a' or 1=1--";
    String sql3 = "\"a\"\" or 1=1--\"";
    String sql4 = " or a = a";
    String sql5 = "a' or 'a' = 'a";
    String sql6 = "1 or 1=1";
    String sql7 = "a' waitfor delay '0:0:10'--";
    String sql8 = "1 waitfor delay '0:0:10'--";
    String sql9 = "declare @q nvarchar (200) select @q = 0x770061006900740066006F0072002000640065006C00610079002000270030003A0030003A0031003000270000 exec(@q)";
    String sql10 = "declare @s varchar(200) select @s = 0x77616974666F722064656C61792027303A303A31302700 exec(@s) ";
    String sql11 = "declare @q nvarchar (200) 0x730065006c00650063007400200040004000760065007200730069006f006e00 exec(@q)";
    String sql12 = "declare @s varchar (200) select @s = 0x73656c65637420404076657273696f6e exec(@s)";
    String sql13 = "a'";
    String sql14 = "?";
    String sql15 = "' or 1=1";
    String sql16 = " or 1=1 --";
    String sql17 = "x' AND userid IS NULL; --";
    String sql18 = "x' AND email IS NULL; --";
    String sql19 = "anything' OR 'x'='x";
    String sql20 = "x' AND 1=(SELECT COUNT(*) FROM tabname); --";
    String sql21 = "x' AND members.email IS NULL; --";
    String sql22 = "x' OR full_name LIKE '%Bob%";
    String sql23 = "23 OR 1=1";
    String sql24 = "'; exec master..xp_cmdshell 'ping 172.10.1.255'--";
    String sql25 = "'";
    String sql26 = "'%20or%20''='";
    String sql27 = "'%20or%20'x'='x";
    String sql28 = "%20or%20x=x";
    String sql29 = "')%20or%20('x'='x";
    String sql30 = "0 or 1=1";
    String sql31 = "' or 0=0 --";
    String sql32 = "\" or 0=0 --";
    String sql33 = "or 0=0 --";
    String sql34 = "' or 0=0 #";
    String sql35 = " or 0=0 #\"";
    String sql36 = "or 0=0 #";
    String sql37 = "' or 1=1--";
    String sql38 = "\" or 1=1--";
    String sql39 = "' or '1'='1'--";
    String sql40 = "' or 1 --'";
    String sql41 = "or 1=1--";
    String sql42 = "or%201=1";
    String sql43 = "or%201=1 --";
    String sql44 = "' or 1=1 or ''='";
    String sql45 = " or 1=1 or \"\"=";
    String sql46 = "' or a=a--";
    String sql47 = " or a=a";
    String sql48 = "') or ('a'='a";
    String sql49 = ") or (a=a";
    String sql50 = "hi or a=a";
    String sql51 = "hi or 1=1 --\"";
    String sql52 = "hi' or 1=1 --";
    String sql53 = "hi' or 'a'='a";
    String sql54 = "hi') or ('a'='a";
    String sql55 ="\"hi\"\") or (\"\"a\"\"=\"\"a\"";
    String sql56 ="'hi' or 'x'='x';";
    String sql57 = ",@variable";
    String sql58 = "PRINT";
    String sql59 = "PRINT @@variable";
    String sql60 = "select";
    String sql61 = "insert";
    String sql62 = "as";
    String sql63 = "or";
    String sql64 = "procedure";
    String sql65 = "limit";
    String sql66 = "order by";
    String sql67 = "asc";
    String sql68 = "desc";
    String sql69 = "delete";
    String sql70 = "update";
    String sql71 = "distinct";
    String sql72 = "having";
    String sql73 = "truncate";
    String sql74 = "replace";
    String sql75 = "like";
    String sql76 = "handler";
    String sql77 = "bfilename";
    String sql78 = "' or username like '%";
    String sql79 = "' or uname like '%";
    String sql80 = "' or userid like '%";
    String sql81 = "' or uid like '%";
    String sql82 = "' or user like '%";
    String sql83 = "exec xp";
    String sql84 = "exec sp";
    String sql85 = "'; exec master..xp_cmdshell";
    String sql86 = "'; exec xp_regread";
    String sql87 = "t'exec master..xp_cmdshell 'nslookup www.google.com'--";
    String sql88 = "--sp_password";
    String sql89 = "\\x27UNION SELECT";
    String sql90 = "' UNION SELECT";
    String sql91 = "' UNION ALL SELECT";
    String sql92 = "' or (EXISTS)";
    String sql93 = "' (select top 1";
    String sql94 = "'||UTL_HTTP.REQUEST";
    String sql95 = "1;SELECT%20*";
    String sql96 = "to_timestamp_tz";
    String sql97 = "tz_offset";
    String sql98 = "<>\"'%;)(&+";
    String sql99 = "'%20or%201=1";
    String sql100 = "%27%20or%201=1";
    String sql101 = "%20$(sleep%2050)";
    String sql102 = "%20'sleep%2050'";
    String sql103 = "char%4039%41%2b%40SELECT";
    String sql104 = "&apos;%20OR";
    String sql105 = "'sqlattempt1";
    String sql106 = "(sqlattempt2)";
    String sql107 = "|";
    String sql108 = "%7C";
    String sql109 = "*|";
    String sql110 = "%2A%7C";
    String sql111 = "*(|(mail=*))";
    String sql112 = "%2A%28%7C%28mail%3D%2A%29%29";
    String sql113 = "*(|(objectclass=*))";
    String sql114 = "%2A%28%7C%28objectclass%3D%2A%29%29";
    String sql115 = "(";
    String sql116 = "0.28";
    String sql117 = ")";
    String sql118 = "0.29";
    String sql119 = "&";
    String sql120 = "0.26";
    String sql121 = "!";
    String sql122 = "0.21";
    String sql123 = "' or 1=1 or ''='";
    String sql124 = "' or ''='";
    String sql125 = "x' or 1=1 or 'x'='y";
    String sql126 = "/";
    String sql127 = "//";
    String sql128 = "//*"; 
  
    String email = "1801589@sit.singaporetech.edu.sg";		
    String username = "santaclaus123";
    String password_1 = "Password123!";
    
    
    
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
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script1() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql1);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script2() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql2);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script3() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql3);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script4() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql4);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script5() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql5);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script6() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql6);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script7() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql7);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script8() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql8);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script9() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql9);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script10() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql10);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script11() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql11);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script12() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql12);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script13() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql13);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script14() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql14);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script15() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql15);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script16() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql16);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script17() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql17);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script18() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql18);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script19() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql19);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script20() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql20);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script21() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql21);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script22() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql22);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script23() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql23);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script24() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql24);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script25() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql25);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script26() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql26);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script27() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql27);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script28() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql28);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script29() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql29);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script30() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql30);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script31() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql31);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script32() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql32);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script33() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql33);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script34() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql34);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script35() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql35);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script36() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql36);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script37() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql37);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script38() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql38);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script39() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql39);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script40() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql40);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script41() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql41);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script42() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql42);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script43() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql43);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script44() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql44);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script45() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql45);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script46() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql46);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script47() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql47);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script48() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql48);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script49() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql49);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script50() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql50);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script51() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql51);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script52() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql52);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script53() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql53);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script54() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql54);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script55() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql55);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script56() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql56);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script57() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql57);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script58() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql58);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script59() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql59);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script60() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql60);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script61() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql61);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script62() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql62);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script63() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql63);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script64() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql64);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script65() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql65);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script66() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql66);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script67() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql67);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script68() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql68);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script69() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql69);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script70() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql70);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script71() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql71);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script72() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql72);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script73() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql73);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script74() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql74);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script75() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql75);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script76() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql76);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script77() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql77);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script78() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql78);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script79() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql79);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script80() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql80);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script81() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql81);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script82() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql82);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script83() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql83);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script84() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql84);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script85() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql85);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script86() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql86);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script87() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql87);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script88() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql88);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script89() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql89);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script90() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql90);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script91() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql91);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script92() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql92);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script93() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql93);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script94() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql94);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script95() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql95);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script96() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql96);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script97() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql97);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script98() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql98);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script99() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql99);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script100() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql100);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script101() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql101);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script102() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql102);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script103() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql103);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script104() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql104);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script105() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql105);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script106() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql106);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script107() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql107);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script108() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql108);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script109() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql109);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script110() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql110);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script111() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql111);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script112() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql112);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script113() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql113);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script114() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql114);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script115() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql115);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script116() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql116);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script117() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql117);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script118() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql118);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script119() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql119);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script120() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql120);
		//click submit
		driver.findElement(By.name("update_profile")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_update_pass2_sql_script121() 
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
               
        
		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password_1);
                driver.findElement(By.name("password_2")).sendKeys(sql121);
		//click submit
		driver.findElement(By.name("update_profile")).click() ;
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
       
    
    
}
