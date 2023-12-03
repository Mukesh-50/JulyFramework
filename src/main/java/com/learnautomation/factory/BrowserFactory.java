package com.learnautomation.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.learnautomation.dataProvider.ConfigReader;

public class BrowserFactory 
{
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	

	public static WebDriver getBrowser(String browserName,String appURL) {
		
		
		
		if(ConfigReader.getProperty("local").equalsIgnoreCase("true"))
			
		{
			ChromeOptions options=new ChromeOptions();
			
			if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) 
			{
				options.addArguments("--headless=new");
				
				Reporter.log("LOG:INFO - Running Test In Headless Mode",true);

			}
			driver=new ChromeDriver(options);
			
		}
		else 
		{
			if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome")) 
			{
				
				ChromeOptions options=new ChromeOptions();
				
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				capabilities.setCapability("browserName", "chrome");
				
				//capabilities.setCapability("browserVersion", "119.0");
				
				//capabilities.setCapability("platformName", "linux");
				
				if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) 
				{
					options.addArguments("--headless=new");
					
					Reporter.log("LOG:INFO - Running Test In Headless Mode",true);

				}
				
				options.merge(capabilities);
				
				//driver=new ChromeDriver(options);
				
				try 
				{
					driver=new RemoteWebDriver(new URL(ConfigReader.getProperty("gridURL")), options);
					
				} catch (MalformedURLException e) 
				{	
					System.out.println("Could not connect to Selenium Grid- Seems hub is not reachable "+e.getMessage());	
				}			
				
			}
			else if (browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("Mozila Firefox")) 
			{
				
				driver=new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("Microsoft Edge"))
			{
				
				EdgeOptions edgeOptions=new EdgeOptions();
				
				edgeOptions.addArguments("--guest");
				
				driver=new EdgeDriver(edgeOptions);
			}
			else if (browserName.equalsIgnoreCase("Safari")) 
			{
				driver=new SafariDriver();
			}
			else {
				Reporter.log("LOG:INFO - Sorry currently we do support Chrome, Firefox, Edge and Safari Browser");
			}
		}
		
		
		driver.manage().window().maximize();
				
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeout"))));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeout"))));
		
		driver.get(appURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
	
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver) 
	{
		driver.quit();
	
	}
	

}
