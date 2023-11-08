package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class HomePage 
{
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By manageOption=By.xpath("//span[normalize-space()='Manage']");
	
	private By menu=By.xpath("//img[@alt='menu']");
	
	private By signOut=By.xpath("//button[normalize-space()='Sign out']");
	
	
	public boolean isManageDisplayed()
	{
		 boolean status=Utility.waitForWebElement(driver, manageOption).isDisplayed();
	 
	    return status;
	}
	
	public void signOutFromApplication()
	{
		
		Utility.waitForWebElement(driver, menu).click();
	
		Utility.waitForWebElement(driver, signOut).click();

	}
	
	

}
