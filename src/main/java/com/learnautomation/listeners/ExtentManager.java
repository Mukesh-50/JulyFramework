package com.learnautomation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnautomation.helper.Utility;

public class ExtentManager 
{
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() 
	{
    	if (extent == null)
    	{
    		return createInstance();
    	}
    	else 
    	{
    		return extent;
		}
    	
        
    }
    
    public static ExtentReports createInstance() 
    {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/Automation_"+Utility.getCurrentDate()+".html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Sprint 1 Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }

}
