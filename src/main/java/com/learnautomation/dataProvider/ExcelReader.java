package com.learnautomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelReader 
{
	
	public static Object[][] getDataFromExcel(String sheetName)
	{

		XSSFWorkbook wbWorkbook=null;
		
		try 
		{
			wbWorkbook = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx")));
		} catch (FileNotFoundException e) 
		{
			
			Reporter.log("LOG:FAIL - File not present "+ e.getMessage(),true);
			
		} catch (IOException e) 
		{
			Reporter.log("LOG:FAIL - Could not load the file "+ e.getMessage(),true);
		}
		
		int rowCount=wbWorkbook.getSheet(sheetName).getPhysicalNumberOfRows();
		
		int cellCount=wbWorkbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		Object [][]arr=new Object[rowCount-1][cellCount];
		
		
		for(int i=1;i<rowCount;i++)
		{
			
			
			for(int j=0;j<cellCount;j++)
			{			
						String valueString="";
						
						CellType type=wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getCellType();
						
						if (type==CellType.STRING) 
						{
							valueString=wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
						}
						else if (type==CellType.NUMERIC) 
						{	
								double doubleValue=wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getNumericCellValue();	
								
								valueString=String.valueOf(doubleValue);	
								
						}else if(type==CellType.BOOLEAN)
						{
							Boolean booleanValue= wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getBooleanCellValue();
							
								valueString=String.valueOf(booleanValue);
							
						}
						else if(type==CellType.BLANK)
						{
							valueString="";
						}
									
					arr[i-1][j]=valueString;	
						
						
			}
			
		}
		
		return arr;
		
		
		
		
	}

}
