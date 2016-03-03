package com.org.leaningMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FeadbackFormPage {

	private static WebDriver dri;
	By companyNameLocator = By.xpath("html/body/div[1]/header/div/div[2]/h1");
	By singuplinkLocator = By.xpath("html/body/div[1]/header/div/div[3]/a/span");
	By emailLocator = By.xpath("html/body/div[3]/div/div/form/div[1]/input");
	By ageConcentLocator = By.xpath("html/body/div[3]/div/div/form/div[1]/label/input");
	By signUpSubmitLocator = By.xpath("html/body/div[3]/div/div/form/div[2]/button");
	By hearRadioButtonLocator = By.xpath("html/body/div[1]/div[2]/form/div[1]/div/div[3]/label/input");
	By experienceRadioButtonLocator = By.xpath("html/body/div[1]/div[2]/form/div[2]/div/div[4]/input");
	By yesRecomandedRadioButtonLocator = By.xpath("html/body/div[1]/div[2]/form/div[3]/div/div[1]/label/input");
	By noRecomanededRadioButtonLocator = By.xpath("html/body/div[1]/div[2]/form/div[3]/div/div[2]/label/input");
	By textBoxLocator = By.xpath("html/body/div[1]/div[2]/form/div[4]/textarea");
	By userFirstNameLocator = By.xpath("html/body/div[1]/div[2]/form/div[5]/div[1]/input");
	By userLastNameLocator = By.xpath("html/body/div[1]/div[2]/form/div[5]/div[2]/input");
	By userEmailLocator = By.xpath("html/body/div[1]/div[2]/form/div[6]/div[1]/input");
	By phoneNumLocator = By.xpath("html/body/div[1]/div[2]/form/div[6]/div[2]/input");
	By formSbmitLocator = By.xpath("html/body/div[1]/div[2]/form/div[7]/button");
	private String correctEmailForment = "bablu2679@yahoo.com";
	private String wrongEmailForment = "bablu2679yahoocom";
	private String userFirstName = "Jone";
	private String userLastName = "Wells";
	private String phoneNumber = "2094469456";
	private String textData = "I have cheaper deal from somewhere else";
	
	   
	public FeadbackFormPage(WebDriver driver) {
		dri= driver;
		
	}
	
	public void companyTitleTest()
	{
		String companyName = dri.findElement(companyNameLocator).getText();
		if (!"ACME Vacuum Cleaner & Anvil Co.".equals(companyName)) 
			System.out.println("Company name dees not match: " + companyName );
	}

	public void positiveSignUpTest ()
	{
		dri.findElement(singuplinkLocator).click();
		WebElement ele = dri.findElement(emailLocator);
		ele.sendKeys(correctEmailForment);
		ele = dri.findElement(ageConcentLocator);
		ele.click();
		ele = dri.findElement(signUpSubmitLocator);
		ele.click();
		
	}
	
	public void negativeSignUpTest () throws InterruptedException
	{
		dri.findElement(singuplinkLocator).click();
		WebElement ele = dri.findElement(emailLocator);
		ele.sendKeys(wrongEmailForment );
		ele = dri.findElement(ageConcentLocator);
		ele.click();
		ele = dri.findElement(signUpSubmitLocator);
		ele.click();
		Thread.sleep(2000L);
		if (ele.isDisplayed())
			System.out.println(" Wrong email input");
		
	}
	
	
	public void postiveWithRecomandedYes ()
	{
		WebElement ele = dri.findElement(hearRadioButtonLocator);
		ele.click();
		ele = dri.findElement(experienceRadioButtonLocator);
		ele.click();
		ele = dri.findElement(yesRecomandedRadioButtonLocator);
		ele.click();
		ele = dri.findElement(userFirstNameLocator);
		ele.sendKeys(userFirstName);
		ele = dri.findElement(userLastNameLocator);
		ele.sendKeys(userLastName);
		ele = dri.findElement(userEmailLocator);
		ele.sendKeys(correctEmailForment);
		ele = dri.findElement(phoneNumLocator);
		ele.sendKeys(phoneNumber);
		ele = dri.findElement(formSbmitLocator);
		ele.click();
		
	}
	
	
	public void postiveWithRecomandedNo ()
	{
		WebElement ele = dri.findElement(hearRadioButtonLocator);
		ele.click();
		ele = dri.findElement(experienceRadioButtonLocator);
		ele.click();
		ele = dri.findElement(noRecomanededRadioButtonLocator);
		ele.click();
		dri.findElement(textBoxLocator).sendKeys(textData);
		ele = dri.findElement(userFirstNameLocator);
		ele.sendKeys(userFirstName);
		ele = dri.findElement(userLastNameLocator);
		ele.sendKeys(userLastName);
		ele = dri.findElement(userEmailLocator);
		ele.sendKeys(correctEmailForment);
		ele = dri.findElement(phoneNumLocator);
		ele.sendKeys(phoneNumber);
		ele = dri.findElement(formSbmitLocator);
		ele.click();
		 
	}
	
	public FeadbackFormPage negativeTestSumitFormWithoutInfo ()
	{
		WebElement ele = dri.findElement(formSbmitLocator);
		ele.click();
		return this;
	}
	
	public FeadbackFormPage negativeTestWithNoRecomandButNoWriting ()
	{
		WebElement ele = dri.findElement(hearRadioButtonLocator);
		ele.click();
		ele = dri.findElement(experienceRadioButtonLocator);
		ele.click();
		ele = dri.findElement(noRecomanededRadioButtonLocator);
		ele.click();
		
		ele = dri.findElement(userFirstNameLocator);
		ele.sendKeys(userFirstName);
		ele = dri.findElement(userLastNameLocator);
		ele.sendKeys(userLastName);
		ele = dri.findElement(userEmailLocator);
		ele.sendKeys(correctEmailForment);
		ele = dri.findElement(phoneNumLocator);
		ele.sendKeys(phoneNumber);
		ele = dri.findElement(formSbmitLocator);
		ele.click();
		return this;
	}
	
	public FeadbackFormPage negativeTestWithoutFirstName ()
	{
		WebElement ele = dri.findElement(hearRadioButtonLocator);
		ele.click();
		ele = dri.findElement(experienceRadioButtonLocator);
		ele.click();
		ele = dri.findElement(noRecomanededRadioButtonLocator);
		ele.click();
		dri.findElement(textBoxLocator).sendKeys(textData);
		
		ele = dri.findElement(userLastNameLocator);
		ele.sendKeys(userLastName);
		ele = dri.findElement(userEmailLocator);
		ele.sendKeys(correctEmailForment);
		ele = dri.findElement(phoneNumLocator);
		ele.sendKeys(phoneNumber);
		ele = dri.findElement(formSbmitLocator);
		ele.click();
		return this;
	}
	
	public FeadbackFormPage negativeTestWithoutPhoneNumber ()
	{
		WebElement ele = dri.findElement(hearRadioButtonLocator);
		ele.click();
		ele = dri.findElement(experienceRadioButtonLocator);
		ele.click();
		ele = dri.findElement(noRecomanededRadioButtonLocator);
		ele.click();
		dri.findElement(textBoxLocator).sendKeys(textData);
		ele = dri.findElement(userFirstNameLocator);
		ele.sendKeys(userFirstName);
		ele = dri.findElement(userLastNameLocator);
		ele.sendKeys(userLastName);
		ele = dri.findElement(userEmailLocator);
		ele.sendKeys(correctEmailForment);
		
		ele = dri.findElement(formSbmitLocator);
		ele.click();
		return this;
	}
}
