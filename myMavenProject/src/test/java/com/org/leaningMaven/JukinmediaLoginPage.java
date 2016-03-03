package com.org.leaningMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class JukinmediaLoginPage {

	private final WebDriver driver;
	By usernameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By loginButtonLocator = By.xpath("html/body/div[1]/div/form/div[3]/button");
	private String validUserName = "jukinmedia";
	private String validPassword = "qatest";
	private String wrongPassword = "qtet";
			

	
	public JukinmediaLoginPage(WebDriver driver) {
		this.driver = driver;
		if (!"http://qatest.jukinmedia.com/#/".equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("This is not the login page");
		}
	}

	
	public FeadbackFormPage submitLoginPositiveTest() {

		driver.findElement(usernameLocator).sendKeys(validUserName);
		driver.findElement(passwordLocator).sendKeys(validPassword);
		driver.findElement(loginButtonLocator).submit();
		return new FeadbackFormPage(driver);    
	}


	public JukinmediaLoginPage submitNativeTest() {

		driver.findElement(usernameLocator).sendKeys(validUserName);
		driver.findElement(passwordLocator).sendKeys(wrongPassword);
		driver.findElement(loginButtonLocator).submit();
		return this; 
		
	}


	public void securityTest() { 

		driver.findElement(usernameLocator).sendKeys(validUserName);
		driver.findElement(passwordLocator).sendKeys(validPassword);
		driver.findElement(loginButtonLocator).submit();
		driver.navigate().back();
		driver.navigate().forward();
		if ("http://qatest.jukinmedia.com/#/form".equals(driver.getCurrentUrl())) 
			System.out.println("Url navigation security test fails");
	     if ("http://qatest.jukinmedia.com/#/".equals(driver.getCurrentUrl()))
	    		 System.out.println("Url navigation security test pasess"); 
	    	 
		
	}
	
	
	
	
}
