package com.seleniumHybrid.testCase;

import org.testng.annotations.Test;

import com.seleniumHybrid.appModule.SignIn_Action;

public class TC_LoginTestModulleMethod extends BaseClass 
{

	@Test()
	public void LoginTest() throws Exception
	{	
			SignIn_Action.Execute(TestCaseRow);
			captureScreen(driver);
	}
}
