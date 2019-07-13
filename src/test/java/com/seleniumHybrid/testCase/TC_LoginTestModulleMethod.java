package com.seleniumHybrid.testCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.seleniumHybrid.appModule.SignIn_Action;
import com.seleniumHybrid.utils.ExcelUtils;

public class TC_LoginTestModulleMethod extends BaseClass 
{
	
	
	@Test()
	public void LoginTest() throws Exception
	{
		ExcelUtils exutl= new ExcelUtils();
		String Username;
		String Password;
		
		try 
		{	
			Username=exutl.getCellData(2, 1);
			Password=exutl.getCellData(2, 2);
			SignIn_Action s=new SignIn_Action(driver);
			s.Execute(Username,Password);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
			captureScreen(driver,"LoginTest");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	

}
