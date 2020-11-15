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
public class ForgetPasswordSqlTest {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "https://teamname.sitict.net/testen/forgetPassword.php";
    
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
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql1() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql1);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
   
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql2() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql2);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
 
   
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql3() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql3);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
 
   
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql4() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql4);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
  
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql5() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql5);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql6() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql6);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql7() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql7);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql8() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql8);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql9() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql9);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql10() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql10);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql11() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql11);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql12() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql12);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql13() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql13);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql14() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql14);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql15() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql15);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql16() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql16);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql17() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql17);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql18() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql18);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql19() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql19);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql20() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql20);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql21() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql21);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql22() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql22);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql23() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql23);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql24() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql24);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql25() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql25);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql26() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql26);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql27() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql27);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql28() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql28);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql29() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql29);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql30() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql30);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql31() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql31);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql32() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql32);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql33() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql33);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql34() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql34);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql35() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql35);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql36() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql36);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql37() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql37);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql38() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql38);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql39() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql39);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql40() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql40);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql41() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql41);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql42() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql42);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql43() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql43);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql44() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql44);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql45() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql45);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql46() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql46);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql47() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql47);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql48() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql48);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql49() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql49);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql50() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql50);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql51() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql51);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql52() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql52);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql53() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql53);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql54() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql54);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql55() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql55);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql56() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql56);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql57() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql57);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql58() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql58);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql59() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql59);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql60() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql60);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql61() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql61);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql62() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql62);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql63() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql63);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql64() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql64);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql65() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql65);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql66() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql66);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql67() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql67);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql68() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql68);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql69() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql69);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql70() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql70);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql71() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql71);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql72() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql72);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql73() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql73);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql74() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql74);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql75() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql75);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql76() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql76);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql77() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql77);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql78() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql78);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql79() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql79);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql80() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql80);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql81() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql81);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql82() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql82);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql83() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql83);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql84() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql84);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql85() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql85);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql86() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql86);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql87() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql87);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql88() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql88);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql89() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql89);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql90() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql90);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql91() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql91);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql92() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql92);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql93() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql93);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql94() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql94);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql95() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql95);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql96() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql96);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql97() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql97);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql98() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql98);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql99() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql99);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql100() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql100);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql101() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql101);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql102() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql102);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql103() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql103);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql104() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql104);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql105() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql105);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql106() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql106);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql107() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql107);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql108() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql108);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql109() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql109);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql110() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql110);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql111() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql111);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql112() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql112);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql113() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql113);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql114() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql114);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql115() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql115);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql116() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql116);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql117() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql117);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql118() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql118);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql119() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql119);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql120() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql120);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql121() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql121);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql122() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql122);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql123() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql123);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql124() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql124);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql125() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql125);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql126() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql126);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql127() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql127);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void forget_pass_sql128() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forget Password")); 

		//enter input
		//use each and every possible SQL statement and inject on email field and submit
		driver.findElement(By.name("email")).sendKeys(sql128);
		//click submit
		driver.findElement(By.name("forget_password")).click();
                
                //check result 
		String expectedResult = "Busbly Forget Password"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
        
    
}
