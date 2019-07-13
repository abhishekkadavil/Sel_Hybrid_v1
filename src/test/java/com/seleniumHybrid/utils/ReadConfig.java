package com.seleniumHybrid.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/Config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e) 
		{
			System.out.println("Exception: "+e.toString());
		}
	}
	
	public String getApplicationURL() 
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() 
	{
		String Username=pro.getProperty("Username");
		return Username;
	}
	
	public String getPassword() 
	{
		String Password=pro.getProperty("Password");
		return Password;
	}
	
	public String getChromePath() 
	{
		String ChromePath=pro.getProperty("ChromePath");
		return ChromePath;
	}
	
	public String getTestDataPath() 
	{
		String TestDataExcelPath=pro.getProperty("TestDataExcelPath");
		return TestDataExcelPath;
	}
	
	public String getTestDataSheetName() 
	{
		String TestDataSheetName=pro.getProperty("TestDataSheetName");
		return TestDataSheetName;
	}

}
