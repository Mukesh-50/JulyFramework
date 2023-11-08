package com.learnautomation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.dataProvider.ConfigReader;
import com.learnautomation.factory.BrowserFactory;
import com.learnautomation.helper.Utility;

public class ExtentReportListener implements ITestListener {

	ExtentReports extentReports = ExtentManager.getInstance();
	ExtentTest extentTest;

	public void onTestSuccess(ITestResult result) {

		if (ConfigReader.getProperty("screenshotOnSuccess").equalsIgnoreCase("true")) {
			extentTest.pass("Test Passed", MediaEntityBuilder
					.createScreenCaptureFromBase64String(Utility.captureScreenshotAsByte(BrowserFactory.getDriver()))
					.build());

		} else {
			extentTest.pass("Test Passed");
		}

	}

	public void onTestFailure(ITestResult result) {

		if (ConfigReader.getProperty("screenshotOnFailure").equalsIgnoreCase("true")) {
			extentTest.fail("Test Failed " + result.getThrowable().getMessage(), MediaEntityBuilder
					.createScreenCaptureFromBase64String(Utility.captureScreenshotAsByte(BrowserFactory.getDriver()))
					.build());

		} else {
			extentTest.fail("Test Failed " + result.getThrowable().getMessage());

		}

	}

	public void onTestSkipped(ITestResult result)

	{
		if (ConfigReader.getProperty("screenshotOnSkip").equalsIgnoreCase("true")) {
			extentTest.skip("Test Skipped " + result.getThrowable().getMessage(), MediaEntityBuilder
					.createScreenCaptureFromBase64String(Utility.captureScreenshotAsByte(BrowserFactory.getDriver()))
					.build());

		} else {
			extentTest.skip("Test Skipped " + result.getThrowable().getMessage());

		}

	}

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
