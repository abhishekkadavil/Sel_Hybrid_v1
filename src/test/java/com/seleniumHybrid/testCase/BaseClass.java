package com.seleniumHybrid.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.seleniumHybrid.utils.Constant;
import com.seleniumHybrid.utils.ExcelUtils;
import com.seleniumHybrid.utils.Log;
import com.seleniumHybrid.utils.ReadConfig;
import com.seleniumHybrid.utils.Utils;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String TestDataPath=readconfig.getTestDataPath();
	public String TestDataSheet=readconfig.getTestDataSheetName();
	private String TestCaseName;
	private int TestCaseRow;
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup(String Browser) throws Exception 
	{
		Log.InitLog();
		Log.info("Driver is initialized");
		
		// Setting up the Test Data Excel file using Constants variables
		// For Constant Variables please see http://www.toolsqa.com/constant-variables/
		// For setting up Excel for Data driven testing, please see
		// http://www.toolsqa.com/data-driven-testing-excel-poi/
		ExcelUtils.setExcelFile(TestDataPath, TestDataSheet);
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception 
	{
		TestCaseName = this.toString();
		// From above method we get long test case name including package and class name etc.
		// The below method will refine your test case name, exactly the name use have used
		TestCaseName = Utils.getTestCaseName(this.toString());

		// Start printing the logs and printing the Test Case name
		Log.startTestCase(TestCaseName);

		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		TestCaseRow = ExcelUtils.getRowContains(TestCaseName,Constant.Col_TestCaseName);

		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(TestCaseRow);
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		Log.endTestCase(TestCaseName);
		driver.close();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	

}
