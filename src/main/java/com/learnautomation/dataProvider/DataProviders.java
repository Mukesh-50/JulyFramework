package com.learnautomation.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider(name = "TestData")
	public static Object [][] getData()
	{
		Object[][]arr=ExcelReader.getDataFromExcel("LoginData");
		
		return arr;
	}
	
	@DataProvider(name = "TestDataForRegistration")
	public static Object [][] getDataForRegsiterUser()
	{
		Object[][]arr=ExcelReader.getDataFromExcel("RegisterUser");
		
		return arr;
	}
	
}
