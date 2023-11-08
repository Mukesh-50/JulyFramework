package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By name=By.xpath("//input[@id='name']");
	
	By email=By.xpath("//input[@id='email']");
	
	By password=By.xpath("//input[@id='password']");
	
	By state=By.xpath("//select[@id='state']");
	
	By hobbies=By.xpath("//select[@id='hobbies']");
	
	By signUp=By.xpath("//button[normalize-space()='Sign up']");
	
	By msg=By.xpath("//div[contains(text(),'Signup successfully')]");
	
	public void registerUser(String fname,String emailAddress,String pass,String interest,String gender,String stateName,String hobbiesNames)
	{
		Utility.waitForWebElement(driver, name).sendKeys(fname);
		
		Utility.waitForWebElement(driver, email).sendKeys(emailAddress);
		
		Utility.waitForWebElement(driver, password).sendKeys(pass);
		
		Utility.waitForWebElement(driver, By.xpath("//label[normalize-space()='"+interest+"']")).click();
		
		Utility.waitForWebElement(driver, By.xpath("//input[@value='"+gender+"']")).click();
		
		Utility.selectValueFromDropDown(driver, state, stateName);
		
		Utility.selectValueFromDropDown(driver, hobbies, hobbiesNames);
		
		Utility.waitForWebElement(driver, signUp).click();
		
	}
	
	public boolean signUpMsg() 
	{
		boolean status=false;
		
		try 
		{
			status=Utility.waitForWebElement(driver, msg,15).isDisplayed();
			
		} catch (Exception e) 
		{
			
		}
		
		return status;
		
	}
	
	
	
	

}
