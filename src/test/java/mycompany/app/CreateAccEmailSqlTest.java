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
public class CreateAccEmailSqlTest {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/createAccount.php";
    
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
  
    		
    String username = "santaclaus123";
    String password = "Password123!";
    String password2 = "Password123!";
    
    
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
    public void test_create_email_sql_script1() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql1);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account";
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script2() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql2);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script3() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql3);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script4() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql4);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script5() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql5);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script6() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql6);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script7() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql7);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script8() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql8);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script9() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql9);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script10() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql10);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script11() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql11);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script12() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql12);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script13() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql13);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script14() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql14);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script15() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql15);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script16() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql16);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script17() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql17);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script18() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql18);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script19() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql19);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script20() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql20);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script21() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql21);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script22() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql22);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script23() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql23);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script24() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql24);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script25() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql25);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script26() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql26);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script27() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql27);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script28() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql28);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script29() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql29);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script30() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql30);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script31() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql31);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script32() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql32);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script33() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql33);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script34() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql34);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script35() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql35);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script36() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql36);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script37() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql37);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script38() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql38);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script39() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql39);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script40() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql40);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script41() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql41);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script42() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql42);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script43() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql43);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script44() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql44);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script45() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql45);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script46() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql46);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script47() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql47);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script48() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql48);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script49() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql49);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script50() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql50);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script51() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql51);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script52() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql52);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script53() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql53);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script54() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql54);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script55() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql55);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script56() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql56);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script57() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql57);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script58() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql58);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script59() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql59);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script60() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql60);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script61() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql61);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script62() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql62);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script63() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql63);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script64() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql64);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script65() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql65);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script66() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql66);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script67() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql67);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script68() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql68);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script69() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql69);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script70() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql70);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script71() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql71);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script72() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql72);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script73() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql73);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script74() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql74);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script75() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql75);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script76() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql76);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script77() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql77);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script78() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql78);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script79() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql79);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script80() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql80);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script81() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql81);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script82() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql82);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script83() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql83);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script84() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql84);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script85() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql85);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script86() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql86);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script87() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql87);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script88() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql88);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script89() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql89);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script90() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql90);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script91() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql91);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script92() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql92);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script93() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql93);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script94() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql94);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script95() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql95);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script96() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql96);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script97() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql97);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script98() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql98);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script99() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql99);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script100() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql100);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script101() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql101);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script102() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql102);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script103() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql103);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script104() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql104);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script105() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql105);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script106() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql106);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script107() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql107);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script108() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql108);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script109() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql109);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script110() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql110);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script111() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql111);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script112() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql112);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script113() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql113);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script114() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql114);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script115() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql115);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script116() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql116);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script117() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql117);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script118() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql118);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script119() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql119);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script120() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql120);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql script is detected, then
    //                 stay on same page
    public void test_create_email_sql_script121() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Create Account")); 

		//enter input
		//use each and every possible sql statement and inject 
		//other field regardless correct/wrong does not matter as we are testing sql attack on email field
		driver.findElement(By.name("email")).sendKeys(sql121);
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password_1")).sendKeys(password);
                driver.findElement(By.name("password_2")).sendKeys(password2);
		//click submit
		driver.findElement(By.name("reg_user")).click();
                
                //check result 
		String expectedResult = "Busbly Create Account"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
       
    
    
}
