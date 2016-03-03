package com.org.leaningMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FireFoxDrTest {
	
	private final WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp ()
	{
		System.out.println(" test is starting ");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		System.out.println(" test is done ");
		driver.close();	
		
	}
	
	@BeforeMethod
	public void getBrowser ()
	{
		
		driver.navigate().to("http://qatest.jukinmedia.com/#/");
		driver.navigate().refresh();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(7000);
			
	}
	
	
	@Test (priority = 1)
	public void test1 ()
	{
		driver.navigate().refresh();
		driver.navigate().to("http://qatest.jukinmedia.com/#/");
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		
		test1.submitNativeTest();
		
	}
	
	@Test (priority = 2)
	public void test2 ()
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest();
		
	}

	@Test (priority = 3)
	public void test3 ()
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.securityTest();
		
	}
	
	@Test (priority = 4)
	public void test4 ()
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().companyTitleTest();
		
	}

	@Test (priority = 5)
	public void test5 ()
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().positiveSignUpTest ();
		
	}
	
	@Test (priority = 6)
	public void test6 () throws InterruptedException
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().negativeSignUpTest();
		
	}
	
	@Test (priority = 7)
	public void test7 () 
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().postiveWithRecomandedYes ();
		
	}
	
	@Test (priority = 8)
	public void test8 () 
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().postiveWithRecomandedNo();
		
	}
	
	@Test (priority = 9)
	public void test9 () 
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().negativeTestSumitFormWithoutInfo ();
		
	}
	
	@Test (priority = 10)
	public void test10 () 
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().negativeTestWithNoRecomandButNoWriting ();
		
	}
	
	@Test (priority = 11)
	public void test11 () 
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().negativeTestWithoutFirstName ();
		
	}
	
	@Test (priority = 12)
	public void test12 () 
	{
		JukinmediaLoginPage test1 = new JukinmediaLoginPage(driver);
		test1.submitLoginPositiveTest().negativeTestWithoutPhoneNumber ();
		
	}
	
}
