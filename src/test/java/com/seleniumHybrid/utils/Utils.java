package com.seleniumHybrid.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.seleniumHybrid.testCase.BaseClass;

public class Utils extends BaseClass {
	
	public static String getTestCaseName(String sTestCase) throws Exception 
	{
		String value = sTestCase;
		try 
		{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}
	
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception 
	{
		ReadConfig readconfig = new ReadConfig();
		String sBrowserName;
		WebDriver driver = null;
		try 
		{
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			if (sBrowserName.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString()+"\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
				Log.info("Driver selected as chrome");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				driver.get(readconfig.getApplicationURL());
				Log.info("Web application launched successfully");
			}
		} 
		catch (Exception e) 
		{
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

}
