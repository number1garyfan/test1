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
public class CreatePostSQL {
    
	WebDriver driver = new HtmlUnitDriver(true); 
    WebDriverWait wait; 
    String url = "http://localhost/ICT3103Busbly/createPost.php";
    
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
    String sql18 = "x' AND PostComment IS NULL; --";
    String sql19 = "anything' OR 'x'='x";
    String sql20 = "x' AND 1=(SELECT COUNT(*) FROM tabname); --";
    String sql21 = "x' AND members.PostComment IS NULL; --";
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
    public void test_create_post_sql1() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql1);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
   
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql2() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql2);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
 
   
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql3() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql3);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
 
   
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql4() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql4);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
  
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql5() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql5);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql6() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql6);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql7() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql7);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql8() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql8);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql9() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql9);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql10() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql10);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql11() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql11);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql12() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql12);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql13() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql13);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql14() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql14);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql15() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql15);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql16() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql16);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql17() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql17);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql18() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql18);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql19() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql19);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql20() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql20);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql21() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql21);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql22() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql22);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql23() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql23);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql24() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql24);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql25() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql25);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql26() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql26);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql27() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql27);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql28() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql28);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql29() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql29);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql30() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql30);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql31() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql31);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql32() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql32);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql33() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql33);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql34() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql34);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql35() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql35);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql36() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql36);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql37() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql37);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql38() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql38);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql39() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql39);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql40() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql40);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql41() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql41);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql42() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql42);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql43() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql43);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql44() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql44);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql45() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql45);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql46() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql46);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql47() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql47);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql48() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql48);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql49() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql49);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql50() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql50);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql51() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql51);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql52() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql52);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql53() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql53);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql54() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql54);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql55() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql55);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql56() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql56);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql57() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql57);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql58() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql58);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql59() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql59);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql60() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql60);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql61() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql61);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql62() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql62);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql63() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql63);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql64() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql64);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql65() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql65);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql66() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql66);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql67() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql67);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql68() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql68);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql69() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql69);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql70() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql70);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql71() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql71);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql72() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql72);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql73() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql73);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql74() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql74);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql75() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql75);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql76() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql76);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql77() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql77);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql78() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql78);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql79() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql79);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql80() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql80);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql81() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql81);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql82() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql82);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql83() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql83);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql84() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql84);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql85() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql85);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql86() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql86);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql87() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql87);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql88() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql88);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql89() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql89);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql90() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql90);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql91() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql91);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql92() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql92);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql93() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql93);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql94() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql94);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql95() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql95);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql96() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql96);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql97() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql97);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql98() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql98);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql99() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql99);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql100() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql100);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql101() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql101);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql102() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql102);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql103() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql103);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql104() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql104);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql105() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql105);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql106() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql106);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql107() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql107);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql108() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql108);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql109() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql109);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql110() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql110);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql111() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql111);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql112() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql112);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql113() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql113);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql114() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql114);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql115() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql115);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql116() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql116);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql117() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql117);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql118() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql118);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql119() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql119);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql120() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql120);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql121() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql121);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql122() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql122);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql123() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql123);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql124() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql124);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql125() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql125);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }

    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql126() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql126);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql127() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql127);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
    @Test
    //Expected result: if sql injection is detected, then
    //                 stay on same page
    public void test_create_post_sql128() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Busbly Forum")); 

		//enter input
		//use each and every possible SQL statement and inject on PostComment field and submit
		driver.findElement(By.name("PostComment")).sendKeys(sql128);
		//click submit
		driver.findElement(By.name("submit")).click();
                
                //check result 
		String expectedResult = "Busbly Forum"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
   }
    
        
    
}
