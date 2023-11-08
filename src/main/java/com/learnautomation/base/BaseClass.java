package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.learnautomation.dataProvider.ConfigReader;
import com.learnautomation.factory.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() 
	{
		Reporter.log("LOG:INFO- Running Before Class- Setting Up Browser", true);
	
		driver=BrowserFactory.getBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("appURL"));
		
		Reporter.log("LOG:INFO- Browser And Application Is Up And Running", true);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		Reporter.log("LOG:INFO- Running After Class- Closing Browser", true);
		
		BrowserFactory.closeBrowser(driver);
		
		Reporter.log("LOG:INFO- Browser Closed", true);
	}

}
